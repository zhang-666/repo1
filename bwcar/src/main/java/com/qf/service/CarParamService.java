package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarParams;

public interface CarParamService {

    public int addCarParams(CarParams carParams);
    public void delCarParams(Integer id);
    public int updateCarParams(CarParams carParams);
    public CarParams findById(Integer id);
    public DataGridResult findByPage(QueryDTO queryDTO);



}
