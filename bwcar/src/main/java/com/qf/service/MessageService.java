package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.Message;

public interface MessageService {

    public int addMessage(Message message);
    public int delMessage(Long id);
    public int updateMessage(Message message);
    public Message findById(Long id);
    public DataGridResult findByPage(QueryDTO queryDTO);


}
