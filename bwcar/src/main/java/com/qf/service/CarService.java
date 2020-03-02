package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.Car;

public interface CarService {

    public int addCar(Car car);
    public int delCar(Integer id);
    public int updateCar(Car car);
    public Car findById(Integer id);
    public DataGridResult findByPage(QueryDTO queryDTO);

}
