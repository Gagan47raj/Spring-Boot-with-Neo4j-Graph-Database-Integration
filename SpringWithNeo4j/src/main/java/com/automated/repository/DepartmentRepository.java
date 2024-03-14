package com.automated.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.automated.entities.Department;

@Repository
public interface DepartmentRepository extends Neo4jRepository<Department, Long> {

}
