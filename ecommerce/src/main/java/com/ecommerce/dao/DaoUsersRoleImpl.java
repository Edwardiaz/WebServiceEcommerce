package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.UsersRole;

@Component
public class DaoUsersRoleImpl implements IUsersRoleDao {

	@Override
	public List<UsersRole> findAll() {
		List<UsersRole> list = new ArrayList<UsersRole>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from UsersRole", UsersRole.class).list();
			return list;
		}
	}

	@Override
	public UsersRole getOne(Long id) {
		UsersRole object = new UsersRole();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			object = session.get(UsersRole.class, new Long(id));
		}
		return object;
	}

}
