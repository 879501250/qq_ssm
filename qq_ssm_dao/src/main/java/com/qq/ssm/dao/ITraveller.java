package com.qq.ssm.dao;

import com.qq.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITraveller {

    @Select("select * from traveller where id in " +
            "(select travellerid from order_traveller where orderid = #{id})")
    List<Traveller> findTravellersById(String id);
}
