package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.Users;

@Component
public class DaoUsersImpl implements IUsersDao {


	@Override
	public Users userbyId(Long id) {
		Users user = new Users();
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			user = session.get(Users.class, new Long(id));
		}
		return user;
	}
	
	@Override
	public Users getOne(Integer id) {//                                  RETRIEVE SINGLE USER IN AN OBJECT
		Users user = new Users();
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			user = session.get(Users.class, new Long(id));
		}
		return user;
	}
	
	@Override
	public List<Users> findAll() {  //                                  RETRIEVE ALL USERS IN A LIST
		List<Users> listUsers = new ArrayList<Users>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			listUsers = session.createQuery("from Users", Users.class).list();
			return listUsers;
		}
	}
	
	@Override
	public <S extends Users> S save(S entity) { //                              SAVE SINGLE ELEMENT
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Users update(Users use) {  //                             SAVE OR UPDATE SINGLE ELEMENT
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(use);
			transaction.commit();
			return use;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Users saver(Users ob) {                 //                              SAVE SINGLE ELEMENT
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(ob);
			transaction.commit();
			return ob;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void deleteById(Integer id) {                                    // DELETE SINGLE USER BY ID
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Users user = session.load(Users.class, new Long(id));
		transaction = session.beginTransaction();
		if(null != user) {
			session.delete(user);
			transaction.commit();
		}
	}

	@Override
	public void delete(Users entity) {                                    // DELETE SINGLE USER BY CLASS
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if(null != entity) {
			session.delete(entity);
			transaction.commit();
		}
	}

	@Override
	public List<Users> findAll(Sort sort) {                                // DELETE SINGLE USER BY CLASS
		return null;
	}

	@Override
	public List<Users> findAllById(Iterable<Integer> ids) {
		return null;
	}

	@Override
	public <S extends Users> List<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public void flush() {
	}

	@Override
	public <S extends Users> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Users> entities) {
	}

	@Override
	public void deleteAllInBatch() {
	}

	@Override
	public <S extends Users> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends Users> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public Page<Users> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public Optional<Users> findById(Integer id) {
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		return false;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteAll(Iterable<? extends Users> entities) {
	}

	@Override
	public void deleteAll() {
	}

	@Override
	public <S extends Users> Optional<S> findOne(Example<S> example) {
		return null;
	}

	@Override
	public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Users> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends Users> boolean exists(Example<S> example) {
		return false;
	}


	

	

}
