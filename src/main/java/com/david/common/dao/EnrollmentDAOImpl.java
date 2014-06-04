package com.david.common.dao;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.common.model.Enrollment;

@Transactional
@Service
public class EnrollmentDAOImpl implements EnrollmentDAO{

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Enrollment> listEnrollment() {
        System.out.println("inside listStudent()");    //"Enrollment" is class name
		return sessionFactory.getCurrentSession().createQuery("from Enrollment").list();
		
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
	}
	
	@Override
	public List<Enrollment> listEnrollmentBySID(int SID) {//"Enrollment" is class name

		return sessionFactory.getCurrentSession().createQuery("from Enrollment where E_SID=" + SID).list();
	}

	@Override
	public List<Enrollment> listEnrollmentByCID(int CID) {//"Enrollment" is class name

		return sessionFactory.getCurrentSession().createQuery("from Enrollment where E_CID=" + CID).list();
	}
	
    @Override
    @Transactional
    public void insertEnrollment(Enrollment enrollment){
    	sessionFactory.getCurrentSession().save(enrollment);
    }
    
    @Override
    @Transactional
    public void deleteEnrollment(Integer id) {
    	Enrollment enrollment = (Enrollment) sessionFactory.getCurrentSession().load(Enrollment.class, id);
        if (null != enrollment) {
            sessionFactory.getCurrentSession().delete(enrollment);
        }
 
    }
}
