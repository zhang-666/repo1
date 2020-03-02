package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.CarParamsMapper;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarParams;
import com.qf.pojo.CarParamsExample;
import com.qf.service.CarParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CarParamServiceImpl implements CarParamService {

    @Autowired
    private CarParamsMapper carParamsMapper;

    @Override
    public int addCarParams(CarParams carParams) {
        return carParamsMapper.insertSelective(carParams);
    }

    @Override
    public void delCarParams(Integer id) {
        carParamsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCarParams(CarParams carParams) {
        return carParamsMapper.updateByPrimaryKeySelective(carParams);
    }

    @Override
    public CarParams findById(Integer id) {
        return carParamsMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        CarParamsExample example = new CarParamsExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<CarParams> carParams = carParamsMapper.selectByExample(example);
        PageInfo<CarParams> info = new PageInfo<>(carParams);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,carParams);
        return result;
    }
}
