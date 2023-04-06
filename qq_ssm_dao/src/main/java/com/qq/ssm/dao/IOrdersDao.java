package com.qq.ssm.dao;

import com.qq.ssm.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(property = "product",
                    column = "productId",
                    one = @One(select = "com.qq.ssm.dao.IProductDao.get"))
    })
    List<Orders> findAll() throws Exception;

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,property = "id" ,column = "id"), //要绑定主键，不然获取不到
            @Result(property = "product",
                    column = "productId",
                    one = @One(select = "com.qq.ssm.dao.IProductDao.get")),
            @Result(property = "member",
                    column = "memberId",
                    one = @One(select = "com.qq.ssm.dao.IMemberDao.findMemberById")),
            @Result(property = "travellers",
                    column = "id",
                    many = @Many(select = "com.qq.ssm.dao.ITraveller.findTravellersById"))
    })
    Orders findOrderById(String id);
}
