package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.MemberVO;
import com.company.dto.PatientVO;
import com.company.mapper.MemberMapper;
import com.company.service.MemberService;
/**
 * HomeController에의 요청을 받아와서 DAO와 연결
 *
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public List<MemberVO> selectMember() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectMember();
	}

	@Override
	public void insertEvalRule(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		mapper.insertEvalRule(memberVO);
	}

	@Override 
	public MemberVO viewPatientRecord(String patientNum) throws Exception {
		// TODO Auto-generated method stub
		return mapper.viewPatientRecord(patientNum);
	}

	@Override
	public void deleteRecord(String patientNum) throws Exception {
		// TODO Auto-generated method stub
		mapper.deleteRecord(patientNum);
	}

	@Override
	public List<MemberVO> getSearchEvalRule(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getSearchEvalRule(member);
	}

	@Override
	public List<PatientVO> getSearchPatient(PatientVO patient) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getSearchPatient(patient);
	}

}
