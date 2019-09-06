package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.RoleOptions;

@Component
public class DaoRoleOptionsImpl implements IRoleOptionsDao{

	@Override
	public List<RoleOptions> findAll() {
		List<RoleOptions> list = new ArrayList<RoleOptions>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from RoleOptions", RoleOptions.class).list();
			return list;
		}
	}

	@Override
	public RoleOptions getOne(Long id) {
		RoleOptions object = new RoleOptions();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			object = session.get(RoleOptions.class, new Long(id));
		}
		return object;
	}

}
