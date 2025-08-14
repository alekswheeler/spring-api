package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents(){
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student){
		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()){
			throw new IllegalStateException("email taken");
		}
		//aditinal checks (valid email)
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		if(!studentRepository.existsById(studentId)){
			throw new IllegalStateException("student already exists");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email){
		Student s = studentRepository.findById(studentId).orElseThrow(() ->
			new IllegalStateException("student with id " + studentId + " doesn't exists")
		);

		// some checks to validate the new name
		// - name is valid
		// - name is not the same
		if(name != null && name.length() > 0 
				&& !name.equals(s.getName())){
			s.setName(name);
		}

		//some checks to validate the new email
		// - ensures that the new email is not used for another student
		if(studentRepository.findStudentByEmail(email).isPresent()){
			throw new IllegalStateException("email: " + email + "already taken");
		}
		
		if(email != null && email.length() > 0 
				&& !email.equals(s.getEmail())){
			s.setEmail(email);
		}
	}
}
