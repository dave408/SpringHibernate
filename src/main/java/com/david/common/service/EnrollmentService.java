package com.david.common.service;

import com.david.common.model.Course;
import com.david.common.model.Student;

public interface EnrollmentService {

	public void registerClass(int studentID, int courseID);
	public void removeStudent(int studentID);
	public void removeCourse(int courseID);
	public Student getStudentById(int studentID);
	public Course getCourseById(int courseID);
}
