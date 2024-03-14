package com.automated.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Data;

@Data
@Node(labels = {"Department"})
public class Department {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Property(name = "department_name")
	private String departmentName;
}
