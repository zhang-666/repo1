package com.qf.dao;

import com.qf.pojo.VisitLog;
import com.qf.pojo.VisitLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitLogMapper {
    int countByExample(VisitLogExample example);

    int deleteByExample(VisitLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VisitLog record);

    int insertSelective(VisitLog record);

    List<VisitLog> selectByExample(VisitLogExample example);

    VisitLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VisitLog record, @Param("example") VisitLogExample example);

    int updateByExample(@Param("record") VisitLog record, @Param("example") VisitLogExample example);

    int updateByPrimaryKeySelective(VisitLog record);

    int updateByPrimaryKey(VisitLog record);
}