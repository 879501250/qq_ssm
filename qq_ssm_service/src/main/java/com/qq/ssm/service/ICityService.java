package com.qq.ssm.service;

import com.qq.ssm.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICityService {
    List<City> findAll() throws Exception;

    City get(String cid);
}
