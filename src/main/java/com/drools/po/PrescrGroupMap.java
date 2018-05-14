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
		System.out.println("ȯ�� ����ó�� ������ "+pLen);
		System.out.println("ȯ�� �ܼ�ó�� ������ "+patient.diagnosis.simplePrescr.size());
		if(pLen == 0) return false;
		System.out.println("�ǻ簡 ������ ø�౺ ������: "+patient.diagnosis.selectedGroup.size());
		for(String groupName : patient.diagnosis.selectedGroup) // �ǻ簡 ������ ó�決�� ȯ���� ����ó�濡�� ���� ó���� ��
		{
			PrescriptionGroupVO pg = map.getGroupMatch(groupName);
			System.out.println(groupName+" ó�決 : "+pg.prescrList.size());
			int dLen = pg.prescrList.size();
			
			PrescriptionGroupVO selectedPrescrGroup = new PrescriptionGroupVO(groupName);
			for(int target = 0; target < pLen; target++)
			{
				int middle=0, startIndex=0, endIndex = dLen-1;
				do // ���� �˻�
				{
					if(startIndex > endIndex) break;
				
					middle = (startIndex + endIndex)/2;
					if(pg.prescrList.get(middle).getMedicine().compareTo(patient.diagnosis.complexPrescr.get(target)) == 0)
					{
						PrescriptionVO temp = pg.prescrList.get(middle);
						selectedPrescrGroup.prescrList.add(temp);
						System.out.println("ó�決�� ��ġ�� ó��� : "+patient.diagnosis.complexPrescr.get(target));
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
