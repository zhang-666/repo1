package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.CarMapper;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.Car;
import com.qf.pojo.CarExample;
import com.qf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public int addCar(Car car) {
        return carMapper.insertSelective(car);
    }

    @Override
    public int delCar(Integer id) {
        return carMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCar(Car car) {
        return carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public Car findById(Integer id) {
        return carMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        CarExample example = new CarExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<Car> cars = carMapper.selectByExample(example);
        PageInfo<Car> info = new PageInfo<>(cars);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,cars);
        return result;
    }
}
