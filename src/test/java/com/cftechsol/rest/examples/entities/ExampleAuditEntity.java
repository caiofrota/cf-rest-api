package com.cftechsol.rest.examples.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cftechsol.data.entities.GenericAuditEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Example entity to run the tests.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "example")
public class ExampleAuditEntity extends GenericAuditEntity<Long> {

	private static final long serialVersionUID = 6086753602151244943L;

	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private String test;

	public ExampleAuditEntity(String name, String test) {
		this.name = name;
	}

}
