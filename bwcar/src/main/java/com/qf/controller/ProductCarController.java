package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.ProductWithBLOBs;
import com.qf.service.ProductCarService;
import com.qf.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductCarController {

    @Autowired
    private ProductCarService productCarService;

    @ResponseBody
    @RequestMapping("/sys/product/list")
    public DataGridResult findByPage(QueryDTO queryDTO){
        return productCarService.findByPage(queryDTO);
    }

    @ResponseBody
    @RequestMapping("/sys/product/del")
    public R delCar(@RequestBody List<Integer> ids){
        for (Integer id : ids) {
            productCarService.delProduct(id);
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/sys/product/info/{id}")
    public R findCarByID(@PathVariable("id") Integer id){
        ProductWithBLOBs byID = productCarService.findByID(id);
        return R.ok().put("product",byID);
    }


    @ResponseBody
    @RequestMapping("/sys/product/save")
    public R addCarPro(@RequestBody ProductWithBLOBs productWithBLOBs){
        int i = productCarService.addProduct(productWithBLOBs);
        return i>0?R.ok():R.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/sys/product/update")
    public R updateCarPro(@RequestBody ProductWithBLOBs productWithBLOBs){
        int i = productCarService.updateProduct(productWithBLOBs);
        return i>0?R.ok():R.error("修改失败");
    }



}
