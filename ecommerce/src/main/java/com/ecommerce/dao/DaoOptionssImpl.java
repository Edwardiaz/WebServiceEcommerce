package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.Optionss;

@Component
public class DaoOptionssImpl implements IOptionssDao{

	@Override
	public List<Optionss> findAll() {
		List<Optionss> list = new ArrayList<Optionss>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Optionss", Optionss.class).list();
			return list;
		}
	}

	@Override
	public Optionss getOne(Long id) {
		Optionss object = new Optionss();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			object = session.get(Optionss.class, new Long(id));
		}
		return object;
	}

}
