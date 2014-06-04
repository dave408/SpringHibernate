package com.david.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
    @Id
    @Column(name="STU_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
    
    @Column(name="NAME", nullable = false)
	private String name;
    
    @Column(name="AGE", nullable = false)
	private int age;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
