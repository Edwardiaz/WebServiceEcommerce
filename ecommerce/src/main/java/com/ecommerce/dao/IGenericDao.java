package com.ecommerce.dao;

//import java.util.List;

public interface IGenericDao {
	public Object saveObject(Object obj);

	public Object updateObject(Object obj);
	
	public String deleteObject(Object obj);
	
//	public List bringAll(Class clazz);
}
