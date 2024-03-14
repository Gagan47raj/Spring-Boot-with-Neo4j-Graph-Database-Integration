package com.automated.entities;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import lombok.Data;

@Data
@Node
public class Subject {

	@Id
	@GeneratedValue
	private Long id;
	
	@Property(name = "sub_name")
	private String subName;
}
