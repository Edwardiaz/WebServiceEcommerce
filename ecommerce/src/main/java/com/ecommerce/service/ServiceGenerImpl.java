package com.ecommerce.service;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.dao.IGenericDao;

@Service
public class ServiceGenerImpl implements IGenericService{
	
private IGenericDao daoGen;
	
	@Autowired
	public ServiceGenerImpl(IGenericDao daoGen) {
		this.daoGen = daoGen;
	}
	
	@Override
	public Object saveObject(Object obj) {
		return daoGen.saveObject(obj);
	}

	@Override
	public Object updateObject(Object obj) {
			return daoGen.updateObject(obj);
	}

	@Override
	public String deleteObject(Object obj) {
		return daoGen.deleteObject(obj);
	}

	@Override
	public MultipartFile imageUpload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <Object> void saveObjectList(List<Object> obj) {
		daoGen.saveObjectList(obj);
	}

	@Override
	public List<Object> saveObjectList2(List<Object> obj) {
		return daoGen.saveObjectList2(obj);
	}


	
}
