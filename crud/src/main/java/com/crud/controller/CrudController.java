package com.crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Crud;
import com.crud.service.CrudService;

@RestController
@RequestMapping("/api")
public class CrudController {

	private CrudService crudService;

	CrudController(CrudService crudService) {
		this.crudService = crudService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Crud>> getAllDetails() {

		List<Crud> all = crudService.getAll();

		return new ResponseEntity<>(all, HttpStatus.ACCEPTED);
	}

	@PostMapping("/add")
	public ResponseEntity<Crud> add(@RequestBody Crud crud) {

		Crud add = crudService.add(crud);

		return new ResponseEntity<>(add, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<Crud> update(@RequestBody Crud crud) {

		Crud update = crudService.update(crud);

		return new ResponseEntity<>(update, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		crudService.delete(id);
	}

	@DeleteMapping("/delete/all")
	public void deleteAll() {
		crudService.deleteAll();
	}

}
