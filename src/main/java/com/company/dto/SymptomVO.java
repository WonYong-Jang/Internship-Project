package com.company.dto;
/**
 * 
 * ���� �꿡 �ش��ϴ� ������� �����ϴ� Ŭ���� (�꿡 �ش��ϴ� ����) => PatientSymptomVO �� ��
 *
 */
public class SymptomVO {
	private String ruleID;
	private String symptom;
	private int flag; // flag == 1 (�ݵ�� ���� �ؾ��ϴ� ����)   flag == 0 (or ���� Ȯ���ϱ� ���� flag)
	private String sRegion; // ���� ���� ��ü����
	private int min;
	private int max;
	public SymptomVO() 
	{	
	}
	public String getRuleID() {
		return ruleID;
	}
	public void setRuleID(String ruleID) {
		this.ruleID = ruleID;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getsRegion() {
		return sRegion;
	}
	public void setsRegion(String sRegion) {
		this.sRegion = sRegion;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
}
