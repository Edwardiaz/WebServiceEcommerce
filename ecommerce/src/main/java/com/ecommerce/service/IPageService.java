package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Page;

public interface IPageService {
	public List<Page> listPage();  //Retrieve the complete list
	
	public Page pagebyId(Long id);   //One Element by id
	
	public void deletePageById(Long idPage); //Delete by id

	public void savePage(Page p);  //Save a new Element
	
	public Page updatePage(Page p);  //update an Element

	//public Object deleteObject(Object obj);
	
}
