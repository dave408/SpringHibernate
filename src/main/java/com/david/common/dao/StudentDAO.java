package com.david.common.dao;

import java.util.List;

import com.david.common.model.Student;

public interface StudentDAO {

	public List<Student> listStudent();
	public void insertStudent(Student student);
	public void deleteStudent(Integer id);
}

