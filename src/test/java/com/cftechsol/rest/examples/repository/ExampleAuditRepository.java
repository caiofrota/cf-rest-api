package com.cftechsol.rest.examples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cftechsol.rest.examples.entities.ExampleAuditEntity;

/**
 * Example audit repository to run the tests.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ExampleAuditRepository extends JpaRepository<ExampleAuditEntity, Long> {

}
