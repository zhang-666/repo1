package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarMake;
import com.qf.pojo.CarModel;
import com.qf.service.CarMakeService;
import com.qf.service.CarModelService;
import com.qf.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarModelController {

    @Autowired
    private CarModelService carModelService;
    @Autowired
    private CarMakeService carMakeService;

    @ResponseBody
    @RequestMapping("/sys/model/list")
    public DataGridResult findCarPage(QueryDTO queryDTO){
        return carModelService.findByPage(queryDTO);
    }

    @ResponseBody
    @RequestMapping("/sys/model/del")
    public R deleteCarModel(@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            carModelService.delCarModel(id);
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/sys/model/typeall")
    public R typeAll(){
        List<CarMake> all = carMakeService.findALL();
        return R.ok().put("sites",all);
    }

    @ResponseBody
    @RequestMapping("/sys/model/info/{id}")
    public R findById(@PathVariable("id") Integer id){
        CarModel byId = carModelService.findById(id);
        return R.ok().put("model",byId);
    }

    @ResponseBody
    @RequestMapping("/sys/model/save")
    public R addCarModel(@RequestBody CarModel carModel){
        int i = carModelService.addCarModel(carModel);
        return i>0?R.ok():R.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/sys/model/update")
    public R updateCarModel(@RequestBody CarModel carModel){
        int i = carModelService.updateCarModel(carModel);
        return i>0?R.ok():R.error("修改失败");
    }

}
