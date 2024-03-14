package com.automated.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.automated.entities.Department;
import com.automated.entities.IsLearningRelation;
import com.automated.entities.Student;
import com.automated.entities.Subject;
import com.automated.repository.DepartmentRepository;
import com.automated.repository.StudentRepository;
import com.automated.repository.SubjectRepository;
import com.automated.request.CreateStudentRequest;
import com.automated.request.CreateSubjectRequest;
import com.automated.request.GetStudentByCountryRequest;
import com.automated.request.UpdateStudentRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public Student createStudent(CreateStudentRequest request) {
        Department department = new Department();
        department.setDepartmentName(request.getDepartment().getDepName());
        departmentRepository.save(department);
        
        List<IsLearningRelation> isLearningRelationList = 
        		new ArrayList<IsLearningRelation>();
        
		if (request.getSubjectList() != null) {
			for (CreateSubjectRequest createSubject : request.getSubjectList()) {
				Subject subject = new Subject();
				subject.setSubName(createSubject.getSubjectName());
				subjectRepository.save(subject);	
				
				IsLearningRelation isLearningRelation = new IsLearningRelation();
				isLearningRelation.setMarks(createSubject.getMarks()); 
				isLearningRelation.setSubject(subject);
				isLearningRelationList.add(isLearningRelation);
			}
		}
		
		Student student = new Student();
		student.setName(request.getName());
		student.setCountry(request.getCountry());
		student.setAge(request.getAge());	
		
		student.setDepartment(department);
		student.setIsLearningRelation(isLearningRelationList);
		studentRepository.save(student);
		
		return student;
		
}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	public List<Student> getStudentByName(String name) {
		return studentRepository.findByName(name);
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student updateStudent(UpdateStudentRequest updateStudentRequest)
	{
		Student student = studentRepository.findById(updateStudentRequest.getId()).get();
		
		student.setName(updateStudentRequest.getName());
		student.setCountry(updateStudentRequest.getCountry());
		student.setAge(updateStudentRequest.getAge());
		studentRepository.save(student);
		
		return student;
	}
	
	public String deleteStudent(Long id) {
		studentRepository.deleteNodeWithRelatedNodes(id);
		return "Student deleted successfully";
	}
	
	public List<Student> getStudentByNameAndAge(String name, int age) {
		return studentRepository.findByNameAndAge(name, age);
	}
	
	public List<Student> getStudentByNameOrAge(String name, int age) {
		return studentRepository.findByNameOrAge(name, age);
	}
	
	public List<Student> getStudentByCountry(GetStudentByCountryRequest request) {
		return studentRepository.findByCountryIn(request.getCountries());
	}
	
	public List<Student> getStudentWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return studentRepository.findAll(sort);
	}
}
