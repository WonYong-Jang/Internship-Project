package com.company.dto;

public class MedicineVO {
	public String ruleID; // ruleID �� ���ܸ�
	public String medicine; // ó���
	public int defaultValue; // �⺻ ��
	public String getRuleID() {
		return ruleID;
	}
	public void setRuleID(String ruleID) {
		this.ruleID = ruleID;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public int getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(int defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}
