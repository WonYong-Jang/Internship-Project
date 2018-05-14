package com.company.drools;

import java.util.Map;

import javax.inject.Inject;

import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.company.dto.PatientVO;
import com.drools.po.PrescrGroupMap;
import com.drools.po.RuleMap;

@Component("DroolsSpringTest")
public class DroolsSpringTest {
	
	public static PatientVO patient;
	@Inject
	public static RuleMap ruleMap;
	@Inject
	public static PrescrGroupMap groupMap;
	@Autowired
	private ApplicationContext applicationContext;
	/**
	 * DomainRule 을 map 타입으로 셋팅 
	 */
	public void setRuleMap(Map<String,Object> map) {
		ruleMap = new RuleMap();
		ruleMap.setRuleMap(map);
		System.out.println("setRuleMap success");
		//DomainRuleVO domain = (DomainRuleVO) ruleMap.map.get("체기");
		//System.out.println("///////////////////"+domain.getRuleID());
	}
	public void setGroupMap(Map<String,Object> map) {
		groupMap = new PrescrGroupMap();
		groupMap.setGroupMap(map);
		System.out.println("setGroupMap success");
	}
	public void setPatient(PatientVO patient) {
		DroolsSpringTest.patient = patient;
	}
	public static void main(String args[]) {
	}
	/**
	 * 환자를 선택 후 검사하기 버튼을 눌렀을 경우만 checkSymptom() 실행
	 */
	public PatientVO checkSymptom() {
		try {
			// 경로 설정
			applicationContext = new ClassPathXmlApplicationContext(
					"drools-context/applicationContext-drools.xml");
			// stateful 방식의 session 을 getbean
			StatefulKnowledgeSession ksession = (StatefulKnowledgeSession) applicationContext
					.getBean("ksession");

			ksession.insert(groupMap);
			ksession.insert(ruleMap);
			ksession.insert(patient);
			ksession.fireAllRules();
			
		} catch( Throwable e) {
			e.printStackTrace();
		}
		return patient;
	}
}