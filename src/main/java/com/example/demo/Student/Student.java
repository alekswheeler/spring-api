package com.example.demo.Student;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

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
	private Long Id;
	private String Email;
	private String Name;
	private int Age;
	private LocalDate DateOfBirthday;

	//Constructors
	public Student(String email, 
					String name, 
					int age, 
					LocalDate dateOfBirthday) {
		Email = email;
		Name = name;
		Age = age;
		DateOfBirthday = dateOfBirthday;
	}

	public Student(Long id, 
				 	String email, 
					String name, 
					int age, 
					LocalDate dateOfBirthday) {
		Id = id;
		Email = email;
		Name = name;
		Age = age;
		DateOfBirthday = dateOfBirthday;
	}
	

	public Student() {
	}
	
	// Getters
	public String getEmail() {
		return Email;
	}
	public String getName() {
		return Name;
	}
	public int getAge() {
		return Age;
	}
	public LocalDate getDateOfBirthday() {
		return DateOfBirthday;
	}

	// Setters
	public void setEmail(String email) {
		Email = email;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setAge(int age) {
		Age = age;
	}
	public void setDateOfBirthday(LocalDate dateOfBirthday) {
		DateOfBirthday = dateOfBirthday;
	}

	@Override
	public String toString() {
		return "Student [Id=" + 
				Id + ", Email=" + 
				Email + ", Name=" + 
				Name + ", Age=" + 
				Age + ", DateOfBirthday="+
				DateOfBirthday + "]";
	}
	
}
