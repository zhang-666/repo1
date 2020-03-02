package com.qf.dao;

import com.qf.pojo.DictBrandPoint;
import com.qf.pojo.DictBrandPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictBrandPointMapper {
    int countByExample(DictBrandPointExample example);

    int deleteByExample(DictBrandPointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictBrandPoint record);

    int insertSelective(DictBrandPoint record);

    List<DictBrandPoint> selectByExample(DictBrandPointExample example);

    DictBrandPoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictBrandPoint record, @Param("example") DictBrandPointExample example);

    int updateByExample(@Param("record") DictBrandPoint record, @Param("example") DictBrandPointExample example);

    int updateByPrimaryKeySelective(DictBrandPoint record);

    int updateByPrimaryKey(DictBrandPoint record);
}