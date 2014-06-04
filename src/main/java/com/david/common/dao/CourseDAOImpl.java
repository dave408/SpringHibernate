package com.david.common.dao;

import java.util.List;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.common.model.Course;

@Transactional
@Service
public class CourseDAOImpl implements CourseDAO{

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Course> listCourse() {
        System.out.println("inside listStudent()");    //"Course" is class name
		return sessionFactory.getCurrentSession().createQuery("from Course").list();
		
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
	}

    @Override
    @Transactional
    public void insertCourse(Course course){
    	sessionFactory.getCurrentSession().save(course);
    }
    
    @Override
    @Transactional
    public void deleteCourse(Integer id) {
    	Course course = (Course) sessionFactory.getCurrentSession().load(Course.class, id);
        if (null != course) {
            sessionFactory.getCurrentSession().delete(course);
        }
 
    }
}
