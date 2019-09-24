package com.ecommerce.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface IGenericDao {
	public Object saveObject(Object obj);

	public Object updateObject(Object obj);
	
	public boolean deleteObject(Object obj);
	
	public MultipartFile imageUpload();

	public List<Object> saveObjectList2(List<Object> obj);
	
	public <Object> void saveObjectList(List<Object> obj);
	
}
