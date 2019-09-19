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
	//**************************************************************

	@Override
	public List<BillingAddress> allBillingAddress() {
		List<BillingAddress> list = new ArrayList<BillingAddress>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from BillingAddress", BillingAddress.class).list();
		return list;
		}
	}

	@Override
	public List<Client> allClient() {
		List<Client> list = new ArrayList<Client>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Client", Client.class).list();
		return list;
		}
	}

	@Override
	public List<ClientCategoryClient> allClientCategoryClient() {
		List<ClientCategoryClient> list = new ArrayList<ClientCategoryClient>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ClientCategoryClient", ClientCategoryClient.class).list();
		return list;
		}
	}

	@Override
	public List<Invoice> allInvoice() {
		List<Invoice> list = new ArrayList<Invoice>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Invoice", Invoice.class).list();
		return list;
		}
	}

	@Override
	public List<InvoiceDetail> allInvoiceDetail() {
		List<InvoiceDetail> list = new ArrayList<InvoiceDetail>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from InvoiceDetail", InvoiceDetail.class).list();
		return list;
		}
	}

	@Override
	public List<Orders> allOrders() {
		List<Orders> list = new ArrayList<Orders>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Orders", Orders.class).list();
		return list;
		}
	}

	@Override
	public List<OrdersDetail> allOrdersDetail() {
		List<OrdersDetail> list = new ArrayList<OrdersDetail>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from OrdersDetail", OrdersDetail.class).list();
		return list;
		}
	}

	@Override
	public List<OrderStatus> allOrderStatus() {
		List<OrderStatus> list = new ArrayList<OrderStatus>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from OrderStatus", OrderStatus.class).list();
		return list;
		}
	}

	@Override
	public List<CategoryClient> allCategoryClient() {
		List<CategoryClient> list = new ArrayList<CategoryClient>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from CategoryClient", CategoryClient.class).list();
		return list;
		}
	}
	//**********************************************************************************

	@Override
	public List<Status> allStatus() {
		List<Status> list = new ArrayList<Status>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Status", Status.class).list();
		return list;
		}
	}

	@Override
	public List<Promotions> allPromotions() {
		List<Promotions> list = new ArrayList<Promotions>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Promotions", Promotions.class).list();
		return list;
		}
	}

	@Override
	public List<TypeAttribute> allTypeAttribute() {
		List<TypeAttribute> list = new ArrayList<TypeAttribute>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from TypeAttribute", TypeAttribute.class).list();
		return list;
		}
	}

	@Override
	public List<ConfigProducts> allConfigProducts() {
		List<ConfigProducts> list = new ArrayList<ConfigProducts>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ConfigProducts", ConfigProducts.class).list();
		return list;
		}
	}

	@Override
	public List<ConfigPromotions> allConfigPromotions() {
		List<ConfigPromotions> list = new ArrayList<ConfigPromotions>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ConfigPromotions", ConfigPromotions.class).list();
		return list;
		}
	}

	@Override
	public List<ProductsConfigProducts> allProductsConfigProducts() {
		List<ProductsConfigProducts> list = new ArrayList<ProductsConfigProducts>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ProductsConfigProducts", ProductsConfigProducts.class).list();
		return list;
		}
	}

	@Override
	public List<Supplier> allSupplier() {
		List<Supplier> list = new ArrayList<Supplier>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from Supplier", Supplier.class).list();
		return list;
		}
	}

	@Override
	public List<ProductsSupplier> allProductsSupplier() {
		List<ProductsSupplier> list = new ArrayList<ProductsSupplier>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery("from ProductsSupplier", ProductsSupplier.class).list();
		return list;
		}
	}
	
}
