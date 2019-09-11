package com.ecommerce.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entity.ProductsImage;

public interface IRetrieveImageService {

    public List<MultipartFile> getFiles();
	 
    public void setFiles(List<MultipartFile> files);
	
	public List<ProductsImage> findAllProImage();
	
	public ProductsImage findByIdImage(Long id);
	
}
