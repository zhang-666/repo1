package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.CarModelMapper;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarModel;
import com.qf.pojo.CarModelExample;
import com.qf.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    private CarModelMapper carModelMapper;

    @Override
    public int addCarModel(CarModel carModel) {
        return carModelMapper.insertSelective(carModel);
    }

    @Override
    public int delCarModel(Integer id) {
        return carModelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCarModel(CarModel carModel) {
        return carModelMapper.updateByPrimaryKeySelective(carModel);
    }

    @Override
    public CarModel findById(Integer id) {
        return carModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        CarModelExample example = new CarModelExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<CarModel> carModels = carModelMapper.selectByExample(example);
        PageInfo<CarModel> info = new PageInfo<>(carModels);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,carModels);
        return result;
    }
}
