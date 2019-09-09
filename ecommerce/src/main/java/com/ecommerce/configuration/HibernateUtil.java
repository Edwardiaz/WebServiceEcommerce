package com.ecommerce.configuration;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.CategoryClient;
import com.ecommerce.entity.Client;
import com.ecommerce.entity.ClientCategoryClient;
import com.ecommerce.entity.Invoice;
import com.ecommerce.entity.InvoiceDetail;
import com.ecommerce.entity.Optionss;
import com.ecommerce.entity.Page;
import com.ecommerce.entity.Products;
import com.ecommerce.entity.ProductsCategory;
import com.ecommerce.entity.Role;
import com.ecommerce.entity.RoleOptions;
import com.ecommerce.entity.Users;
import com.ecommerce.entity.UsersRole;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://ubuntu-mysql.creativa.com:3306/comercio2?useSSL=false");
				settings.put(Environment.USER, "developer");
				settings.put(Environment.PASS, "rjniKzBeWObf");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				//settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Products.class);
				configuration.addAnnotatedClass(Category.class);
				configuration.addAnnotatedClass(ProductsCategory.class);
				configuration.addAnnotatedClass(Users.class);
				configuration.addAnnotatedClass(Client.class);
				configuration.addAnnotatedClass(Optionss.class);
				configuration.addAnnotatedClass(Page.class);
				configuration.addAnnotatedClass(Role.class);
				configuration.addAnnotatedClass(RoleOptions.class);
				configuration.addAnnotatedClass(Invoice.class);
				configuration.addAnnotatedClass(InvoiceDetail.class);
				configuration.addAnnotatedClass(ClientCategoryClient.class);
				configuration.addAnnotatedClass(CategoryClient.class);
				configuration.addAnnotatedClass(UsersRole.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//				sessionFactory = configuration.buildSessionFactory();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}