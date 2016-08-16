package com.one.app.repository.mongo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.one.app.entity.mongo.AppUser;
import com.one.entity.mongo.User;

/**
 * @author Jay
 * @time 2015年5月21日
 */
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, String> {

	/**
	 * 根据用户id获取用户
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	AppUser findByUsername(String username );

	/**
	 * 根据用户名获取用户
	 * 
	 * @param usreName
	 *            用户名
	 * @return
	 */
	List<AppUser> findAll();
}