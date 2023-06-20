package com.student.controller;

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

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@GetMapping("/get/{studentId}")
	public Student getByStudentId(@PathVariable int studentId) {
		return studentService.getByStudentId(studentId);

	}

	@PutMapping("update/{studentId}")
	public Student updateStudent(@PathVariable int studentId,@RequestBody Student student) {
		return studentService.updateStudent(studentId, student);
	}

	@GetMapping("/get/all")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@DeleteMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		studentService.deleteStudent(studentId);

		return "Student deleted succesfully";
	}
}
