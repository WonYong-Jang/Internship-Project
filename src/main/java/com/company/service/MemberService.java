package com.company.service;

import java.util.List;

import com.company.dto.MemberVO;
import com.company.dto.PatientVO;

public interface MemberService {

		// DB�� �ִ� Rule�򰡵� ���̺� data �ҷ�����
		public List<MemberVO> selectMember() throws Exception;
		
		// Rule �� �� DB�� ���� �� �� �ǿ� �����ֱ�
		public void insertEvalRule(MemberVO memberVO) throws Exception;
		
		// ������ ����� ���ڵ� ����
		public MemberVO viewPatientRecord(String patientNum) throws Exception;
		
		// ������ ����� ���ڵ� ����
		public void deleteRecord(String patientNum) throws Exception;
		
		// �� �� �� ���̺� �˻����
		public List<MemberVO> getSearchEvalRule(MemberVO member) throws Exception;
		
		// ȯ�� �˻�
		public List<PatientVO> getSearchPatient(PatientVO patient) throws Exception;
		
}
