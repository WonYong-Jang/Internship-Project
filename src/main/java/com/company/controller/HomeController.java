package com.company.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.dto.MemberVO;
import com.company.dto.PatientVO;
import com.company.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService service;
	
	/**
	 * 처음 defaultPage 로 이동
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) throws Exception{

		logger.info("defaultPage");

		return "defaultPage";
	}

	/**
	 * @param db에서 받아온 평가된 rule 데이터를 memberList라는 이름으로 받아와서 model에 추가후 리턴(evalTablePage.jsp 에서 memberList
	 * 라는 이름으로 사용 
	 */
	@RequestMapping(value="/evalTablePage")
	public String evaluateRule(Model model) throws Exception
	{
		logger.info("evalTablePage");
		List<MemberVO> memberList = service.selectMember();
		
		model.addAttribute("memberList", memberList);
		
		return "evalTablePage";
	}
	/**
	 * @param memberVO : dto 객체에 작성한 내용을 담아서 db에 저장 후 rule 평가테이블에도 보여줌
	 */
	@RequestMapping(value="ruleEvaluate")
	public String write(MemberVO memberVO) throws Exception
	{
		logger.info("ruleEvaluate");
		
		service.insertEvalRule(memberVO);
		return "redirect:/"; // 저장후 그대로 defaultPage로 이동
	}
	
	@RequestMapping(value="deleteRecord") //삭제예정
	public String delete(@RequestParam String patientNum) throws Exception
	{
		logger.info("클릭한 아이디 Delete: "+ patientNum);
		service.deleteRecord(patientNum);
		return "redirect:/";
	}
	
	@RequestMapping(value="selectRule") //삭제예정
	public String selectRule(Model model) throws Exception
	{
		
		logger.info("selectRule Success");
		
		return "evalTablePage";
	}
	 /**
	  * 환자 이름/환자 번호로 환자 검색
	 * @throws Exception 
	  */
	 @RequestMapping(value ="/searchPatientInfo", method = RequestMethod.GET)
	 public @ResponseBody List<PatientVO> searchPatientInfo(PatientVO patient) throws Exception
	 {
		List<PatientVO> list = service.getSearchPatient(patient);
		for(PatientVO vo : list)
		{
			System.out.println("/////////////"+vo.getpName()+vo.getpNumber() + " "+ vo.symptomArr.size());
		}
		return list;
	 }
	 
}