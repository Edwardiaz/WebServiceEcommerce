package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.ClientCategoryClient;
import com.ecommerce.entity.ConfigProducts;
import com.ecommerce.entity.ConfigPromotions;
import com.ecommerce.entity.ProductsCategory;
import com.ecommerce.entity.ProductsConfigProducts;
import com.ecommerce.entity.ProductsImage;
import com.ecommerce.entity.ProductsSupplier;
import com.ecommerce.entity.RoleOptions;
import com.ecommerce.entity.UsersRole;

public interface IRelationService {
	public List<RoleOptions> findByidRole(Long id);
	public List<RoleOptions> findByidOptions(Long id);
	
	public List<UsersRole> findByRole(Long id);
	public List<UsersRole> findByidUsers(Long id);
	
	public List<ClientCategoryClient> findByClient(Long id);
	public List<ClientCategoryClient> findByCatClient(Long id);
	
	public List<ConfigPromotions> findByPromotions(Long id);
	public List<ConfigPromotions> findByProduct(Long id);
	public List<ConfigPromotions> findByCategory(Long id);
	
	public List<ProductsConfigProducts> findByProducts(Long id);
	public List<ProductsConfigProducts> findByConfigProducts(Long id);
	
	public List<ConfigProducts> findByProds(Long id);
	public List<ConfigProducts> findByTypeAttribute(Long id);
	
	public List<ProductsSupplier> findBySupplier(Long id);
	public List<ProductsSupplier> findByProductsSup(Long id);
	
	public List<ProductsImage> findByidProducts(Long id);
	public List<ProductsCategory> findByidCategory(Long id);
	public List<ProductsCategory> findByIdProAndCate(Long idProd, Long idCat);
}
