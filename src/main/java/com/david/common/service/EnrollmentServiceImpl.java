package com.david.common.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.common.dao.CourseDAO;
import com.david.common.dao.EnrollmentDAO;
import com.david.common.dao.StudentDAO;
import com.david.common.model.Course;
import com.david.common.model.Enrollment;
import com.david.common.model.Student;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

	@Autowired
	private EnrollmentDAO enrollmentDAO;

	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private CourseDAO courseDAO;
	
	Session session = null;
	Transaction tx = null;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void registerClass(int studentID, int courseID){

		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Student student = getStudentById(studentID);
			Course course = getCourseById(courseID);
			if (getStudentById(studentID) != null && getCourseById(courseID) != null)
			{
				Enrollment enrollment = new Enrollment();
				enrollment.setEnrollmentSID(student.getStudentId());
				enrollment.setEnrollmentSNAME(student.getName());
				enrollment.setEnrollmentCID(course.getCourseId());
				enrollment.setEnrollmentCNAME(course.getCourseName());
				enrollmentDAO.insertEnrollment(enrollment);
			}			
			
			tx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
	}
	
	@Override
	@Transactional
	public void removeStudent(int studentID){
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			List<Enrollment> enrollmentList = enrollmentDAO.listEnrollmentBySID(studentID);
			for(Enrollment e : enrollmentList){
				enrollmentDAO.deleteEnrollment(e.getEnrollmentId());
			}				
			studentDAO.deleteStudent(studentID);
			
			tx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
	}

	@Override
	@Transactional
	public void removeCourse(int courseID){
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			List<Enrollment> enrollmentList = enrollmentDAO.listEnrollmentByCID(courseID);
			for(Enrollment e : enrollmentList){
				enrollmentDAO.deleteEnrollment(e.getEnrollmentId());
			}				
			courseDAO.deleteCourse(courseID);
			
			tx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
	}
	
	@Override
	public Student getStudentById(int studentID){
		
		return (Student) sessionFactory.getCurrentSession().get(Student.class, studentID);
	}
	
	@Override
	public Course getCourseById(int courseID){
		
		return (Course) sessionFactory.getCurrentSession().get(Course.class, courseID);
	}
}