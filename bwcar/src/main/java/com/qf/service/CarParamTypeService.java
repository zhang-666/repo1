package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarParamType;

import java.util.List;

public interface CarParamTypeService {

    public int addCarParamType(CarParamType carParamType);

    public void delCarParm(Integer id);

    public int updateCarParamType(CarParamType carParamType);

    public CarParamType findById(Integer id);

    public List<CarParamType> findAll();

    public DataGridResult findByPage(QueryDTO queryDTO);



}
