package com.hc.system.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hc.mapper.UserMapper;
import com.hc.system.admin.entity.User;
import com.hc.system.admin.service.IUserService;
import org.springframework.stereotype.Service;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Override
	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

}