package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.CarMakeMapper;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarMake;
import com.qf.pojo.CarMakeExample;
import com.qf.service.CarMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CarMakeServiceImpl implements CarMakeService {

    @Autowired
    private CarMakeMapper carMakeMapper;

    @Override
    public int addCarMake(CarMake carMake) {
        int i = carMakeMapper.insertSelective(carMake);
        return i;
    }

    @Override
    public void delCarMake(Integer id) {
        carMakeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCarMake(CarMake carMake) {
        return carMakeMapper.updateByPrimaryKeySelective(carMake);
    }

    @Override
    public CarMake findById(Integer id) {
        return carMakeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CarMake> findALL() {
        return carMakeMapper.selectByExample(null);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        CarMakeExample example = new CarMakeExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<CarMake> carMakes = carMakeMapper.selectByExample(example);
        PageInfo<CarMake> info = new PageInfo<>(carMakes);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,carMakes);
        return result;
    }
}
