package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IOptionssDao;
import com.ecommerce.entity.Optionss;

@Service
public class ServiceOptionssimpl implements IOptionssService{

	private IOptionssDao optionsDao;
	
	@Autowired
	public ServiceOptionssimpl(IOptionssDao optionsDao) {
		this.optionsDao = optionsDao;
	}
	
	@Override
	public List<Optionss> findAll() {
		return optionsDao.findAll();
	}

	@Override
	public Optionss getOne(Long id) {
		return optionsDao.getOne(id);
	}

}
