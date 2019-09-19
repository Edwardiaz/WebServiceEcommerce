package com.ecommerce.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entity.ProductsImage;

//import java.util.List;

public interface IGenericService {
	
	public Object saveObject(Object obj);

	public Object updateObject(Object obj);
	
	public String deleteObject(Object obj);
	
	public MultipartFile imageUpload();
	
	public List<Object> saveObjectList2(List<Object> obj);
	
	public <Object> void saveObjectList(List<Object> obj);

}
