package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.Users;

@Component
public class DaoGenericImpl implements IGenericDao {

	@Override
	public Object saveObject(Object obj) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(obj);
			transaction.commit();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Object> saveObjectList2(List<Object> obj) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(obj);
			transaction.commit();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public <Object> void saveObjectList(List<Object> obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		for (Object t : obj) {
			session.save(t);
		}
	}

	@Override
	public Object updateObject(Object obj) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(obj);
			transaction.commit();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteObject(Object obj, Long id) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			obj = session.get(obj.getClass(), new Long(id));
			
			if (obj != null) {
				session.delete(obj);
				transaction.commit();
				return true;
			} else {
				return false;
			}

		}

	}

	@Override
	public MultipartFile imageUpload() {

		return null;
	}

}
