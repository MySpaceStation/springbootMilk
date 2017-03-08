package com.hc.system.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.hc.system.admin.entity.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * User 表数据服务层接口
 *
 */
@Path("/user")
public interface IUserService extends IService<User> {

	boolean deleteAll();

	@GET
    @Path("/findAll")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	List<User> findAll();
}