package com.one.service.iface;

/**
 * File接口
 * @author 		Jay
 * @time		2015年6月3日
 */
public interface FileService {
	
	String save(byte[] content, String filename);
	
	byte[] get(String fileName);
	
	/**
	 * get file by id
	 * @param id
	 * @return
	 */
	byte[] getFileById(String id);
	
	void delete(String fileName);
	
}

