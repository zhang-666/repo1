package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.ActivityMapper;
import com.qf.dto.ActivityDTO;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.ActivityExample;
import com.qf.pojo.ActivityWithBLOBs;
import com.qf.service.ActivityService;
import com.qf.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int addActivity(ActivityDTO activityDTO) {
        ActivityWithBLOBs record = new ActivityWithBLOBs();
        BeanUtils.copyProperties(activityDTO,record);
        //解决字段不一致的问题
        try {
            Long beginTime = DateUtils.strToLong(activityDTO.getBeginTime());
            Long endTime = DateUtils.strToLong(activityDTO.getEndTime());
            record.setBeginTime(beginTime);
            record.setEndTime(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return activityMapper.insertSelective(record);
    }

    @Override
    public int delActivity(Long id) {
        return activityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateActivity(ActivityDTO activityDTO) {
        ActivityWithBLOBs record = new ActivityWithBLOBs();
        BeanUtils.copyProperties(activityDTO,record);
        //解决字段不一致的问题
        try {
            Long beginTime = DateUtils.strToLong(activityDTO.getBeginTime());
            Long endTime = DateUtils.strToLong(activityDTO.getEndTime());
            record.setBeginTime(beginTime);
            record.setEndTime(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return activityMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public ActivityDTO findById(Long id) {
        ActivityWithBLOBs activityWithBLOBs = activityMapper.selectByPrimaryKey(id);
        ActivityDTO activityDTO = new ActivityDTO();
        BeanUtils.copyProperties(activityWithBLOBs,activityDTO);
        activityDTO.setBeginTime(DateUtils.longToStr(activityWithBLOBs.getBeginTime()));
        activityDTO.setEndTime(DateUtils.longToStr(activityWithBLOBs.getEndTime()));
        return activityDTO;
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        List<ActivityDTO> list = new ArrayList<>();
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        ActivityExample example = new ActivityExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<ActivityWithBLOBs> activityWithBLOBs = activityMapper.selectByExampleWithBLOBs(example);
        for (ActivityWithBLOBs activityWithBLOB : activityWithBLOBs) {
            ActivityDTO activityDTO = new ActivityDTO();
            BeanUtils.copyProperties(activityWithBLOB,activityDTO);
            activityDTO.setBeginTime(DateUtils.longToStr(activityWithBLOB.getBeginTime()));
            activityDTO.setEndTime(DateUtils.longToStr(activityWithBLOB.getEndTime()));
            list.add(activityDTO);
        }//解决时间问题
        PageInfo<ActivityWithBLOBs> info = new PageInfo<>(activityWithBLOBs);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,list);
        return result;
    }
}
