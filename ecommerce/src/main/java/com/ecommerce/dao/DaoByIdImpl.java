package com.ecommerce.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.*;

@Component
public class DaoByIdImpl implements IByIdDao {

	@Override
	public Settings getSettingsShopById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Settings.class, new Long(id));
		}
	}

	@Override
	public Email getEmailById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Email.class, new Long(id));
		}
	}

	@Override
	public State getStateById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(State.class, new Long(id));
		}
	}

	@Override
	public TimeZone getTimeZoneById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(TimeZone.class, new Long(id));
		}
	}

	@Override
	public Telephone getTelephoneById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Telephone.class, new Long(id));
		}
	}

	@Override
	public Address getAddressById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Address.class, new Long(id));
		}
	}

	@Override
	public Country getCountryById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Country.class, new Long(id));
		}
	}
	

}
