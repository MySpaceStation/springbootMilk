package com.hc.system.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.hc.system.admin.entity.User;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface IUserService extends IService<User> {

	boolean deleteAll();
}