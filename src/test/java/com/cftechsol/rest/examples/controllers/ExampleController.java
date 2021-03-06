package com.cftechsol.rest.examples.controllers;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cftechsol.rest.controllers.GenericController;
import com.cftechsol.rest.examples.entities.ExampleAuditEntity;
import com.cftechsol.rest.examples.services.ExampleService;
import com.cftechsol.rest.exceptions.BadRequestException;
import com.cftechsol.rest.exceptions.CFMessages;
import com.cftechsol.rest.exceptions.NonUniqueException;

/**
 * Example controller to execute test.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping(path = "/example", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExampleController extends GenericController<ExampleService, ExampleAuditEntity, Long> {
	
	public ExampleController() {
		super.audit = false;
	}
	
	@PostMapping(path = "/untrackedSave")
	public ExampleAuditEntity untrackedSave(@RequestBody ExampleAuditEntity object) throws Exception {
		super.audit = true;
		object = super.save(object);
		super.audit = false;
		return object;
	}

	@GetMapping(path = "/exception")
	public void exeption() throws Exception {
		throw new Exception("Example Message");
	}

	@GetMapping(path = "/nonUniqueException")
	public void nonUniqueException() throws Exception {
		throw new NonUniqueException("Object", new String[] { "keys" }, new String[] { "values" });
	}

	@PostMapping(path = "/validationException")
	public void validationException(@RequestBody ExampleAuditEntity object) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		throw new ConstraintViolationException(validator.validate(object));
	}

	@PostMapping(path = "/badRequestException")
	public void badRequestException(@RequestBody ExampleAuditEntity object) throws Exception {
		throw new BadRequestException(CFMessages.ERROR.getMessage());
	}

	@PostMapping(path = "/badRequestMessageRefException")
	public void badRequestMessageRefException(@RequestBody ExampleAuditEntity object) throws Exception {
		throw new BadRequestException(CFMessages.ERROR.getMessage(), CFMessages.ERROR.getMessageRef());
	}

}
