package com.qq.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.qq.ssm.domain.UserInfo;
import com.qq.ssm.service.IRoleServiec;
import com.qq.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleServiec roleServiec;

    //为用户删除角色
    @GetMapping("/delRole")
    public String delRole(@RequestParam("userid") String userid,
                          @RequestParam("roleid") String roleid) {
        userService.delRole(userid, roleid);
        return "redirect:/users/findUserInfo?id=" + userid;
    }

    //为用户添加角色
    @GetMapping("/addRoles")
    public String addRoles(@RequestParam("userid") String userid,
                           @RequestParam("roleid") String roleid) {
        if (roleid != "") {
            String[] sourceStrArray = roleid.split(",");
            for (int i = 0; i < sourceStrArray.length; i++) {
                userService.addRole(userid, sourceStrArray[i]);
            }
        }
        return "redirect:/users/findAll?pageNum=1&pageSize=5";
    }

    //去添加角色页面
    @GetMapping("/toAddRole")
    public ModelAndView addRole(@RequestParam("id") String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-add-role");
        mv.addObject("userid", id);
        mv.addObject("roles", roleServiec.otherRoles(id));
        return mv;
    }

    //根据id查询用户详细信息
    @GetMapping("/findUserInfo")
    public ModelAndView findUserInfo(@RequestParam("id") String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-info");
        UserInfo userInfo = userService.findById(id);
        mv.addObject("userinfo", userInfo);
        return mv;
    }

    //添加用户
    @GetMapping("/addUser")
    public String addUser(UserInfo userInfo) {
        userService.addUser(userInfo);
        return "redirect:/users/findAll?pageNum=1&pageSize=5";
    }

    //跳转到用户添加页面
    @GetMapping("/toAddUser")
    public String toAddUser() {
        return "/user-add";
    }

    //查询所有用户并打印
    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam("pageNum") int pageNum,
                                @RequestParam("pageSize") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> all = userService.findAll(pageNum, pageSize);
        // 将数据分装为分页数据
        PageInfo pageInfo = new PageInfo(all);
        mv.setViewName("/users");
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }
}
