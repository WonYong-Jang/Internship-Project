package com.company.dto;


/**
 * �� ���̺��� �����ϱ� ���� DTO
 * 
 *
 */
public class MemberVO {

	private String patientNum; // ȯ�� ��ȣ
	private String patientName; // ȯ�� �̸�
	private String comment;
	private String date;
	private int score;
	public String getPatientNum() {
		return patientNum;
	}
	public void setPatientNum(String patientNum) {
		this.patientNum = patientNum;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
