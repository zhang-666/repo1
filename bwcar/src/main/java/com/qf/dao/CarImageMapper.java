package com.qf.dao;

import com.qf.pojo.CarImage;
import com.qf.pojo.CarImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarImageMapper {
    int countByExample(CarImageExample example);

    int deleteByExample(CarImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarImage record);

    int insertSelective(CarImage record);

    List<CarImage> selectByExample(CarImageExample example);

    CarImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarImage record, @Param("example") CarImageExample example);

    int updateByExample(@Param("record") CarImage record, @Param("example") CarImageExample example);

    int updateByPrimaryKeySelective(CarImage record);

    int updateByPrimaryKey(CarImage record);
}