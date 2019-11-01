package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.ProductsCategory;

@Component
public class CategoryProCatDaoImpl implements InterfaceCategoryDao, InterfaceProCatDao {

	@Override
	public Category saveCategory(Category cat) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(cat);
			transaction.commit();
			return cat;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Category> findAllCategory() {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			return sesion.createQuery("from Category", Category.class).list();
		}
	}

	@Override
	public Category findByIdCategory(Long id) {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			Category cat = sesion.get(Category.class, id);
			return cat;
		}
	}

	@Override
	public boolean deteleCategory(Long id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Category cat = session.get(Category.class, id);
		transaction = session.beginTransaction();
		if (null != cat) {
			session.delete(cat);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Category updateCategory(Category cat) {
		Transaction transaccion = null;
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			transaccion = sesion.beginTransaction();
			sesion.update(cat);
			transaccion.commit();
			return cat;
		}
	}
// ************************************************************* \\

	@Override
	public ProductsCategory updateProCat(ProductsCategory proCat) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(proCat);
			transaction.commit();
			return proCat;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProductsCategory findByIdProCat(Long id) {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			ProductsCategory pro = sesion.get(ProductsCategory.class, id);
			return pro;
		}
	}

	@Override
	public List<ProductsCategory> findAllProCat() {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			return sesion.createQuery("from ProductsCategory", ProductsCategory.class).list();
		}
	}

	@Override
	public ProductsCategory saveProCat(ProductsCategory procat) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(procat);
			transaction.commit();
			return procat;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteProCat(Long id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		ProductsCategory proCat = session.get(ProductsCategory.class, id);
		transaction = session.beginTransaction();
		if (null != proCat) {
			session.delete(proCat);
			transaction.commit();
			return true;
		}
		return false;
	}
}
