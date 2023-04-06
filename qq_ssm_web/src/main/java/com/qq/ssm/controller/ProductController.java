package com.qq.ssm.controller;

import com.qq.ssm.domain.Product;
import com.qq.ssm.service.ICityService;
import com.qq.ssm.service.IProductService;
import com.qq.ssm.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICityService cityService;

    @ModelAttribute("products")
    public void myModelAttribute(
            @PathVariable(value = "id", required = false) String id,
            Model model) throws Exception {
        if (id != null) {
            //将数据库取到的product保存到model中给后面的使用
            Product product = productService.get(id);
            model.addAttribute("product", product);
        }
    }

    //接受json数据，并完成商品的添加操作
    //@RequestBody：接受json数据，封装为对象
    @GetMapping("/productJson")
    public String productJsonAdd(@RequestBody Product product) {
        product.setId(UUIDGenerator.getUUID()); //设置商品id
        productService.addProduct(product, cityService.get(product.getCity().getCid()));
        return "redirect:/findAll";
    }

    //接受json数据，并完成商品的修改操作
    //@RequestBody：接受json数据，封装为对象
    @GetMapping("/productJson/{id}")
    public String productJsonEdit(@RequestBody Product product) {
        productService.updatePro(product, cityService.get(product.getCity().getCid()));
        return "redirect:/findAll";
    }

    //利用表单标签完成Rest风格的添加商品操作
    @RequestMapping(value = "/productRest", method = RequestMethod.POST) //Rest风格的请求，只能处理POST请求
    public String productRestPost(Product product) {
        product.setId(UUIDGenerator.getUUID()); //设置商品id
        productService.addProduct(product, cityService.get(product.getCity().getCid()));
        return "redirect:/findAll";
    }

    //利用表单标签完成Rest风格的修改商品操作
    @RequestMapping(value = "/productRest", method = RequestMethod.PUT) //Rest风格的请求，只能处理PUT请求
    public String productRestPut(Product product) {
        productService.updatePro(product, cityService.get(product.getCity().getCid()));
        return "redirect:/findAll";
    }

    //Rest风格的删除商品操作
    @RequestMapping(value = "/productRest/{id}", method = RequestMethod.DELETE) //Rest风格的请求，只能处理DELETE请求
    public ModelAndView productRestDELETE(@ModelAttribute("product") Product product) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/findAll");
        if (product != null) {
            productService.deletePro(product);
            mv.addObject("msg", "删除成功");
        } else {
            mv.addObject("msg", "你个糟老头子坏的很");
        }
        return mv;
    }

    //查询商品Josn数据
    @ResponseBody //将返回的数据放在响应体中；如果是对象，jackson包自动转化为json格式
    @GetMapping("/query")
    public Product query(@RequestParam("id") String id) {
        return productService.get(id);
    }

    //来的商品添加页，若传入商品id，则界面修改为商品添加，并数据回显
    @GetMapping("/toProductPage")
    public ModelAndView toProductPage(@RequestParam(value = "id", required = false) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("citys", cityService.findAll());
        mv.addObject("product", new Product());
        if (id != null) {
            Product product = productService.get(id);
            if (product != null)
                mv.addObject("product", product);
            else
                mv.addObject("msg", "你个糟老头子坏得很");
        }
        mv.setViewName("product-add");
        return mv;
    }

    //查询所有产品
    @GetMapping("/findAll")
    public String findAll(Model model) throws Exception {
        List<Product> all = productService.findAll();
        model.addAttribute("products", all);
        return "products";
    }

    //根据id修改产品状态，并刷新页面
    @GetMapping("/updateStatus/{id}")
    public ModelAndView updateStatus(@ModelAttribute("product") Product product) throws Exception {
        productService.updateStatus(product);
        ModelAndView mv = new ModelAndView();
        mv.addObject("products", productService.findAll());
        System.out.println(productService.findAll().toString());
        mv.setViewName("products");
        return mv;
    }

}
