package com.qf.controller;

import com.qf.dto.ActivityDTO;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.service.ActivityService;
import com.qf.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @ResponseBody
    @RequestMapping("/sys/activity/list")
    public DataGridResult findAct(QueryDTO queryDTO){
        return activityService.findByPage(queryDTO);
    }

    @ResponseBody
    @RequestMapping("/sys/activity/del")
    public R delAct(@RequestBody List<Long> ids){
        for (Long id : ids) {
            activityService.delActivity(id);
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/sys/activity/info/{id}")
    public R findActById(@PathVariable("id") Long id){
        ActivityDTO byId = activityService.findById(id);
        return R.ok().put("activity",byId);
    }

    @ResponseBody
    @RequestMapping("/sys/activity/save")
    public R addAct(@RequestBody ActivityDTO activityDTO){
        int i = activityService.addActivity(activityDTO);
        return i>0?R.ok():R.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/sys/activity/update")
    public R updateAct(@RequestBody ActivityDTO activityDTO){
        int i = activityService.updateActivity(activityDTO);
        return i>0?R.ok():R.error("修改失败");
    }

}
