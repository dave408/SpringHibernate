package com.david.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
    @Id
    @Column(name="C_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
    
    @Column(name="C_NAME", nullable = false)
	private String courseName;
    
    @Column(name="C_CREDIT", nullable = false)
	private int credit;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
}
