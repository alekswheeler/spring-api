package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Student {

	@Id
	@SequenceGenerator(
		name = "student_sequence",
		sequenceName = "student_sequence",
		allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "student_sequence"
	)
	private Long id;
	private String email;
	private String name;

	@Transient
	public Integer age;
	private LocalDate dateOfBirthday;

	//Constructors
	public Student(String email, 
					String name, 
					LocalDate dateOfBirthday) {
		this.email = email;
		this.name = name;
		this.dateOfBirthday = dateOfBirthday;
	}

	public Student(Long id, 
				 	String email, 
					String name, 
					LocalDate dateOfBirthday) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.dateOfBirthday = dateOfBirthday;
	}
	

	public Student() {
	}
	
	// Getters
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return Period.between(dateOfBirthday, LocalDate.now()).getYears();
	}
	public LocalDate getDateOfBirthday() {
		return dateOfBirthday;
	}

	// Setters
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setDateOfBirthday(LocalDate dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}

	@Override
	public String toString() {
		return "Student [Id=" + 
				id + ", Email=" + 
				email + ", Name=" + 
				name + ", Age=" + 
				age + ", DateOfBirthday="+
				dateOfBirthday + "]";
	}
}
