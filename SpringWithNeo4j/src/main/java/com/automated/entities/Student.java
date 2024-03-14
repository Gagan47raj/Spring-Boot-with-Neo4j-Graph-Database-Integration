package com.automated.entities;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;

@Data
@Node(labels = {"Student"})
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String country;
	
	@Relationship(type = "Belongs_To", direction = Relationship.Direction.OUTGOING)
	private Department department;
	
	@Relationship(type = "Is_Learning", direction = Relationship.Direction.OUTGOING)
	private List<IsLearningRelation> IsLearningRelation;
	
	@Property(name = "age")	
	private int age;
}
