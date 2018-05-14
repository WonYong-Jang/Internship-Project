package com.drools.po;

import java.util.ArrayList;

public class Patient {
	
	public ArrayList<String> symptomArr; // ������� drools �� �����ϱ� ���� arraylist �� ����
	public PatientDiagnosis diagnosis;
	public Patient()
	{
		symptomArr = new ArrayList<String>();
		diagnosis = new PatientDiagnosis();
		setTest();
	}
	public void setTest() // ���� ������ ( ���� ��� ���� �޶��� ), ������ 4 �̻��̸� �ǻ簡 �����Ҽ� �ְ�, 5�̻��� 
	{
		symptomArr.add("��ġ��������");
		symptomArr.add("��ġ���");
		symptomArr.add("������ �����");
		symptomArr.add("��ġ��������");
		symptomArr.add("����");
		symptomArr.add("��ġ�Ʒ�����");
		symptomArr.add("���׺���");
		symptomArr.add("��ȭ�ҷ�");
		symptomArr.add("�����ϴ������");
		symptomArr.add("�躯��� ��������");
		symptomArr.add("�󺹺� ����");
		symptomArr.add("�Ϻ��� ����");
		symptomArr.add("��������");
		symptomArr.add("�߿Ͻ���");
		
		
	}
	public ArrayList<String> getSymptomArr() {
    	return symptomArr;
    }
    public void setSymptomArr(String symptomArr) {
    	this.symptomArr.add(symptomArr);
    }
}
