package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.CarMake;
import com.qf.pojo.CarManufacturer;
import com.qf.service.CarMakeService;
import com.qf.service.CarmanuFacturerService;
import com.qf.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarmanuFacturerController {

    @Autowired
    private CarmanuFacturerService carmanuFacturerService;
    @Autowired
    private CarMakeService carMakeService;

    @ResponseBody
    @RequestMapping("/sys/manufacturer/list")
    public DataGridResult findCarManu(QueryDTO queryDTO){
        return carmanuFacturerService.findByPage(queryDTO);
    }

    @ResponseBody
    @RequestMapping("/sys/manufacturer/del")
    public R delCarManu(@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            carmanuFacturerService.delCarManu(id);
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/sys/manufacturer/typeall")
    public R carType(){
        List<CarMake> all = carMakeService.findALL();
        return R.ok().put("sites",all);
    }

    @ResponseBody
    @RequestMapping("/sys/manufacturer/info/{id}")
    public R findById(@PathVariable("id") Integer id){
        CarManufacturer byId = carmanuFacturerService.findById(id);
        return R.ok().put("manufacturer",byId);
    }

    @ResponseBody
    @RequestMapping("/sys/manufacturer/save")
    public R addCarManu(@RequestBody CarManufacturer carManufacturer){
        int i = carmanuFacturerService.addCarmanuFacturer(carManufacturer);
        return i>0?R.ok():R.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/sys/manufacturer/update")
    public R updateCarManu(@RequestBody CarManufacturer carManufacturer){
        int i = carmanuFacturerService.updateCarmanuFacturer(carManufacturer);
        return i>0?R.ok():R.error("修改失败");
    }


}
