package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.ProductsImage;

@Component
public class RetrieveImageDaoImpl implements InterfaceRetrieveImageDao{

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

}
