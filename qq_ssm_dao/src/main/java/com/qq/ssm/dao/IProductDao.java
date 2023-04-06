package com.qq.ssm.dao;

import com.qq.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IProductDao {

    //根据id修改产品信息
    @Update({"update product set " +
            "productNum = #{product.productNum}, " +
            "productName = #{product.productName}, " +
            "cid = #{product.city.cid}, " +
            "departureTime = #{product.departureTime}, " +
            "productPrice = #{product.productPrice}, " +
            "productDesc =#{product.productDesc}, " +
            "productStatus = #{product.productStatus} " +
            "where id = #{product.id}"})
    int updatePro(@Param("product") Product product);

    //根据id删除产品
    @Delete("delete from product where id = #{product.id}")
    int deletePro(@Param("product") Product product);

    //查询所有的产品信息
    //@Select配置查询所需要的SQL
    @Select("select * from product")
    //@Results配置结果集，查询关联对象，
    @Results({
            //@Result配置某一个字段与实体类属性之间的关系
            @Result(property = "city",//类中的属性
                    column = "cid",//数据库中的字段
                    //one表示获取关联关系中【一】的一方，在@One中，指定查询该对象的Mapper的方法（以column为参数）
                    one = @One(select = "com.qq.ssm.dao.ICityDao.get"))})
    List<Product> findAll() throws Exception;

    //根据id查询产品
    @Select("select * from product where id = #{id}")
    @Results({
            @Result(property = "city",
                    column = "cid",
                    one = @One(select = "com.qq.ssm.dao.ICityDao.get"))})
    Product get(@Param("id") String id);

    //根据id修改产品状态
    @Update({"update product set productStatus = " +
            "(CASE WHEN productStatus=1 THEN 0 ELSE 1 END) where id = #{product.id}"})
    int updateStatus(@Param("product") Product product);

    //添加新产品
    @Insert("insert into product values" +
            "(#{id},#{productNum},#{productName},#{city.cid}," +
            "#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    int addProduct(Product product);
}
