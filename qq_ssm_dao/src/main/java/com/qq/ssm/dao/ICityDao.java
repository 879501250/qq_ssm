package com.qq.ssm.dao;

import com.qq.ssm.domain.City;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ICityDao {

    //查询所有的城市信息
    @Select("select * from city")
    List<City> findAll() throws Exception;

    //根据cid查询城市信息
    @Select("select * from city where cid = #{cid}")
    City get(@Param("cid") String cid);
}
