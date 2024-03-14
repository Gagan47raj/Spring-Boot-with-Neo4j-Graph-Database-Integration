package com.automated.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.automated.entities.Student;
import java.util.List;


@Repository
public interface StudentRepository extends Neo4jRepository<Student, Long>{
	
	List<Student> findByName(String name);
	
	@Query("MATCH (student:Student)-[:Belongs_To]->(department) WHERE ID(student) = $id OPTIONAL MATCH (student)-[:Is_Learning]->(subject) DETACH DELETE student, department, subject")
	void deleteNodeWithRelatedNodes(Long id);
	
	
	List<Student> findByNameAndAge(String name, int age);
	
	List<Student> findByNameOrAge(String name, int age);
	
	@Query("MATCH (s:Student) WHERE s.country IN $countries RETURN s")
	List<Student> findByCountryIn(List<String> countries);
	
}
