package com.hc.api;

import com.hc.system.admin.entity.User;
import com.hc.system.admin.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

/**
 * Created by ThinkPad on 2017/12/2.
 */

@Path("/user")
@Api(value = "/user", description = "用户接口")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Component
public class UserApi {
    @Resource
    private IUserService userService;

    @GET
    @Path("/findAll")
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户", response = String.class, httpMethod = "GET")
    public List<User> findAll(){
        return userService.findAll();
    }

    @POST
    @Path("/createUser")
    @ApiOperation(value = "创建用户", notes = "创建用户", response = String.class, httpMethod = "POST")
    public List<User> createUser(@ApiParam(required = true, value = "用户信息") User user){
        
        return userService.findAll();
    }

}
