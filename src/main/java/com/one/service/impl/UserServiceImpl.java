package com.one.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.entity.mongo.User;
import com.one.repository.mongo.UserRepository;
import com.one.service.iface.UserService;
import com.one.weixin.vo.UserVo;

/**
 * @author jay
 * @since 2016年6月8日
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public com.one.vo.UserVo findByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		com.one.vo.UserVo userVo = null; 
		if(user != null){
			userVo = new com.one.vo.UserVo();
			userVo.setId(user.getId());
			userVo.setUserName(user.getUserName());
			userVo.setPassword(user.getPassword());
		}

		return userVo;
	}

	@Override
	public Set<UserVo> findAllUsers() {
		List<User> users = userRepository.findAll();

		Set<UserVo> userVoList = new HashSet<>();

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			UserVo userVo = new UserVo();
			userVo.setId(user.getId());
			userVo.setUserName(user.getUserName());

			userVoList.add(userVo);
		}

		return userVoList;
	}

	@Override
	public void addUser(UserVo userVo) {

		// check userName exist
//		UserVo vo  = findByUserName(userVo.getUserName());
//		
//		if( vo != null ){
//			throw  new MyException(100,"用户名已存在！");
//		}
		
		User user = new User();
		user.setUserName(userVo.getUserName());
		user.setPassword(userVo.getPassword());

		userRepository.save(user);

	}

}
