package com.qq.ssm.service;

import com.qq.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll(int pageNum, int pageSize) throws Exception;

    Orders findOrderById(String id);
}
