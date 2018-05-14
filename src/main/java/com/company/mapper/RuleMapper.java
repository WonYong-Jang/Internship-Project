package com.company.mapper;

import java.util.List;

import com.company.dto.DomainRuleVO;
import com.company.dto.PatientDiagnosisVO;
import com.company.dto.PatientSymptomVO;
import com.company.dto.PatientVO;
import com.company.dto.PrescriptionGroupVO;
import com.company.dto.SymptomVO;


public interface RuleMapper {
	// DB�� �ִ� ������ Rule �ҷ�����
	public List<DomainRuleVO> selectDomain() throws Exception;
	
	// DB�� �ִ� ������ Rule ó�決 �ҷ�����
	public List<PrescriptionGroupVO> selectPrescription() throws Exception;
	
	// ȯ�� �˻� �� �ڵ��ϼ� ��� �Է¶��� ȯ�� �̸��� ���� �Ǹ� �ڵ����� ȯ���� ��������� ������ �Է� �� Drools�� ���� �˻��� �غ�
	public PatientVO getPatientSymptoms(String pNumber) throws Exception;
	
	// ���� ��ư�� �������� ȯ�� ���� ����� ����
	public void savePatientDiagnosis(PatientDiagnosisVO diagnosis) throws Exception;
	
	// ������ ����� ���� ����
	public void deleteSymptom(PatientSymptomVO symptomVO) throws Exception;
	
	// ���� �߰�
	public void addSymptom(PatientSymptomVO symptom) throws Exception;
	
	// ���� �˻�
	public List<SymptomVO> getSearchSymptom(SymptomVO symptom) throws Exception;		
}
