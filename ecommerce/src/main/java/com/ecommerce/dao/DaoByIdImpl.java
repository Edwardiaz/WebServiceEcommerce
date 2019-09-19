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
	
	//*************************************************************************

	@Override
	public BillingAddress getBillingAddressById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(BillingAddress.class, new Long(id));
		}
	}

	@Override
	public Client getClientById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Client.class, new Long(id));
		}
	}

	@Override
	public ClientCategoryClient getClientCategoryClientById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(ClientCategoryClient.class, new Long(id));
		}
	}

	@Override
	public Invoice getInvoiceById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Invoice.class, new Long(id));
		}
	}

	@Override
	public InvoiceDetail getInvoiceDetailById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(InvoiceDetail.class, new Long(id));
		}
	}

	@Override
	public Orders getOrdersById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Orders.class, new Long(id));
		}
	}

	@Override
	public OrdersDetail getOrdersDetailById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(OrdersDetail.class, new Long(id));
		}
	}

	@Override
	public OrderStatus getOrderStatusById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(OrderStatus.class, new Long(id));
		}
	}

	@Override
	public CategoryClient getCategoryClientById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(CategoryClient.class, new Long(id));
		}
	}
//********************************************************************

	@Override
	public Status getStatusById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Status.class, new Long(id));
		}
	}

	@Override
	public Promotions getPromotionsById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Promotions.class, new Long(id));
		}
	}

	@Override
	public TypeAttribute getTypeAttributeById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(TypeAttribute.class, new Long(id));
		}
	}

	@Override
	public ConfigProducts getConfigProductsById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(ConfigProducts.class, new Long(id));
		}
	}

	@Override
	public ConfigPromotions getConfigPromotionsById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(ConfigPromotions.class, new Long(id));
		}
	}

	@Override
	public ProductsConfigProducts getProductsConfigProductsById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(ProductsConfigProducts.class, new Long(id));
		}
	}

	@Override
	public Supplier getSupplierById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Supplier.class, new Long(id));
		}
	}

	@Override
	public ProductsSupplier getProductsSupplierById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(ProductsSupplier.class, new Long(id));
		}
	}
	
}
