package com.company.service;

import java.util.List;

import com.company.dto.MemberVO;
import com.company.dto.PatientVO;

public interface MemberService {

		// DB에 있는 Rule평가된 테이블 data 불러오기
		public List<MemberVO> selectMember() throws Exception;
		
		// Rule 평가 후 DB에 저장 및 평가 탭에 보여주기
		public void insertEvalRule(MemberVO memberVO) throws Exception;
		
		// 선택한 목록의 레코드 보기
		public MemberVO viewPatientRecord(String patientNum) throws Exception;
		
		// 선택한 목록의 레코드 삭제
		public void deleteRecord(String patientNum) throws Exception;
		
		// 평가 된 룰 테이블 검색기능
		public List<MemberVO> getSearchEvalRule(MemberVO member) throws Exception;
		
		// 환자 검색
		public List<PatientVO> getSearchPatient(PatientVO patient) throws Exception;
		
}
