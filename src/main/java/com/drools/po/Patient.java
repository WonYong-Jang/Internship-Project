package com.drools.po;

import java.util.ArrayList;

public class Patient {
	
	public ArrayList<String> symptomArr; // 증상들을 drools 로 진단하기 위해 arraylist 로 관리
	public PatientDiagnosis diagnosis;
	public Patient()
	{
		symptomArr = new ArrayList<String>();
		diagnosis = new PatientDiagnosis();
		setTest();
	}
	public void setTest() // 더미 데이터 ( 병원 디비에 따라서 달라짐 ), 증상이 4 이상이면 의사가 선택할수 있게, 5이상은 
	{
		symptomArr.add("명치부위압통");
		symptomArr.add("명치답답");
		symptomArr.add("공복에 답답함");
		symptomArr.add("명치부위통증");
		symptomArr.add("뻐근");
		symptomArr.add("명치아래무력");
		symptomArr.add("진액부족");
		symptomArr.add("소화불량");
		symptomArr.add("양협하답답통증");
		symptomArr.add("배변장애 가스상충");
		symptomArr.add("상복부 담적");
		symptomArr.add("하복부 담적");
		symptomArr.add("본문식적");
		symptomArr.add("중완식적");
		
		
	}
	public ArrayList<String> getSymptomArr() {
    	return symptomArr;
    }
    public void setSymptomArr(String symptomArr) {
    	this.symptomArr.add(symptomArr);
    }
}
