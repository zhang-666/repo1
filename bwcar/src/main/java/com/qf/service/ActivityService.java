package com.qf.service;

import com.qf.dto.ActivityDTO;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;

public interface ActivityService {

    public int addActivity(ActivityDTO activityDTO);

    public int delActivity(Long id);

    public int updateActivity(ActivityDTO activityDTO);

    public ActivityDTO findById(Long id);

    public DataGridResult findByPage(QueryDTO queryDTO);



}
