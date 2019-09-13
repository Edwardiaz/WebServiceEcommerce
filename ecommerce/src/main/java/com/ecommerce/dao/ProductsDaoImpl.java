package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.Products;

@Component
public class ProductsDaoImpl implements InterfaceProductsDao{

	@Override
	public Products saveProduct(Products pro) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(pro);
			transaction.commit();
			return pro;
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Products saveProductsCate(Products pro) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(pro);
			transaction.commit();
			return pro;
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Products> findAllProduct() {
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			return sesion.createQuery("from Products", Products.class).list();	
		}
	}
	
	@Override
	public Products findByIdProduct(Long id) {
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			Products pro = sesion.get(Products.class, id);
			return pro;
		}
	}
	
	@Override
	public Products updateProduct(Products pro) {
		Transaction transaccion = null;
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			transaccion = sesion.beginTransaction();
			sesion.update(pro);
			transaccion.commit();
			return pro;
		}
	}

	@Override
	public String deleteProduct(Long id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Products pro = session.get(Products.class, id);
		transaction = session.beginTransaction();
		if(null != pro) {
			session.delete(pro);
			transaction.commit();
			return "ok";
		}else {
		return "error";
		}
	}

}
