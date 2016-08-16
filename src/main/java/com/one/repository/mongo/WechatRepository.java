package com.one.repository.mongo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.one.entity.mongo.User;

/**
 * @author Jay
 * @since 2016年6月8日
 */
public interface WechatRepository extends PagingAndSortingRepository<User, String> {
	
	
	
	
}
