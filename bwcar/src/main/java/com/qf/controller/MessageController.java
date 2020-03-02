package com.qf.controller;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.Message;
import com.qf.service.MessageService;
import com.qf.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping("/sys/message/list")
    public DataGridResult findMessage(QueryDTO queryDTO){
        return  messageService.findByPage(queryDTO);
    }

    @ResponseBody
    @RequestMapping("/sys/message/del")
    public R delMes(@RequestBody List<Long> ids){
        for (Long id : ids) {
            messageService.delMessage(id);
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/sys/message/info/{id}")
    public R findById(@PathVariable("id") Long id){
        Message byId = messageService.findById(id);
        return R.ok().put("message",byId);
    }

    @ResponseBody
    @RequestMapping("/sys/message/save")
    public R addMsg(@RequestBody Message message){
        int i = messageService.addMessage(message);
        return i>0?R.ok():R.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/sys/message/update")
    public R updateMsg(@RequestBody Message message){
        int i = messageService.updateMessage(message);
        return i>0?R.ok():R.error("修改失败");
    }

}
