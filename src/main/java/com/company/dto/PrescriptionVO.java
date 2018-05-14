package com.company.dto;

/**
 * 
 * �� ó�決�� ���ϰ� �ִ� ó����� Ŭ������ ����, ø�೻�� ó������ ���� <-> MedicineVO �� ����(�ܼ�ó��� �����ϱ� ���� ����)
 *
 */
public class PrescriptionVO implements Cloneable {
	public String prescrGroup; // ø�� �̸�
	public String medicine; // ó���
	public int defaultValue; // �⺻ ��
	public Object clone() {
		try {
			PrescriptionVO obj = (PrescriptionVO)super.clone();
			return obj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}
	public String getPrescrGroup() {
		return prescrGroup;
	}
	public void setPrescrGroup(String prescrGroup) {
		this.prescrGroup = prescrGroup;
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
