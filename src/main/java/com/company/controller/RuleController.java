package com.company.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.drools.DroolsSpringTest;
import com.company.dto.DomainRuleVO;
import com.company.dto.MemberVO;
import com.company.dto.PatientDiagnosisVO;
import com.company.dto.PatientSymptomVO;
import com.company.dto.PatientVO;
import com.company.dto.PrescriptionGroupVO;
import com.company.dto.SymptomVO;
import com.company.service.MemberService;
import com.company.service.RuleService;

@Controller
public class RuleController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private RuleService ruleService;
	@Inject
	private MemberService service;
	
	private DroolsSpringTest drools;
	
	private PatientVO patient;
	private PatientSymptomVO symptomVO;
	/**
	 *  ó�� �ý����� �����Ű�� �˻��ϱ����� domainRule�� �����ͺ��̽����� �ҷ��ͼ� �ѹ��� ����
	 */
	@PostConstruct // ������ annotation
	public void initialize(){ 
		
		patient = new PatientVO();
		symptomVO = new PatientSymptomVO();
		List<DomainRuleVO> ruleList = null; // rules
		// �� rule �� ���� ó���
		List<PrescriptionGroupVO> prescrList = null; // db���� �ҷ��� ó�決 ����Ʈ 
		try {
			ruleList = ruleService.selectDomain();
			//System.out.println(ruleList.get(0).medicines.get(0).getMedicine()+"//////////");
			
			prescrList = ruleService.selectPrescription();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object>ruleMap = new HashMap<String,Object>();
		Map<String,Object> groupMap = new HashMap<String,Object>();
		for(DomainRuleVO obj : ruleList) // hashmap Ÿ������ �����ؼ� ruleID �� �̿��ؼ� ���� ã�� ���ؼ� ����
		{
			ruleMap.put(obj.getRuleID(), obj);
			obj.countAndSymptom(); // ���� anySymptom ī��Ʈ ���
		}
		for(PrescriptionGroupVO obj : prescrList) // hashmap Ÿ������ �����ؼ� ó�決�̸��� �̿��ؼ� ���� ã�� ���ؼ� ����
		{
			groupMap.put(obj.getPrescrGroup(), obj);
			//System.out.println(obj.getPrescrList());
		}
		drools = new DroolsSpringTest();
		drools.setRuleMap(ruleMap); // drools �˻��ϱ� �� hashMap ����
		drools.setGroupMap(groupMap);

		logger.info("setRuleDomain complete!");
	}
	
	/**
	 * �˻��ϱ� ��ư�� ������ ���
	 */
	 @RequestMapping(value ="/checkSymptom", method = RequestMethod.GET)
	 public @ResponseBody PatientDiagnosisVO viewDiagnosis(Locale locale) 
	 {
		logger.info("checkSymptom");
		
		patient.diagnosis.complexPrescr.clear();
		patient.diagnosis.simplePrescr.clear();
		patient.diagnosis.diagnosisArr.clear();
		drools.setPatient(patient); // ȯ�� ���� ����
		
		patient = drools.checkSymptom(); // �˻��ϱ� ��ư�� ������ drools �˻� ����
		
		//System.out.println("////////���õ� ȯ�� ó�決������"+patient.diagnosis.selectedGroupList.size());
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("�ܼ�ó�� ����� : "+patient.diagnosis.simplePrescr);
		System.out.println("����ó�� ����� : "+patient.diagnosis.complexPrescr);
		/*	
		for(PrescriptionGroupVO obj : patient.diagnosis.selectedGroupList) //ø�� Ȯ�� log
		{
			System.out.println(obj.getPrescrGroup() +" ø�࿡�� ���õ� ó��� : ");
			for(PrescriptionVO vo : obj.getPrescrList())
			{
				System.out.println(vo.getMedicine());
			}
		}*/
		
	    return patient.diagnosis;
	 }
	 
	 /**
	 * �˻� �Ϸ������� �ش� ȯ���� ���� ����� ���� ����� �����ְ� ������ �غ� ��
	 * @throws Exception 
	 */
	 @RequestMapping(value ="/getPatientSymptoms", method = RequestMethod.GET)
	 public @ResponseBody PatientVO getPatientSymptoms(@RequestParam("pNumber") String pNumber) throws Exception
	 {
		System.out.println("/////////////////////"+pNumber);
		patient = ruleService.getPatientSymptoms(pNumber); //ȯ�� ��ȣ�� �ش� ȯ�� �˻�
		
		logger.info("ȯ�� ���� ã��: "+ patient.getpName()+ " "+patient.symptomArr.size());
		for(int i=0; i< patient.symptomArr.size(); i++) {
			
			System.out.println(patient.symptomArr.get(i).getSymptom());
		}
		return patient;
	 }
	 
	 /**
	 * �� ���� ���� ��ư ������ ��
	 * @throws Exception
	 */
	 @RequestMapping(value ="/saveEvalRule", method = RequestMethod.GET)
	 public @ResponseBody PatientDiagnosisVO saveEvalRule(@RequestParam("comment") String comment, 
			 @RequestParam("score") int score) throws Exception
	 {
		logger.info("saveEvalRule: "+comment+ " "+score);
		patient.diagnosis.setComment(comment);
		patient.diagnosis.setScore(score);
		patient.diagnosis.setVisitDate(patient.getVisitDate());
		patient.diagnosis.setpName(patient.getpName()); // �� ���� ��� ���� ó�� ���ֱ�
		patient.diagnosis.setpNumber(patient.getpNumber()); // �� ���� ��� ���� ó�� ���ֱ�
		savePatient();
		return patient.diagnosis;
	 }
	 
	 /**
	 * ���� ��ư�� ������ ��� �ڸ�Ʈ�� ���� �Է��� �Ϸ�ǰ� �Լ� ���� => ��� ����
	 * @throws Exception
	 */
	 public String savePatient() throws Exception
	 {
		 logger.info("savePatient");
		 ruleService.savePatientDiagnosis(patient.diagnosis);
		 return "redirect:/";
	 }
	 
	 /**
	 * �򰡵� �� ���̺� �˻����
	 * @throws Exception
	 */
	 @RequestMapping(value ="/searchEvalRule", method = RequestMethod.GET)
	 public @ResponseBody List<MemberVO> searchEvalRule(MemberVO member) throws Exception
	 {
		 List<MemberVO> list = service.getSearchEvalRule(member);
		 return list;
	 }
	 
	 /**
	 * ȯ�� ���� ����Ʈ���� ���� ��ư�� ������ ����
	 * @throws Exception
	 */
	 @RequestMapping(value ="/deleteSelectedSymptom", method = RequestMethod.POST)
	 public @ResponseBody PatientVO deleteSelectedSymptom(@RequestParam("symptom") String symptom) throws Exception
	 {
		System.out.println(symptom);
		symptomVO.setSymptom(symptom);
		symptomVO.setpNum(patient.getpNumber());
		symptomVO.setVisitDate(patient.diagnosis.getVisitDate());
		ruleService.deleteSymptom(symptomVO);
		for(PatientSymptomVO vo : patient.symptomArr) {
			if( vo.getSymptom().equals(symptom)) {
				patient.symptomArr.remove(vo);
				break;
			}
		}
		return patient;
	 }
	 
	 /**
	 * ȯ�� ���� �߰�
	 * @throws Exception
	 */
	 @RequestMapping(value ="/addPatientSymptom", method = RequestMethod.POST)
	 public @ResponseBody PatientSymptomVO addPatientSymptom(@RequestParam("symptom") String symptom) throws Exception
	 {
		System.out.println(symptom);
		PatientSymptomVO vo = new PatientSymptomVO();
		vo.setSymptom(symptom); // �޾ƿ� ���� ����
		vo.setVisitDate(patient.diagnosis.getVisitDate()); // ������ ��¥�� �־��� ������� ����ϱ� ����
		vo.setpNum(patient.getpNumber()); // �˻� �Է¶��� �ִ� ȯ�� ��ȣ �״�� ����
		vo.setDegree(6); // ���Ƿ� ����
		patient.symptomArr.add(vo); // ȯ�� ���� �迭�� �߰�
		ruleService.addSymptom(vo);
		return vo;
	 }
	 
	 /**
	 * ���� �̸����� ���� �˻�
	 * @throws Exception 
	 */
	 @RequestMapping(value ="/searchSymptom", method = RequestMethod.GET)
	 public @ResponseBody List<SymptomVO> searchSymptom(SymptomVO symptom) throws Exception
	 {
		 List<SymptomVO> list = ruleService.getSearchSymptom(symptom);
		return list;
	 }
	 
	/**
	 * �򰡵� ����� ����� Ŭ���� ȯ�ڰ� �ش� ��¥�� ���᳻������ �̵�
	 */
	@RequestMapping(value="patientDiagnosis_view", method = RequestMethod.GET)
	public @ResponseBody PatientDiagnosisVO viewSelectedPatient(@RequestParam("patientNum") String patientNum,
			@RequestParam("visitDate") String visitDate) throws Exception
	{
		logger.info("����ȯ�ڱ���̷� �̵� View: "+patientNum+" "+visitDate);
		//model.addAttribute("member", service.selectedNumID(numID));
		//model.addAttribute("member", service.viewPatientRecord(pNumber));
		return patient.diagnosis;
	}
}
