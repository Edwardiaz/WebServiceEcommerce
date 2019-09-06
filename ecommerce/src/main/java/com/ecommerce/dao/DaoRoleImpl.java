package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.Role;

@Component
public class DaoRoleImpl implements IRoleDao {

	@Override
	public List<Role> findAll() {
		List<Role> list = new ArrayList<Role>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Role", Role.class).list();
			return list;
		}
	}

	@Override
	public Role getOne(Long id) {
		Role object = new Role();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			object = session.get(Role.class, new Long(id));
		}
		return object;
	}

}
