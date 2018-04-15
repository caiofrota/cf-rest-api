package com.cftechsol.rest.examples.services;

import org.springframework.stereotype.Service;

import com.cftechsol.data.services.GenericService;
import com.cftechsol.rest.examples.entities.ExampleAuditEntity;
import com.cftechsol.rest.examples.repository.ExampleAuditRepository;

/**
 * Example service to run the tests.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ExampleService extends GenericService<ExampleAuditRepository, ExampleAuditEntity, Long> {

}
