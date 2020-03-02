package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarParamType;
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
public class CarParamTypeController {

    @Autowired
    private CarParamTypeService carParamTypeService;

    @ResponseBody
    @RequestMapping("/sys/paramtype/list")
    public DataGridResult findCarParamType(QueryDTO queryDTO){
        return carParamTypeService.findByPage(queryDTO);
    }

    @ResponseBody
    @RequestMapping("/sys/paramtype/del")
    public R delCP(@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            carParamTypeService.delCarParm(id);
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/sys/paramtype/info/{id}")
    public R findById(@PathVariable("id") Integer id){
        CarParamType byId = carParamTypeService.findById(id);
        return R.ok().put("paramtype",byId);
    }

    @ResponseBody
    @RequestMapping("/sys/paramtype/save")
    public R addCarParamType(@RequestBody CarParamType carParamType){
        int i = carParamTypeService.addCarParamType(carParamType);
        return i>0?R.ok():R.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/sys/paramtype/update")
    public R updateCarParamType(@RequestBody CarParamType carParamType){
        int i = carParamTypeService.updateCarParamType(carParamType);
        return i>0?R.ok():R.error("修改失败");
    }

}
