package com.hc.ws;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by milk.huchan on 2017/3/10.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/show", method = RequestMethod.POST)
    @ApiOperation(value = "测试接口", notes = "测试接口详细描述")
    public String show(@ApiParam(required = true, name = "name", value = "姓名")@RequestParam(name = "name")String stuName){
        return "success";
    }
}
