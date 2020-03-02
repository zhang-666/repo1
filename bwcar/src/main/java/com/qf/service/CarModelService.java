package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarModel;

public interface CarModelService {

    public int addCarModel(CarModel carModel);

    public int delCarModel(Integer id);

    public int updateCarModel(CarModel carModel);

    public CarModel findById(Integer id);

    public DataGridResult findByPage(QueryDTO queryDTO);

}
