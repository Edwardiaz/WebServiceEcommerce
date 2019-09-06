package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.entity.Page;

public interface IPageDao {

	public List<Page> findAll(); // RETRIEVE ALL ELEMENTS in A LIST

	public Page getOne(Long id); // RETRIEVE SINGLE ELEMENT IN AN OBJECT

	public void deletePageById(Long idPage); // DELETE SINGLE ELEMENT BY ID

	public Page saver(Page p); // SAVE SINGLE ELEMENTIN AN OBJECT

	public Page update(Page p); // SAVE OR UPDATE SINGLE ELEMENT

	//public String deleteObject(Object obj);
}
