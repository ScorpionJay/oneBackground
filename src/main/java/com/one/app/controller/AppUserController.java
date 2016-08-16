package com.one.app.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.app.service.iface.AppUserService;
import com.one.app.vo.AppUserVo;

/**
 * @author jay
 * @since 2016年6月7日
 */
@RestController
@RequestMapping(value = "appUser")
public class AppUserController {

	private static final Logger log = LoggerFactory.getLogger(AppUserController.class);

	@Autowired
	private AppUserService appUserService;

	@RequestMapping("/all")
	public Set<AppUserVo> getAppUsers() {
		log.info("getAppUsers");
		return appUserService.findAllUsers();
	}

}
