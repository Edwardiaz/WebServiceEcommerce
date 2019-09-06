package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.Page;

@Component
public class DaoPageImpl implements IPageDao{

	@Override
	public Page getOne(Long id) {
		Page page = new Page();
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			page = session.get(Page.class, new Long(id));
		}
		return page;
	}

	@Override
	public List<Page> findAll() {
		List<Page> listPage = new ArrayList<Page>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			listPage = session.createQuery("from Page", Page.class).list();
			return listPage;
		}
	}
	
	@Override
	public Page saver(Page p) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(p);
			transaction.commit();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return p;
		}
	}

	@Override
	public Page update(Page p) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(p);
			transaction.commit();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void deletePageById(Long id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Page page = session.load(Page.class, new Long(id));
		transaction = session.beginTransaction();
		if(null != page) {
			session.delete(page);
			transaction.commit();
		}
	}

}
