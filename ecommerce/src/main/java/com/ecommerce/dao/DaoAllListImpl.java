package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.*;

@Component
public class DaoAllListImpl implements IAllListDao {

	@Override
	public List<Settings> allSettingsShop() {
		List<Settings> list = new ArrayList<Settings>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Settings", Settings.class).list();
		return list;
		}
	}

	@Override
	public List<Email> allEmail() {
		List<Email> list = new ArrayList<Email>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Email", Email.class).list();
		return list;
		}
	}

	@Override
	public List<State> allState() {
		List<State> list = new ArrayList<State>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from State", State.class).list();
		return list;
		}
	}

	@Override
	public List<TimeZone> allTimeZone() {
		List<TimeZone> list = new ArrayList<TimeZone>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from TimeZone", TimeZone.class).list();
		return list;
		}
	}

	@Override
	public List<Telephone> allTelephone() {
		List<Telephone> list = new ArrayList<Telephone>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Telephone", Telephone.class).list();
		return list;
		}
	}

	@Override
	public List<Address> allAddress() {
		List<Address> list = new ArrayList<Address>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Address", Address.class).list();
		return list;
		}
	}

	@Override
	public List<Country> allCountry() {
		List<Country> list = new ArrayList<Country>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Country", Country.class).list();
		return list;
		}
	}
}
