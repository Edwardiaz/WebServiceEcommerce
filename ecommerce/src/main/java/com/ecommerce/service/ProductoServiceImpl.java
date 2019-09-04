package com.ecommerce.service;

import java.util.List;

//import javax.persistence.EntityManager;
//import com.demo.dao.ProductoDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.InterfaceProductoDao;
import com.ecommerce.entity.Products;

@Service
public class ProductoServiceImpl implements ProductoService {

	private InterfaceProductoDao interProDao;

	// inyeccion de dependencias
	@Autowired
	public ProductoServiceImpl(InterfaceProductoDao interProDao) {
		this.interProDao = interProDao;
	}

	// CRUD

	// metodo guardar
	@Override
	public Products saveProducts(Products pro) {
		return interProDao.save(pro);
	}

	// metodo find All
	@Override
	@Transactional(readOnly = true)
	public List<Products> findAll() {
		return interProDao.findAll();
	}

	// metodo delete
	@Override
	public String deletePro(Long id) {
		return interProDao.deletePro(id);
	}

	// metodo find por id
	@Override
	public Products findByIdProducts(Long id) {
		return interProDao.findByIdProducts(id);
	}

	// metodo update
	@Override
	public Products updateProducts(Products pro) {
		return interProDao.updateProducts(pro);
	}

}
