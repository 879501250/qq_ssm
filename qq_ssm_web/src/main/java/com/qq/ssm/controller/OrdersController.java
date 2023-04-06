package com.qq.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.qq.ssm.domain.Orders;
import com.qq.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @GetMapping("orderInfo")
    public ModelAndView findOrderById(@RequestParam("id") String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders order = ordersService.findOrderById(id);
        mv.addObject("order", order);
        mv.setViewName("order-info");
        return mv;
    }

    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam("pageNum") int pageNum,
                                @RequestParam("pageSize") int pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> all = ordersService.findAll(pageNum, pageSize);
        // 将数据分装为分页数据
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("order-list");
        return mv;
    }

    @RequestMapping(value = {"/test1", "/test2"}, method = {RequestMethod.GET, RequestMethod.POST})
    void test() {

    }

    @RequestMapping(value = {"/test3"}, method = {RequestMethod.GET, RequestMethod.POST})
    <T> T test1(Class<T> c) throws InstantiationException, IllegalAccessException {
        return c.newInstance();
    }

    @RequestMapping(value = {"/test4"}, method = {RequestMethod.GET, RequestMethod.POST})
    String[] test2(String[] s, int[] ints, ArrayList<Integer> list) {
        return s;
    }
}
