package com.drools.po;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * 전체 Rules을 관리하기 위한 클래스, 각 증상들마다 flag 를 두어서 or 연산자와 and 연산자를 구분
 *
 */
public class DomainRules {
	public ArrayList<ArrayList<ObjSymptom>> domainRules; // 전체 병원 rules 들을 2차원 배열로 관리
	public ArrayList<ObjSymptom> childDomain;
	public ArrayList<Integer> andSymptom; // 반드시 조건에 만족해야하는 증상들의 갯수를 배열로 저장
	
	public DomainRules() {
		setDomainRules();
		numOfAndSymptom(); // and Symptom 갯수 count
	}
	
	public class ObjSymptom implements java.lang.Comparable<ObjSymptom>{ // 증상마다 객체로 관리 함으로써 or, and 연산을 효율적으로 관리
		private String symptom;
		private int flag; // flag == 1 (반드시 존재 해야하는 증상)   flag == 0 (or 연산 확인하기 위한 flag)
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
			return this.getSymptom().compareTo(obj.getSymptom()); // 오름 차순 정렬
		}
	}
			
	public void setDomainRules() {
		domainRules = new ArrayList<ArrayList<ObjSymptom>>();
		
		childDomain = new ArrayList<ObjSymptom>(); // 0 번 룰 체기
		childDomain.add(new ObjSymptom("소화불량",1));
		childDomain.add(new ObjSymptom("명치답답",1));
		childDomain.add(new ObjSymptom("명치부위 압통",1));
		domainRules.add(childDomain);
		
		childDomain = new ArrayList<ObjSymptom>(); // 1 번 룰 허한
		childDomain.add(new ObjSymptom("담적 상복부",1));
		domainRules.add(childDomain);
		
		childDomain = new ArrayList<ObjSymptom>(); // 2 번 룰 실열
		childDomain.add(new ObjSymptom("담적 하복부",1));
		domainRules.add(childDomain);
		
		childDomain = new ArrayList<ObjSymptom>(); // 3번 룰 협십증
		childDomain.add(new ObjSymptom("혀 자색",1));
		childDomain.add(new ObjSymptom("가슴답답",0));
		childDomain.add(new ObjSymptom("목이물감",0));
		childDomain.add(new ObjSymptom("등 결림",0));
		childDomain.add(new ObjSymptom("숨참",0));
		domainRules.add(childDomain);
		
		for(int i =0; i< domainRules.size(); i++) // 각 rule 마다 오름 차순 정렬
		{
			Collections.sort(domainRules.get(i));
		}
	}
	public void numOfAndSymptom()
	{
		andSymptom = new ArrayList<Integer>();
		
		for(int i=0 ; i< domainRules.size(); i++) // rule 번호마다 and Symptom 의 갯수를 세틑 과정
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
