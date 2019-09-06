package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IPageDao;
import com.ecommerce.entity.Page;

@Service
public class ServicePageImpl implements IPageService{

private IPageDao daoPage;
	
	@Autowired
	public ServicePageImpl(IPageDao daoPage) {
		this.daoPage = daoPage;
	}
	
	@Override
	public List<Page> listPage() {
		return daoPage.findAll();
	}

	@Override
	public void savePage(Page p) {
		daoPage.saver(p);
		
	}

	@Override
	public Page updatePage(Page p) {
		daoPage.update(p);
		return null;
	}

	@Override
	public void deletePageById(Long idPage) {
		daoPage.deletePageById(idPage);
		
	}

	@Override
	public Page pagebyId(Long id) {
		return daoPage.getOne(id);
	}

	public ServicePageImpl() {
	}
	
	

//	@Override
//	public Object deleteObject(Object obj) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
