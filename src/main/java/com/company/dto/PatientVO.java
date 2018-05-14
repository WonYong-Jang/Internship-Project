package com.company.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class PatientVO {
	private String pNumber; // ȯ�� ��ȣ
	private String pName; // ȯ�� �̸�
	private int age; // ���λ��� �� �߰� ����
	private String visitDate; // �湮��¥
	
	public ArrayList<PatientSymptomVO> symptomArr; // ������� drools �� �����ϱ� ���� arraylist �� ����
	public PatientDiagnosisVO diagnosis;
	public PatientVO()
	{
		Calendar cal= Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //"yyyy:MM:dd-HH:mm:ss"
		visitDate = dateFormat.format(cal.getTime()); // ����� ���⼭ ���� ��¥�� ��������� ���� ��� ��� ȯ�ڸ� �����Ҷ� ��¥�� ����ϰ� �ҷ��;���
		
		symptomArr = new ArrayList<PatientSymptomVO>();
		diagnosis = new PatientDiagnosisVO(visitDate);
	}
	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<PatientSymptomVO> getSymptomArr() {
		return symptomArr;
	}

	public void setSymptomArr(ArrayList<PatientSymptomVO> symptomArr) {
		this.symptomArr = symptomArr;
	}
	public PatientDiagnosisVO getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(PatientDiagnosisVO diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
}
