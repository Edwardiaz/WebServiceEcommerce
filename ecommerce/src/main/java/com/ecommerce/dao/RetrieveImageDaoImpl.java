package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.ProductsImage;

@Component
public class RetrieveImageDaoImpl implements InterfaceRetrieveImageDao{
	
	private List<MultipartFile> imageFiles;
	
	@Override
	public List<ProductsImage> findAllProImage() {
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			return sesion.createQuery("from ProductsImage", ProductsImage.class).list();	
		}
	}

	@Override
	public ProductsImage findByIdImage(Long id) {
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			ProductsImage pro = sesion.get(ProductsImage.class, id);
			return pro;
		}
	}

	@Override
	public List<MultipartFile> getFiles() {
		return imageFiles;
	}

	@Override
	public void setFiles(List<MultipartFile> files) {
		this.imageFiles = files; 
	}

}
