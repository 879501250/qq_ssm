package com.qq.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.qq.ssm.domain.Permission;
import com.qq.ssm.domain.Role;
import com.qq.ssm.service.IRoleServiec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleServiec roleServiec;

    //为用户添加角色
    @GetMapping("/addPermissions")
    public String addPermissions(@RequestParam("permissionid") String permissionid,
                           @RequestParam("roleid") String roleid) {
        if (roleid != "") {
            String[] sourceStrArray = permissionid.split(",");
            for (int i = 0; i < sourceStrArray.length; i++) {
                roleServiec.addPermissions(roleid, sourceStrArray[i]);
            }
        }
        return "redirect:/roles/findAll?pageNum=1&pageSize=5";
    }

    //为用户删除角色
    @GetMapping("/delPermission")
    public String delPermission(@RequestParam("roleid") String roleid,
                          @RequestParam("permissionid") String permissionid) {
        roleServiec.delPermission(roleid, permissionid);
        return "redirect:/roles/toRolePage?id=" + roleid;
    }

    @GetMapping("/delRole")
    public String delRole(@RequestParam("id") String id){
        roleServiec.delRole(id);
        return "redirect:/roles/findAll?pageNum=1&pageSize=5";
    }

    @GetMapping("/addRole")
    public String addRole(Role role){
        roleServiec.addRole(role);
        return "redirect:/roles/findAll?pageNum=1&pageSize=5";
    }

    @GetMapping("/toRolePage")
    public ModelAndView toAddRole(@RequestParam("id")String id){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("role-info");
        mv.addObject("role",roleServiec.findById(id));
        return mv;
    }

    @GetMapping("/toAddPermission")
    public ModelAndView toAddPermission(@RequestParam("id")String id){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("role-add-permission");
        mv.addObject("roleid", id);
        mv.addObject("permissions",roleServiec.otherpermissions(id));
        return mv;
    }

    @GetMapping("/toAddRole")
    public String toAddRole(){
        return "/role-add";
    }

    //查询所有角色并打印
    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam("pageNum") int pageNum,
                                @RequestParam("pageSize") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Role> all = roleServiec.findAll(pageNum, pageSize);
        // 将数据分装为分页数据
        PageInfo pageInfo = new PageInfo(all);
        mv.setViewName("/roles");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }
}
