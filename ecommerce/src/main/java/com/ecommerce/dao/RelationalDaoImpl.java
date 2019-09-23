package com.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.entity.ClientCategoryClient;
import com.ecommerce.entity.ConfigProducts;
import com.ecommerce.entity.ConfigPromotions;
import com.ecommerce.entity.ProductsConfigProducts;
import com.ecommerce.entity.ProductsSupplier;
import com.ecommerce.entity.RoleOptions;
import com.ecommerce.entity.UsersRole;
import com.ecommerce.service.IRelationService;

@Component
public class RelationalDaoImpl implements IRelationService{

	@Override
	public List<RoleOptions> findByidRole(Long id) {
		List<RoleOptions> list = new ArrayList<RoleOptions>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			System.out.println(" ********** Id "+id);
			list = session.createQuery("from RoleOptions where idRole = :id", RoleOptions.class).setParameter("id", id).list();
		return list;
		}
	}

	@Override
	public List<RoleOptions> findByidOptions(Long id) {
		List<RoleOptions> list = new ArrayList<RoleOptions>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from RoleOptions where idOptionss = :id", RoleOptions.class).setParameter("id", id).list();
		return list;
		}
	}
//**********************************************************************************
	@Override
	public List<UsersRole> findByRole(Long id) {
		List<UsersRole> list = new ArrayList<UsersRole>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from UsersRole where idRole = :id", UsersRole.class).setParameter("id", id).list();
		return list;
		}
	}

	@Override
	public List<UsersRole> findByidUsers(Long id) {
		List<UsersRole> list = new ArrayList<UsersRole>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from UsersRole where idUsers = :id", UsersRole.class).setParameter("id", id).list();
		return list;
		}
	}
	//**********************************************************************************
	@Override
	public List<ClientCategoryClient> findByClient(Long id) {
		List<ClientCategoryClient> list = new ArrayList<ClientCategoryClient>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ClientCategoryClient where idClient = :id", ClientCategoryClient.class).setParameter("id", id).list();
		return list;
		}
	}

	@Override
	public List<ClientCategoryClient> findByCatClient(Long id) {
		List<ClientCategoryClient> list = new ArrayList<ClientCategoryClient>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ClientCategoryClient where idCategoryClient = :id", ClientCategoryClient.class).setParameter("id", id).list();
		return list;
		}
	}
	//**********************************************************************************
	@Override
	public List<ConfigPromotions> findByPromotions(Long id) {
		List<ConfigPromotions> list = new ArrayList<ConfigPromotions>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ConfigPromotions where idPromotions = :id", ConfigPromotions.class).setParameter("id", id).list();
		return list;
		}
	}

	@Override
	public List<ConfigPromotions> findByProduct(Long id) {
		List<ConfigPromotions> list = new ArrayList<ConfigPromotions>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ConfigPromotions where idProducts = :id", ConfigPromotions.class).setParameter("id", id).list();
		return list;
		}
	}

	@Override
	public List<ConfigPromotions> findByCategory(Long id) {
		List<ConfigPromotions> list = new ArrayList<ConfigPromotions>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ConfigPromotions where idCategory = :id", ConfigPromotions.class).setParameter("id", id).list();
		return list;
		}
	}

	//**********************************************************************************
	@Override
	public List<ProductsConfigProducts> findByProducts(Long id) {
		List<ProductsConfigProducts> list = new ArrayList<ProductsConfigProducts>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ProductsConfigProducts where idProducts = :id", ProductsConfigProducts.class).setParameter("id", id).list();
		return list;
		}
	}

	@Override
	public List<ProductsConfigProducts> findByConfigProducts(Long id) {
		List<ProductsConfigProducts> list = new ArrayList<ProductsConfigProducts>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ProductsConfigProducts where idConfigProducts = :id", ProductsConfigProducts.class).setParameter("id", id).list();
		return list;
		}
	}
	//**********************************************************************************
	@Override
	public List<ConfigProducts> findByProds(Long id) {
		List<ConfigProducts> list = new ArrayList<ConfigProducts>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ConfigProducts where idProducts = :id", ConfigProducts.class).setParameter("id", id).list();
		return list;
		}
	}

	@Override
	public List<ConfigProducts> findByTypeAttribute(Long id) {
		List<ConfigProducts> list = new ArrayList<ConfigProducts>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ConfigProducts where idTypeAttribute = :id", ConfigProducts.class).setParameter("id", id).list();
		return list;
		}
	}
	//**********************************************************************************
	@Override
	public List<ProductsSupplier> findBySupplier(Long id) {
		List<ProductsSupplier> list = new ArrayList<ProductsSupplier>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ProductsSupplier where idSupplier = :id", ProductsSupplier.class).setParameter("id", id).list();
		return list;
		}
	}

	@Override
	public List<ProductsSupplier> findByProductsSup(Long id) {
		List<ProductsSupplier> list = new ArrayList<ProductsSupplier>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ProductsSupplier where idProducts = :id", ProductsSupplier.class).setParameter("id", id).list();
		return list;
		}
	}

	
}
