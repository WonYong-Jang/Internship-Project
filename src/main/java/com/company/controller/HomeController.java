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
	 * ó�� defaultPage �� �̵�
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) throws Exception{

		logger.info("defaultPage");

		return "defaultPage";
	}

	/**
	 * @param db���� �޾ƿ� �򰡵� rule �����͸� memberList��� �̸����� �޾ƿͼ� model�� �߰��� ����(evalTablePage.jsp ���� memberList
	 * ��� �̸����� ��� 
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
	 * @param memberVO : dto ��ü�� �ۼ��� ������ ��Ƽ� db�� ���� �� rule �����̺��� ������
	 */
	@RequestMapping(value="ruleEvaluate")
	public String write(MemberVO memberVO) throws Exception
	{
		logger.info("ruleEvaluate");
		
		service.insertEvalRule(memberVO);
		return "redirect:/"; // ������ �״�� defaultPage�� �̵�
	}
	
	@RequestMapping(value="deleteRecord") //��������
	public String delete(@RequestParam String patientNum) throws Exception
	{
		logger.info("Ŭ���� ���̵� Delete: "+ patientNum);
		service.deleteRecord(patientNum);
		return "redirect:/";
	}
	
	@RequestMapping(value="selectRule") //��������
	public String selectRule(Model model) throws Exception
	{
		
		logger.info("selectRule Success");
		
		return "evalTablePage";
	}
	 /**
	  * ȯ�� �̸�/ȯ�� ��ȣ�� ȯ�� �˻�
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