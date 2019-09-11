package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
	 
    public List<MultipartFile> getFiles() {
	    return interProIma.getFiles();
    }
	 
    public void setFiles(List<MultipartFile> files) {
//	    this.crunchifyFiles = files;
        List<MultipartFile> crunchifyFiles = files;
	}

}
