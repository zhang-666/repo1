package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarManufacturer;

public interface CarmanuFacturerService {

    public int addCarmanuFacturer(CarManufacturer carManufacturer);

    public void delCarManu(Integer id);

    public int updateCarmanuFacturer(CarManufacturer carManufacturer);

    public CarManufacturer findById(Integer id);

    public DataGridResult findByPage(QueryDTO queryDTO);

}
