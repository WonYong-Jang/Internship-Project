package com.drools.po;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * ��ü Rules�� �����ϱ� ���� Ŭ����, �� ����鸶�� flag �� �ξ or �����ڿ� and �����ڸ� ����
 *
 */
public class DomainRules {
	public ArrayList<ArrayList<ObjSymptom>> domainRules; // ��ü ���� rules ���� 2���� �迭�� ����
	public ArrayList<ObjSymptom> childDomain;
	public ArrayList<Integer> andSymptom; // �ݵ�� ���ǿ� �����ؾ��ϴ� ������� ������ �迭�� ����
	
	public DomainRules() {
		setDomainRules();
		numOfAndSymptom(); // and Symptom ���� count
	}
	
	public class ObjSymptom implements java.lang.Comparable<ObjSymptom>{ // ���󸶴� ��ü�� ���� �����ν� or, and ������ ȿ�������� ����
		private String symptom;
		private int flag; // flag == 1 (�ݵ�� ���� �ؾ��ϴ� ����)   flag == 0 (or ���� Ȯ���ϱ� ���� flag)
		private int minValue;
		private int maxVlaue;
		public ObjSymptom(String symptom, int flag)
		{
			this.setSymptom(symptom);
			this.setFlag(flag);
		}
		
		public int getMinValue() {
			return minValue;
		}

		public void setMinValue(int minValue) {
			this.minValue = minValue;
		}

		public int getMaxVlaue() {
			return maxVlaue;
		}

		public void setMaxVlaue(int maxVlaue) {
			this.maxVlaue = maxVlaue;
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
		@Override
		public int compareTo(ObjSymptom obj) {
			// TODO Auto-generated method stub
			return this.getSymptom().compareTo(obj.getSymptom()); // ���� ���� ����
		}
	}
			
	public void setDomainRules() {
		domainRules = new ArrayList<ArrayList<ObjSymptom>>();
		
		childDomain = new ArrayList<ObjSymptom>(); // 0 �� �� ü��
		childDomain.add(new ObjSymptom("��ȭ�ҷ�",1));
		childDomain.add(new ObjSymptom("��ġ���",1));
		childDomain.add(new ObjSymptom("��ġ���� ����",1));
		domainRules.add(childDomain);
		
		childDomain = new ArrayList<ObjSymptom>(); // 1 �� �� ����
		childDomain.add(new ObjSymptom("���� �󺹺�",1));
		domainRules.add(childDomain);
		
		childDomain = new ArrayList<ObjSymptom>(); // 2 �� �� �ǿ�
		childDomain.add(new ObjSymptom("���� �Ϻ���",1));
		domainRules.add(childDomain);
		
		childDomain = new ArrayList<ObjSymptom>(); // 3�� �� ������
		childDomain.add(new ObjSymptom("�� �ڻ�",1));
		childDomain.add(new ObjSymptom("�������",0));
		childDomain.add(new ObjSymptom("���̹���",0));
		childDomain.add(new ObjSymptom("�� �Ḳ",0));
		childDomain.add(new ObjSymptom("����",0));
		domainRules.add(childDomain);
		
		for(int i =0; i< domainRules.size(); i++) // �� rule ���� ���� ���� ����
		{
			Collections.sort(domainRules.get(i));
		}
	}
	public void numOfAndSymptom()
	{
		andSymptom = new ArrayList<Integer>();
		
		for(int i=0 ; i< domainRules.size(); i++) // rule ��ȣ���� and Symptom �� ������ ���z ����
		{
			int count=0;
			for(int j=0; j<domainRules.get(i).size(); j++)
			{
				if(domainRules.get(i).get(j).getFlag()==1) count++;
			}
			andSymptom.add(count);
		}
	}
	public ArrayList<ArrayList<ObjSymptom>> getDomainRules() {
		return domainRules;
	}
	public ArrayList<ObjSymptom> getChildDomain() {
		return childDomain;
	}
}
