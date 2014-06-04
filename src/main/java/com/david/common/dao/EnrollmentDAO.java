package com.david.common.dao;

import java.util.List;

import com.david.common.model.Enrollment;

public interface EnrollmentDAO {
	
	public List<Enrollment> listEnrollment();
	public List<Enrollment> listEnrollmentBySID(int SID);
	public List<Enrollment> listEnrollmentByCID(int CID);
	public void insertEnrollment(Enrollment enrollment);
	public void deleteEnrollment(Integer id);
}
