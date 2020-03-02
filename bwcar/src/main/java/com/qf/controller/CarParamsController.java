package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarParamType;
import com.qf.pojo.CarParams;
import com.qf.service.CarParamService;
import com.qf.service.CarParamTypeService;
import com.qf.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarParamsController {

    @Autowired
    private CarParamTypeService carParamTypeService;

    @Autowired
    private CarParamService carParamService;

    @ResponseBody
    @RequestMapping("/sys/params/list")
    public DataGridResult findCarParam(QueryDTO queryDTO){
        return carParamService.findByPage(queryDTO);
    }

    @ResponseBody
    @RequestMapping("/sys/params/del")
    public R deleteCarParams(@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            carParamService.delCarParams(id);
        }
        return R.ok();
    }

    //获取分类信息
    @ResponseBody
    @RequestMapping("/sys/params/typeall")
    public R typeAll(){
        List<CarParamType> all = carParamTypeService.findAll();
        return R.ok().put("sites",all);
    }


    @ResponseBody
    @RequestMapping("/sys/params/info/{id}")
    public R findById(@PathVariable("id") Integer id){
        CarParams byId = carParamService.findById(id);
        return R.ok().put("params",byId);
    }

    @ResponseBody
    @RequestMapping("/sys/params/save")
    public R addCarParams(@RequestBody CarParams carParams){
        int i = carParamService.addCarParams(carParams);
        return i>0?R.ok():R.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/sys/params/update")
    public R updateCarParams(@RequestBody CarParams carParams){
        int i = carParamService.updateCarParams(carParams);
        return i>0?R.ok():R.error("修改失败");
    }


}
