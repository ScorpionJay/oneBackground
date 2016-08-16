package com.one.app.service.iface;

import java.util.Set;

import com.one.app.vo.AppUserVo;

/**
 * @author jay
 * @since 2016年6月8日
 */
public interface AppUserService {

	
	/**
	 * 新增用户
	 * @param user
	 */
	void addUser(AppUserVo appUserVo);
	
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	AppUserVo findByUserName(String userName);
	
	/**
	 * 查找所有用户
	 * @return
	 */
	Set<AppUserVo> findAllUsers();
	
}
