package com.qf.dao;

import com.qf.pojo.SdkInterfaceParm;
import com.qf.pojo.SdkInterfaceParmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdkInterfaceParmMapper {
    int countByExample(SdkInterfaceParmExample example);

    int deleteByExample(SdkInterfaceParmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SdkInterfaceParm record);

    int insertSelective(SdkInterfaceParm record);

    List<SdkInterfaceParm> selectByExample(SdkInterfaceParmExample example);

    SdkInterfaceParm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SdkInterfaceParm record, @Param("example") SdkInterfaceParmExample example);

    int updateByExample(@Param("record") SdkInterfaceParm record, @Param("example") SdkInterfaceParmExample example);

    int updateByPrimaryKeySelective(SdkInterfaceParm record);

    int updateByPrimaryKey(SdkInterfaceParm record);
}