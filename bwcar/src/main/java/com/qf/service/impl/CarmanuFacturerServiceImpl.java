package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.CarManufacturerMapper;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarManufacturer;
import com.qf.pojo.CarManufacturerExample;
import com.qf.service.CarmanuFacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CarmanuFacturerServiceImpl implements CarmanuFacturerService {

    @Autowired
    private CarManufacturerMapper carManufacturerMapper;

    @Override
    public int addCarmanuFacturer(CarManufacturer carManufacturer) {
        return carManufacturerMapper.insertSelective(carManufacturer);
    }

    @Override
    public void delCarManu(Integer id) {
        carManufacturerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCarmanuFacturer(CarManufacturer carManufacturer) {
        return carManufacturerMapper.updateByPrimaryKeySelective(carManufacturer);
    }

    @Override
    public CarManufacturer findById(Integer id) {
        return carManufacturerMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        CarManufacturerExample example = new CarManufacturerExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<CarManufacturer> carManufacturers = carManufacturerMapper.selectByExample(example);
        PageInfo<CarManufacturer> info = new PageInfo<>(carManufacturers);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,carManufacturers);
        return result;
    }

}
