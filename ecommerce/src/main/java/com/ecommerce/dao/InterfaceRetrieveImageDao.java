package com.ecommerce.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entity.ProductsImage;

public interface InterfaceRetrieveImageDao {

	public List<ProductsImage> findAllProImage();
	
	public ProductsImage findByIdImage(Long id);
	
	public List<MultipartFile> getFiles();
	 
    public void setFiles(List<MultipartFile> files);
}
