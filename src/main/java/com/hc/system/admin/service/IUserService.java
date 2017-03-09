package com.hc.system.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.hc.system.admin.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * User 表数据服务层接口
 *
 */
@Path("/user")
@Api(value = "/user", description = "用户接口")
public interface IUserService extends IService<User> {

	boolean deleteAll();

	@GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户", response = String.class, httpMethod = "GET")
    List<User> findAll();
}