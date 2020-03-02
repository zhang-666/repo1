package com.qf.dao;

import com.qf.pojo.CarModel;
import com.qf.pojo.CarModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarModelMapper {
    int countByExample(CarModelExample example);

    int deleteByExample(CarModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarModel record);

    int insertSelective(CarModel record);

    List<CarModel> selectByExample(CarModelExample example);

    CarModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarModel record, @Param("example") CarModelExample example);

    int updateByExample(@Param("record") CarModel record, @Param("example") CarModelExample example);

    int updateByPrimaryKeySelective(CarModel record);

    int updateByPrimaryKey(CarModel record);
}