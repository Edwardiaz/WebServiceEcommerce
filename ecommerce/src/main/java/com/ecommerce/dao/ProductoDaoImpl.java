package com.ecommerce.dao;

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
import com.ecommerce.entity.Products;

@Component
public class ProductoDaoImpl implements InterfaceProductoDao{

	@Override
	public <S extends Products> S save(S entity) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			return entity;
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Products> findAll() {
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			return sesion.createQuery("from Products", Products.class).list();	
		}
	}
	
	@Override
	public Products findByIdProducts(Long id) {
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
			Products pro = sesion.get(Products.class, id);
			return pro;
		}
	}

	@Override
	public void deleteById(Long id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Products pro = session.load(Products.class, id);
		transaction = session.beginTransaction();
		if(null != pro) {
			session.delete(pro);
			transaction.commit();
		}	
	}
	
	@Override
	public String deletePro(Long id) {
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
	
	@Override
	public Products updateProducts(Products pro) {
		Transaction transaccion = null;
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			transaccion = sesion.beginTransaction();
			sesion.update(pro);
			transaccion.commit();
			return pro;
		}
	}

	@Override
	public List<Products> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Products> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Products> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Products> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Products getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Products> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Products> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Products> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void delete(Products entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Products> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Products> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Products> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Products> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Products> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Products> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
// *************************************************** \\


	
}
