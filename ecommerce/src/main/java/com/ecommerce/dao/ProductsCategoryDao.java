package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.ProductsCategory;

public class ProductsCategoryDao {

	JdbcTemplate template;
	
	public void savePC(ProductsCategory proCat) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(proCat);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			System.out.println("El error ess::::::::::: "+e);
		}
	}
	
	public List<ProductsCategory> findAllProCat(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) { 
			return session.createQuery("from ProductsCategory", ProductsCategory.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*metodo por id*/
	public ProductsCategory findByIdProCat(int id){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) { 
			return session.createQuery("from ProductsCategory", ProductsCategory.class).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*fin metodo por id*/
	
	public void deleteProCat(int id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		ProductsCategory proCat = (ProductsCategory)session.load(ProductsCategory.class, new Integer(id));
		transaction = session.beginTransaction();
		if(proCat != null) {
			session.delete(proCat);
			transaction.commit();
		}
	}
	
	public void updateProCat(int id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		ProductsCategory proCat = (ProductsCategory)session.load(ProductsCategory.class, new Integer(id));
		transaction = session.beginTransaction();
		if(proCat != null) {
			session.update(proCat);
			transaction.commit();
		}
	}
	
	
}
