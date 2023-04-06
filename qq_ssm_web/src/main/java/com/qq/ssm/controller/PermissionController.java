package com.qq.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.qq.ssm.domain.Permission;
import com.qq.ssm.domain.Role;
import com.qq.ssm.domain.UserInfo;
import com.qq.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @GetMapping("/delPermission")
    public String delPermission(@RequestParam("id") String id){
        permissionService.delPermission(id);
        return "redirect:/permissions/findAll?pageNum=1&pageSize=5";
    }

    @GetMapping("/addPermission")
    public String addPermission(Permission permission){
        permissionService.addPermission(permission);
        return "redirect:/permissions/findAll?pageNum=1&pageSize=5";
    }

    @GetMapping("/toAddPermission")
    public String toAddPermisssion(){
        return "/permission-add";
    }

    //查询所有权限并打印
    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam("pageNum") int pageNum,
                                @RequestParam("pageSize") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Permission> all = permissionService.findAll(pageNum, pageSize);
        // 将数据分装为分页数据
        PageInfo pageInfo = new PageInfo(all);
        mv.setViewName("/permissions");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }
}
