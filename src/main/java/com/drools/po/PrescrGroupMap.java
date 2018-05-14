package com.drools.po;

import java.util.Map;

import com.company.dto.PatientVO;
import com.company.dto.PrescriptionGroupVO;
import com.company.dto.PrescriptionVO;

public class PrescrGroupMap {
	public Map<String,Object> groupMap;
	
	public Map<String, Object> getGroupMap() {
		return groupMap;
	}
	public void setGroupMap(Map<String, Object> groupMap) {
		this.groupMap = groupMap;
	}
	public PrescriptionGroupVO getGroupMatch(String key)
	{
		return (PrescriptionGroupVO) groupMap.get(key);
	}
	public boolean checkPrescrGroupTest(PatientVO patient, PrescrGroupMap map) {
		int pLen = patient.diagnosis.complexPrescr.size();
		System.out.println("환자 복합처방 사이즈 "+pLen);
		System.out.println("환자 단순처방 사이즈 "+patient.diagnosis.simplePrescr.size());
		if(pLen == 0) return false;
		System.out.println("의사가 선택한 첩약군 사이즈: "+patient.diagnosis.selectedGroup.size());
		for(String groupName : patient.diagnosis.selectedGroup) // 의사가 선택한 처방군과 환자의 복합처방에서 나온 처방약과 비교
		{
			PrescriptionGroupVO pg = map.getGroupMatch(groupName);
			System.out.println(groupName+" 처방군 : "+pg.prescrList.size());
			int dLen = pg.prescrList.size();
			
			PrescriptionGroupVO selectedPrescrGroup = new PrescriptionGroupVO(groupName);
			for(int target = 0; target < pLen; target++)
			{
				int middle=0, startIndex=0, endIndex = dLen-1;
				do // 이진 검색
				{
					if(startIndex > endIndex) break;
				
					middle = (startIndex + endIndex)/2;
					if(pg.prescrList.get(middle).getMedicine().compareTo(patient.diagnosis.complexPrescr.get(target)) == 0)
					{
						PrescriptionVO temp = pg.prescrList.get(middle);
						selectedPrescrGroup.prescrList.add(temp);
						System.out.println("처방군과 일치한 처방약 : "+patient.diagnosis.complexPrescr.get(target));
						break;
					}
					else if(pg.prescrList.get(middle).getMedicine().compareTo(patient.diagnosis.complexPrescr.get(target)) < 0) 
					{
						startIndex = middle+1;
					}
					else if(pg.prescrList.get(middle).getMedicine().compareTo(patient.diagnosis.complexPrescr.get(target)) > 0)
					{
						endIndex = middle-1;
					}
				}
				while(true);
			}
			patient.diagnosis.selectedGroupList.add(selectedPrescrGroup);
		}
		return true;
	}
}
