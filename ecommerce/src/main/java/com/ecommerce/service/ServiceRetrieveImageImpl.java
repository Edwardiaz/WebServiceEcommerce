package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.InterfaceRetrieveImageDao;
import com.ecommerce.entity.ProductsImage;

@Service
public class ServiceRetrieveImageImpl implements IRetrieveImageService{

	private InterfaceRetrieveImageDao interProIma;
	
	@Autowired
	public ServiceRetrieveImageImpl(InterfaceRetrieveImageDao interProIma) {
		this.interProIma = interProIma;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductsImage> findAllProImage() {
		return interProIma.findAllProImage();
	}

	@Override
	@Transactional(readOnly = true)
	public ProductsImage findByIdImage(Long id) {
		return interProIma.findByIdImage(id);
	}

}
