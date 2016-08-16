package com.one.app.service.impl;

import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.one.app.Application;
import com.one.app.service.iface.AppUserService;
import com.one.app.vo.AppUserVo;
import com.one.vo.UserVo;

/**
* @author	jay  
* time:		2016年8月16日
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class AppUserServiceImplTest {

	@Autowired
	AppUserService appUserService;
	
	@Test
	public void testFindByUserName() {
		AppUserVo vo = appUserService.findByUserName("admin");
		System.out.println(vo.toString());
	}

	@Test
	public void testFindAllUsers() {
		Set<AppUserVo> users = appUserService.findAllUsers();
		for (AppUserVo appUserVo : users) {
			System.out.println(appUserVo.toString());
		}
	}

	@Test
	public void testAddUser() {
		AppUserVo vo = new AppUserVo();
		vo.setUserName("admin111");
		vo.setPassword("");
		vo.setAuthorities("admin");
		vo.setEmail("admin@one.com");
		appUserService.addUser(vo);
	}

}
