package com.hc.system.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hc.mapper.UserMapper;
import com.hc.system.admin.entity.User;
import com.hc.system.admin.service.IUserService;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Override
	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

	@Override
	public List<User> findAll() {
		List<User> userList = Lists.newArrayList();
		User user1 = new User(1L, "张三", 17, 1);
		User user2 = new User(2L, "李四", 18, 1);
		userList.add(user1);
		userList.add(user2);
		return userList;
	}
}