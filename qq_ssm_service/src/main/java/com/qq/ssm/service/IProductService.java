package com.qq.ssm.service;

import com.qq.ssm.domain.City;
import com.qq.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll() throws Exception;

    Product get(String id);

    int updateStatus(Product product);

    int addProduct(Product product, City city);

    int updatePro(Product product, City city);

    int deletePro(Product product);
}
