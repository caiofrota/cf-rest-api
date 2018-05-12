package com.cftechsol.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cftechsol.data.services.GenericService;

/**
 * Generic Controller with common methods to accelerate the creation of
 * controller.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <S>
 *            Service
 * @param <E>
 *            Entity
 * @param <PK>
 *            Primary key
 */
public class GenericController<S extends GenericService<? extends JpaRepository<E, PK>, E, PK>, E, PK> {

	@Autowired
	protected S service;
	protected boolean audit = true;

	@GetMapping
	public List<E> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping(path = "/id/{id}")
	public E findById(@PathVariable PK id) throws Exception {
		return service.findById(id);
	}

	/**
	 * Call the save object. If the audit is true, timestamps will be saved and
	 * persistence user will be zero, if you want to control the persistence user,
	 * use GenericSecurityController from cf-security-api.
	 * 
	 * @param object
	 *            Object.
	 * @return Object saved.
	 * @throws Exception
	 */
	@PostMapping
	public E save(@RequestBody E object) throws Exception {
		if (audit) {
			return this.doSave(object, 0l);
		} else {
			return this.doSave(object);
		}
	}

	@DeleteMapping
	public void delete(@RequestParam PK id) throws Exception {
		this.doDelete(id);
	}

	/**
	 * Save audit object.
	 * 
	 * @param object
	 *            Object.
	 * @param id
	 *            Persistence user.
	 * @return Object saved.
	 * @throws Exception
	 */
	protected E doSave(E object, long id) throws Exception {
		return service.save(object, id);
	}

	/**
	 * Save object.
	 * 
	 * @param object
	 *            Object.
	 * @return Object saved.
	 * @throws Exception
	 */
	protected E doSave(E object) throws Exception {
		return service.save(object);
	}

	/**
	 * Delete object by Primary Key.
	 * 
	 * @param id
	 *            Primary Key.
	 * @throws Exception
	 */
	protected void doDelete(PK id) throws Exception {
		this.service.delete(id);
	}

}
