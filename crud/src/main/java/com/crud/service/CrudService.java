package com.crud.service;

import java.util.List;

import com.crud.model.Crud;

public interface CrudService {
	
	public List<Crud> getAll();
	
	public Crud add(Crud crud);
	
	public Crud update(Crud crud);
	
	public void delete(Integer id);
	
	public void deleteAll();

}
