//package com.ecommerce.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ecommerce.dao.IrelationsDao;
//import com.ecommerce.entity.ClientCategoryClient;
//import com.ecommerce.entity.ConfigProducts;
//import com.ecommerce.entity.ConfigPromotions;
//import com.ecommerce.entity.ProductsConfigProducts;
//import com.ecommerce.entity.ProductsSupplier;
//import com.ecommerce.entity.RoleOptions;
//import com.ecommerce.entity.UsersRole;
//
//@Service
//public class ServiceRelationImpl implements IRelationService {
//
//	private IrelationsDao relDao;
//	
//	@Autowired
//	public ServiceRelationImpl(IrelationsDao relDao) {
//		this.relDao = relDao;
//	}
//	
//	@Override
//	public List<RoleOptions> findByidRole(Long id) {
//		return relDao.findByidRole(id);
//	}
//
//	@Override
//	public List<RoleOptions> findByidOptions(Long id) {
//		return relDao.findByidOptions(id);
//	}
//	//**********************************************************************************
//	@Override
//	public List<UsersRole> findByRole(Long id) {
//		return relDao.findByRole(id);
//	}
//
//	@Override
//	public List<UsersRole> findByidUsers(Long id) {
//		return relDao.findByidUsers(id);
//	}
//	//**********************************************************************************
//	@Override
//	public List<ClientCategoryClient> findByClient(Long id) {
//		return relDao.findByClient(id);
//	}
//
//	@Override
//	public List<ClientCategoryClient> findByCatClient(Long id) {
//		return relDao.findByCatClient(id);
//	}
//	//**********************************************************************************
//	@Override
//	public List<ConfigPromotions> findByPromotions(Long id) {
//		return relDao.findByPromotions(id);
//	}
//
//	@Override
//	public List<ConfigPromotions> findByProduct(Long id) {
//		return relDao.findByProduct(id);
//	}
//
//	@Override
//	public List<ConfigPromotions> findByCategory(Long id) {
//		return relDao.findByCategory(id);
//	}
//	//**********************************************************************************
//	@Override
//	public List<ProductsConfigProducts> findByProducts(Long id) {
//		return relDao.findByProducts(id);
//	}
//
//	@Override
//	public List<ProductsConfigProducts> findByConfigProducts(Long id) {
//		return relDao.findByConfigProducts(id);
//	}
//	//**********************************************************************************
//	@Override
//	public List<ConfigProducts> findByProds(Long id) {
//		return relDao.findByProds(id);
//	}
//
//	@Override
//	public List<ConfigProducts> findByTypeAttribute(Long id) {
//		return relDao.findByTypeAttribute(id);
//	}
//	//**********************************************************************************
//	@Override
//	public List<ProductsSupplier> findBySupplier(Long id) {
//		return relDao.findBySupplier(id);
//	}
//
//	@Override
//	public List<ProductsSupplier> findByProductsSup(Long id) {
//		return relDao.findBySupplier(id);
//	}
//
//}
