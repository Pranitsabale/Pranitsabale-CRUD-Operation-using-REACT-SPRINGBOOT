package com.crud.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.model.Crud;
import com.crud.repository.CrudRepo;
import com.crud.service.CrudService;

@Service
public class CrudServiceImpl implements CrudService {

	private CrudRepo crudRepo;

	CrudServiceImpl(CrudRepo crudRepo) {
		this.crudRepo = crudRepo;
	}

	@Override
	public List<Crud> getAll() {
		List<Crud> findAll = crudRepo.findAll();
		return findAll;
	}

	@Override
	public Crud add(Crud crud) {
		Crud save = crudRepo.save(crud);
		return save;
	}

	@Override
	public Crud update(Crud crud) {
		if (crud.getId() != null) {
			Integer id = crud.getId();
			Optional<Crud> optionalUser = crudRepo.findById(id);

			if (optionalUser.isPresent()) {
				Crud existUser = optionalUser.get();
				existUser.setFirstName(crud.getFirstName());
				existUser.setLastName(crud.getLastName());
				existUser.setEmailId(crud.getEmailId());
				existUser.setContact(crud.getContact());
				existUser.setCity(crud.getCity());

				crudRepo.save(existUser);
			}
		}
		return crud;
	}

	@Override
	public void delete(Integer id) {
		crudRepo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		crudRepo.deleteAll();
	}

}
