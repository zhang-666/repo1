package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.Car;
import com.qf.pojo.CarMake;
import com.qf.service.CarMakeService;
import com.qf.service.CarService;
import com.qf.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private CarMakeService carMakeService;

    @ResponseBody
    @RequestMapping("/sys/car/list")
    public DataGridResult findCar(QueryDTO queryDTO){
        return carService.findByPage(queryDTO);
    }

    @ResponseBody
    @RequestMapping("/sys/car/del")
    public R delCar(@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            carService.delCar(id);
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/sys/car/typeall")
    public R typeAll(){
        List<CarMake> all = carMakeService.findALL();
        return R.ok().put("sites",all);
    }

    @ResponseBody
    @RequestMapping("/sys/car/info/{id}")
    public R findById(@PathVariable("id") Integer id){
        Car byId = carService.findById(id);
        return R.ok().put("car",byId);
    }

    @ResponseBody
    @RequestMapping("/sys/car/save")
    public R addCar(@RequestBody Car car){
        int i = carService.addCar(car);
        return i>0?R.ok():R.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/sys/car/update")
    public R updateCar(@RequestBody Car car){
        int i = carService.updateCar(car);
        return i>0?R.ok():R.error("修改失败");
    }

}
