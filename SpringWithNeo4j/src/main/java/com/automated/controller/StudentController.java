package com.automated.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automated.entities.Student;
import com.automated.request.CreateStudentRequest;
import com.automated.request.GetStudentByCountryRequest;
import com.automated.request.UpdateStudentRequest;
import com.automated.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/create")
	public Student create(@RequestBody CreateStudentRequest request) {
		return studentService.createStudent(request);
	}
	
	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/getStudentByName/{name}")
	public List<Student> getStudentByName(@PathVariable String name) {
		return studentService.getStudentByName(name);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody UpdateStudentRequest request) {
		return studentService.updateStudent(request);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/getStudentByNameAndAge/{name}/{age}")
	public List<Student> getStudentByNameAndAge(@PathVariable String name, @PathVariable int age) {
		return studentService.getStudentByNameAndAge(name, age);
	}
	
	@GetMapping("/getStudentByNameOrAge/{name}/{age}")
	public List<Student> getStudentByNameOrAge(@PathVariable String name, @PathVariable int age) {
		return studentService.getStudentByNameOrAge(name, age);
	}
	
	@GetMapping("/getStudentByCountry")
	public List<Student> getStudentByCountry(@RequestBody GetStudentByCountryRequest request) {
		return studentService.getStudentByCountry(request);
	}
	
	@GetMapping("/getStudentWithSorting")
	public List<Student> getStudentWithSorting() {
		return studentService.getStudentWithSorting();
	}
	
	
}
