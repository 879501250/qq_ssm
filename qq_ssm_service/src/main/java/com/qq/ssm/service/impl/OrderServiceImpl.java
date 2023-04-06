package com.qq.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.qq.ssm.dao.IOrdersDao;
import com.qq.ssm.domain.Orders;
import com.qq.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int pageNum, int pageSize) throws Exception {
        //在真正执行sql前，自动分页，pageNum：页码值；pageSize：每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return ordersDao.findAll();
    }

    @Override
    public Orders findOrderById(String id) {
        return ordersDao.findOrderById(id);
    }
}
