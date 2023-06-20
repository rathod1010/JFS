package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student getByStudentId(int studentId) {
		return studentRepository.findById(studentId)
				.orElseThrow(() -> new EntityNotFoundException("Student not found with id :" + studentId));
	}

	public Student updateStudent(int studentId, Student student) {
		Student updatedStudent = getByStudentId(studentId);
		updatedStudent.setStudentName(student.getStudentName());
		updatedStudent.setEmail(student.getEmail());
		updatedStudent.setMobile(student.getMobile());

		return studentRepository.save(updatedStudent);

	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void deleteStudent(int studentId) {

		studentRepository.deleteById(studentId);
	}
}
