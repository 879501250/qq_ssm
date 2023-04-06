package com.qq.ssm.service.impl;

import com.qq.ssm.dao.ICityDao;
import com.qq.ssm.domain.City;
import com.qq.ssm.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements ICityService {

    @Autowired
    private ICityDao cityDao;

    @Override
    public List<City> findAll() throws Exception {
        return cityDao.findAll();
    }

    @Override
    public City get(String cid) {
        return cityDao.get(cid);
    }
}
