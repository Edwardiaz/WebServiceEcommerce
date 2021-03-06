package com.ecommerce.configuration;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ecommerce.entity.*;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				
//				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/comercio?serverTimezone=CST");				
//				settings.put(Environment.USER, "root");
//				settings.put(Environment.PASS, "root");
				
				settings.put(Environment.URL, "jdbc:mysql://ubuntu-mysql.creativa.com:3306/comercio2?useSSL=false");
				settings.put(Environment.USER, "developer");
				settings.put(Environment.PASS, "rjniKzBeWObf");
				
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				//settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Address.class);
				configuration.addAnnotatedClass(BillingAddress.class);
				configuration.addAnnotatedClass(Category.class);
				configuration.addAnnotatedClass(CategoryClient.class);
				configuration.addAnnotatedClass(Client.class);
				configuration.addAnnotatedClass(ClientCategoryClient.class);
				configuration.addAnnotatedClass(Combo.class);
				configuration.addAnnotatedClass(ComboProducts.class);
				configuration.addAnnotatedClass(ConfigProducts.class);
				configuration.addAnnotatedClass(ConfigPromotions.class);
				configuration.addAnnotatedClass(Country.class);
				configuration.addAnnotatedClass(Email.class);
				configuration.addAnnotatedClass(Invoice.class);
				configuration.addAnnotatedClass(InvoiceDetail.class);
				configuration.addAnnotatedClass(Optionss.class);
				configuration.addAnnotatedClass(Orders.class);
				configuration.addAnnotatedClass(OrdersDetail.class);
				configuration.addAnnotatedClass(OrderStatus.class);
				configuration.addAnnotatedClass(Page.class);
				configuration.addAnnotatedClass(Products.class);
				configuration.addAnnotatedClass(ProductsCategory.class);
				configuration.addAnnotatedClass(ProductsConfigProducts.class);
				configuration.addAnnotatedClass(ProductsImage.class);
				configuration.addAnnotatedClass(ProductsSupplier.class);
				configuration.addAnnotatedClass(Promotions.class);
				configuration.addAnnotatedClass(Role.class);
				configuration.addAnnotatedClass(RoleOptions.class);
				configuration.addAnnotatedClass(Settings.class);
				configuration.addAnnotatedClass(State.class);
				configuration.addAnnotatedClass(Status.class);
				configuration.addAnnotatedClass(Supplier.class);
				configuration.addAnnotatedClass(Telephone.class);
				configuration.addAnnotatedClass(TimeZone.class);
				configuration.addAnnotatedClass(TypeAttribute.class);
				configuration.addAnnotatedClass(Users.class);
				configuration.addAnnotatedClass(UsersRole.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//				sessionFactory = configuration.buildSessionFactory();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}