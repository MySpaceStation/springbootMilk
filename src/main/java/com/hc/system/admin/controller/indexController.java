package com.hc.system.admin.controller;

import com.hc.core.base.BaseControllerCrud;
import com.hc.system.admin.entity.User;
import com.hc.system.admin.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by milk.huchan on 2017/3/6.
 */

@Controller
@RequestMapping("/system")
public class indexController extends BaseControllerCrud<Long, User>{
    @Resource
    private IUserService userService;

    @RequestMapping("/ws")
    public String wsPage(){
        return "/ws/index";
    }
}
