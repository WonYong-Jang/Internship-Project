package com.company.mapper;

import java.util.List;

import com.company.dto.DomainRuleVO;
import com.company.dto.PatientDiagnosisVO;
import com.company.dto.PatientSymptomVO;
import com.company.dto.PatientVO;
import com.company.dto.PrescriptionGroupVO;
import com.company.dto.SymptomVO;


public interface RuleMapper {
	// DB에 있는 한의학 Rule 불러오기
	public List<DomainRuleVO> selectDomain() throws Exception;
	
	// DB에 있는 한의학 Rule 처방군 불러오기
	public List<PrescriptionGroupVO> selectPrescription() throws Exception;
	
	// 환자 검색 후 자동완성 기능 입력란에 환자 이름이 들어가게 되면 자동으로 환자의 설문결과와 증상이 입력 후 Drools에 의해 검사할 준비
	public PatientVO getPatientSymptoms(String pNumber) throws Exception;
	
	// 저장 버튼을 눌렀을때 환자 진단 기록을 저장
	public void savePatientDiagnosis(PatientDiagnosisVO diagnosis) throws Exception;
	
	// 선택한 목록의 증상 삭제
	public void deleteSymptom(PatientSymptomVO symptomVO) throws Exception;
	
	// 증상 추가
	public void addSymptom(PatientSymptomVO symptom) throws Exception;
	
	// 증상 검색
	public List<SymptomVO> getSearchSymptom(SymptomVO symptom) throws Exception;		
}
