package com.company.dto;

import java.util.ArrayList;
import java.util.List;

public class PatientDiagnosisVO  implements Cloneable{
	private String pNumber; // ȯ�� ��ȣ�� �̸���  ���� ���̺� �Ѱ��ֱ� ���� Ŭ������ ����� ���� �ѹ� �� ���
	private String pName; 
	private String comment; // �ش� ȯ�ڰ� ���� ���ܿ� ���� �� ��
	private int score;
	private String visitDate;
	
	public ArrayList<String> selectedGroup; // �ǻ簡 ������ ó�決 ��Ʈ��
	public List<PrescriptionGroupVO> selectedGroupList; // ȯ���� ����� ó�決�� ���ؼ� ��ġ�ϴ� ó�決 ����Ʈ
	public ArrayList<String> simplePrescr; // ȯ�ڿ� ���� ��Ī �Ǵ� �ܼ�ó��
	public ArrayList<String> complexPrescr; // ȯ�ڿ� ���� ��Ī �Ǵ� ����ó��
	public ArrayList<String> diagnosisArr; // ȯ�ڰ� ���� ���ܸ� ����Ʈ
	
	public static final int NODIAGNOSISED   = 0; //���� ������ ����.
    public static final int DIAGNOSISED = 1; //���� ������ �ִ�. 
    
    public int state;
   // public int ruleCheckCnt; // ��� ���� �� üũ�ߴ��� Ȯ���ϱ� ����
  
	public PatientDiagnosisVO(String visitDate) {
		this.state = NODIAGNOSISED;
		simplePrescr = new ArrayList<String>();
		complexPrescr = new ArrayList<String>();
		selectedGroup = new ArrayList<String>();
		diagnosisArr = new ArrayList<String>();
		this.visitDate = visitDate;
		
		selectedGroup.add("�����"); ////////////////// �ǻ簡 üũ������ ������ ó�決 �ӽ÷� ����
		selectedGroup.add("��������");
		
		selectedGroupList = new ArrayList<PrescriptionGroupVO>();
	}
	public Object clone() {
		try {
			PatientDiagnosisVO obj = (PatientDiagnosisVO)super.clone();
			return obj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}
	
	public void setComplexPrescr(ArrayList<MedicineVO> medicines) // ����� ó���� ����
	{
		for(MedicineVO obj : medicines)
		{
			complexPrescr.add(obj.getMedicine()+" "+obj.getDefaultValue());
		}
	}
	public void setSimplePrescr(ArrayList<MedicineVO> medicines) // ����� ó��� ���� ( �ܼ� ó���̴� �迭ũ��� 1)
	{
		for(MedicineVO obj : medicines)
		{
			simplePrescr.add(obj.getMedicine()+" "+obj.getDefaultValue());
		}
	}
	
	public ArrayList<String> getDiagnosisArr() {
		return diagnosisArr;
	}
	public void setDiagnosisArr(ArrayList<String> diagnosisArr) {
		this.diagnosisArr = diagnosisArr;
	}
	public void addDiagnosisArr(String diagnosis) {
		this.diagnosisArr.add(diagnosis);
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
	public void setState(int state) {
		this.state = state; 
	}
	public int getState() {
		return state;
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
	public ArrayList<String> getSelectedGroup() {
		return selectedGroup;
	}
	public void setSelectedGroup(ArrayList<String> selectedGroup) {
		this.selectedGroup = selectedGroup;
	}
	
	public List<PrescriptionGroupVO> getSelectedGroupList() {
		return selectedGroupList;
	}
	public void setSelectedGroupList(List<PrescriptionGroupVO> selectedGroupList) {
		this.selectedGroupList = selectedGroupList;
	}
	public ArrayList<String> getSimplePrescr() {
		return simplePrescr;
	}

	public ArrayList<String> getComplexPrescr() {
		return complexPrescr;
	}

	public static int getNodiagnosised() {
		return NODIAGNOSISED;
	}
	public static int getDiagnosised() {
		return DIAGNOSISED;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
}
