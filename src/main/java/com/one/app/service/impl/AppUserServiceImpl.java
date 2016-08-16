package com.one.app.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.app.entity.mongo.AppUser;
import com.one.app.repository.mongo.AppUserRepository;
import com.one.app.service.iface.AppUserService;
import com.one.app.vo.AppUserVo;

/**
 * @author jay
 * @since 2016年6月8日
 */
@Service(value = "AppUserService")
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	public AppUserVo findByUserName(String userName) {
		AppUser user = appUserRepository.findByUsername(userName);
		AppUserVo userVo = null; 
		if(user != null){
			userVo = new AppUserVo();
			userVo.setId(user.getId());
			userVo.setUserName(user.getUsername());
			userVo.setPassword(user.getPassword());
		}

		return userVo;
	}

	@Override
	public Set<AppUserVo> findAllUsers() {
		List<AppUser> users = appUserRepository.findAll();

		Set<AppUserVo> userVoList = new HashSet<>();

		for (int i = 0; i < users.size(); i++) {
			AppUser user = users.get(i);
			AppUserVo userVo = new AppUserVo();
			userVo.setId(user.getId());
			userVo.setUserName(user.getUsername());
			userVo.setImg(user.getImg());

			userVoList.add(userVo);
		}

		return userVoList;
	}

	@Override
	public void addUser(AppUserVo appUserVo) {

		// check userName exist
//		UserVo vo  = findByUserName(userVo.getUserName());
//		
//		if( vo != null ){
//			throw  new MyException(100,"用户名已存在！");
//		}
		
		AppUser user = new AppUser();
		user.setUsername(appUserVo.getUserName());
		user.setPassword(appUserVo.getPassword());

		appUserRepository.save(user);

	}

}
