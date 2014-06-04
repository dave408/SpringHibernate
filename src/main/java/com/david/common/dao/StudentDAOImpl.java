package com.david.common.dao;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.common.model.Student;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class StudentDAOImpl implements StudentDAO{

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Student> listStudent() {
        System.out.println("inside listStudent()");    //"Student" is class name
		return sessionFactory.getCurrentSession().createQuery("from Student").list();
		
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
	}

    @Override
    @Transactional
    public void insertStudent(Student student){
    	sessionFactory.getCurrentSession().save(student);
    }
    
    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student student = (Student) sessionFactory.getCurrentSession().load(Student.class, id);
        if (null != student) {
            sessionFactory.getCurrentSession().delete(student);
        }
 
    }

}
