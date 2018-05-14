package com.drools.po;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.company.dto.MedicineVO;
import com.company.dto.PrescriptionGroupVO;

public class PatientDiagnosis implements Cloneable{
	//public String  prescription, doctorOpinion;
	
	private String pNumber; // ȯ�� ��ȣ�� �̸���  ���� ���̺� �Ѱ��ֱ� ���� Ŭ������ ����� ���� �ѹ� �� ���
	private String pName; 
	private String comment; // �ش� ȯ�ڰ� ���� ���ܿ� ���� �� �� 
	private int score;
	private Date date; // ���� ��¥
	
	public ArrayList<String> selectedGroup; // �ǻ簡 ������ ó�決 ��Ʈ��
	public List<PrescriptionGroupVO> selectedGroupList; // ȯ���� ����� ó�決�� ���ؼ� ��ġ�ϴ� ó�決 ����Ʈ
	public ArrayList<String> simplePrescr; // ȯ�ڿ� ���� ��Ī �Ǵ� �ܼ�ó��
	public ArrayList<String> complexPrescr; // ȯ�ڿ� ���� ��Ī �Ǵ� ����ó��
	public ArrayList<String> diagnosisArr; // ȯ�ڰ� ���� ���ܸ� ����Ʈ
	
	public static final int NODIAGNOSISED   = 0; //���� ������ ����.
    public static final int DIAGNOSISED = 1; //���� ������ �ִ�. 
    
    public int state;
   // public int ruleCheckCnt; // ��� ���� �� üũ�ߴ��� Ȯ���ϱ� ����
    
	public PatientDiagnosis() {
		this.state = NODIAGNOSISED;
		simplePrescr = new ArrayList<String>();
		complexPrescr = new ArrayList<String>();
		selectedGroup = new ArrayList<String>();
		diagnosisArr = new ArrayList<String>();
		
		selectedGroup.add("�����"); ////////////////// �ǻ簡 üũ������ ������ ó�決 �ӽ÷� ����
		selectedGroup.add("��������");
		
		selectedGroupList = new ArrayList<PrescriptionGroupVO>();
	}
	public Object clone() {
		try {
			PatientDiagnosis obj = (PatientDiagnosis)super.clone();
			return obj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}
	
	public void setComplexPrescr(ArrayList<MedicineVO> medicines) // ����� ó���� ����
	{
		for(MedicineVO obj : medicines)
		{
			complexPrescr.add(obj.getMedicine());
		}
	}
	public void setSimplePrescr(ArrayList<MedicineVO> medicines) // ����� ó��� ���� ( �ܼ� ó���̴� �迭ũ��� 1)
	{
		for(MedicineVO obj : medicines)
		{
			simplePrescr.add(obj.getMedicine());
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	/* ��Ʈ�� �迭�� change �߱⶧���� ��� �ּ�ó�� ���߿� �����ϱ�
	public void resetRecord() {
		this.diagnosis = this.prescription = "";
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis += ("\n"+diagnosis);
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setPrescription(String prescription) {
		this.prescription += ("\n"+prescription);
	}
	public String getPrescription() {
		return prescription;
	}
	public void setDoctorOpinion(String doctorOpinion) {
		this.doctorOpinion = doctorOpinion;
	}
	public String getDoctorOpinion() {
		return doctorOpinion;
	}*/
	
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
	
}