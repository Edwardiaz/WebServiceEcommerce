package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.Category;

public class CategoryDao {

JdbcTemplate template;
	
	/*metodo insertar*/
	public void saveCategory(Category cat) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(cat);
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
	public List<Category> findAllCategory(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Products", Category.class).list();	
		}
	}
	/*Teminar metodo consultarAll*/
	
	/*Metodo Eliminar*/
	public void deleteCategory(int id) {
		Transaction transaction = null;
//		Session sesion = this.sessionFactory.getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Category cat = (Category) session.load(Category.class, new Integer(id));
		transaction = session.beginTransaction();
		if (null != cat) {
			session.delete(cat);
			transaction.commit();
		}
	}
	/*Termina metodo eliminar*/
	
	/*Metodo actualizar*/
	public void updateCategory(int id) {
		Transaction transaction = null;
//		Session sesion = this.sessionFactory.getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Category cat = (Category) session.load(Category.class, new Integer(id));
		transaction = session.beginTransaction();
		if (null != cat) {
			session.update(cat);
			transaction.commit();
		}
	}
	/*Terminar metodo Actulizar*/
	
	public void findByIdProducto(int id) {
		Transaction transaction = null;
//		Session sesion = this.sessionFactory.getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Category cat = (Category) session.load(Category.class, new Integer(id));
		transaction = session.beginTransaction();
		if (null != cat) {
			session.find(Category.class, id);
			transaction.commit();
		}
	}
	
}
