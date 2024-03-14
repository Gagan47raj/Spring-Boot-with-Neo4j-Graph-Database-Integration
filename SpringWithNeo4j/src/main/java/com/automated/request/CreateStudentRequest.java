package com.automated.request;

import java.util.List;

public class CreateStudentRequest {
	private String name;

	private Integer age;

	private String country;

	private List<CreateSubjectRequest> subjectList;
	
	private CreateDepartmentRequest department;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setBirthYear(Integer age) {
		this.age = age;
	}

	public List<CreateSubjectRequest> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<CreateSubjectRequest> subjectList) {
		this.subjectList = subjectList;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public CreateDepartmentRequest getDepartment() {
		return department;
	}

	public void setDepartment(CreateDepartmentRequest department) {
		this.department = department;
	}

}
