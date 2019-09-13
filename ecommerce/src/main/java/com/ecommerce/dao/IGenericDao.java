package com.ecommerce.dao;

import org.springframework.web.multipart.MultipartFile;

public interface IGenericDao {
	public Object saveObject(Object obj);

	public Object updateObject(Object obj);
	
	public String deleteObject(Object obj);
	
	public MultipartFile imageUpload();
	
}
