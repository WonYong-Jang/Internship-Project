package com.company.dto;
/**
 * 
 * ȯ�ڰ� ���� ������ �����ϴ� Ŭ����
 *
 */
public class PatientSymptomVO {
	private String pNum;
	private String symptom;
	private int degree;
	private String visitDate;
	public String getpNum() {
		return pNum;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	
}
