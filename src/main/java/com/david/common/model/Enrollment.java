package com.david.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enrollment")
public class Enrollment {
	
    @Id
    @Column(name="E_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentId;
    
    @Column(name="E_SID", nullable = false)
	private int enrollmentSID;
    
    @Column(name="E_SNAME", nullable = false)
	private String enrollmentSNAME;

    @Column(name="E_CID", nullable = false)
	private int enrollmentCID;

    @Column(name="E_CNAME", nullable = false)
	private String enrollmentCNAME;

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public int getEnrollmentSID() {
		return enrollmentSID;
	}

	public void setEnrollmentSID(int enrollmentSID) {
		this.enrollmentSID = enrollmentSID;
	}

	public String getEnrollmentSNAME() {
		return enrollmentSNAME;
	}

	public void setEnrollmentSNAME(String enrollmentSNAME) {
		this.enrollmentSNAME = enrollmentSNAME;
	}

	public int getEnrollmentCID() {
		return enrollmentCID;
	}

	public void setEnrollmentCID(int enrollmentCID) {
		this.enrollmentCID = enrollmentCID;
	}

	public String getEnrollmentCNAME() {
		return enrollmentCNAME;
	}

	public void setEnrollmentCNAME(String enrollmentCNAME) {
		this.enrollmentCNAME = enrollmentCNAME;
	}
}
