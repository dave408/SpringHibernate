package com.david.common.dao;

import java.util.List;

import com.david.common.model.Course;

public interface CourseDAO {
	
	public List<Course> listCourse();
	public void insertCourse(Course course);
	public void deleteCourse(Integer id);
}
