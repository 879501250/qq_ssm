package com.qq.ssm.service.impl;

import com.qq.ssm.dao.IProductDao;
import com.qq.ssm.domain.City;
import com.qq.ssm.domain.Product;
import com.qq.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //事物
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public Product get(String id) {
        return productDao.get(id);
    }

    @Override
    public int updateStatus(Product product) {
        return productDao.updateStatus(product);
    }

    @Override
    public int addProduct(Product product, City city) {
        product.setCity(city);
        return productDao.addProduct(product);
    }

    @Override
    public int updatePro(Product product, City city) {
        product.setCity(city);
        return productDao.updatePro(product);
    }

    @Override
    public int deletePro(Product product) {
        return productDao.deletePro(product);
    }
}
