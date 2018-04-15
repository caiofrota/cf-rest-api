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
 * services.
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

	@GetMapping
	public List<E> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping(path = "/id/{id}")
	public E findById(@PathVariable PK id) throws Exception {
		return service.findById(id);
	}

	@PostMapping
	public E save(@RequestBody E object) throws Exception {
		return service.save(object);
	}

	@DeleteMapping
	public void delete(@RequestParam PK id) throws Exception {
		service.delete(id);
	}

}
