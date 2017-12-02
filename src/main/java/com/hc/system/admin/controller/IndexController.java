package com.hc.system.admin.controller;

import com.alibaba.fastjson.JSON;
import com.hc.core.base.BaseControllerCrud;
import com.hc.system.admin.entity.Person;
import com.hc.system.admin.entity.User;
import com.hc.system.admin.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by milk.huchan on 2017/3/6.
 */

@Controller
@RequestMapping("/system")
public class IndexController extends BaseControllerCrud<Long, User>{
    @Resource
    private IUserService userService;

    @GetMapping("/form")
    public String showForm(Person person) {
        return  viewName("form");
    }

    @PostMapping("/personForm")
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return  viewName("form");
        }
        return viewName("result");
    }

    @GetMapping("/session")
    @ResponseBody
    public String testSession(HttpSession httpSession){
        httpSession.setAttribute("springSession","123");
        return JSON.toJSONString("123");
    }
}
