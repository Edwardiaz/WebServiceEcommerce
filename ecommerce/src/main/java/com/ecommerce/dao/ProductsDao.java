package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.Products;

public class ProductsDao {

	JdbcTemplate template;
	
	/*metodo insertar*/
	public void saveProduct(Products pro) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(pro);
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	/*Termina metodo insertar*/
	
	/*metodo consultarAll*/
	public List<Products> findAllProducts(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Products", Products.class).list();	
		}
	}
	/*Teminar metodo consultarAll*/
	
	public Products findByIdProducts(int id){
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Products pro = (Products) session.load(Products.class, new Integer(id));
			return session.createQuery("from Products", Products.class).getSingleResult();
			
		} 
	}
	/*Metodo Eliminar*/
	public void deleteProduct(int id) {
		Transaction transaction = null;
//		Session sesion = this.sessionFactory.getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Products pro = (Products) session.load(Products.class, new Integer(id));
		transaction = session.beginTransaction();
		if (null != pro) {
			session.delete(pro);
			transaction.commit();
		}
	}
	/*Termina metodo eliminar*/
	
	/*Metodo actualizar*/
	public void updateProduct(int id) {
		Transaction transaction = null;
//		Session sesion = this.sessionFactory.getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Products pro = (Products) session.load(Products.class, new Integer(id));
		transaction = session.beginTransaction();
		if (null != pro) {
			session.update(pro);
			transaction.commit();
		}
	}
	/*Terminar metodo Actulizar*/
	
//	public void findByIdProduct(int id) {
//		Transaction transaction = null;
////		Session sesion = this.sessionFactory.getCurrentSession();
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Products pro = (Products) session.load(Products.class, new Integer(id));
//		transaction = session.beginTransaction();
//		if (null != pro) {
//			session.find(Products.class, "idProducts");
//			transaction.commit();
//		}
//	}
}
