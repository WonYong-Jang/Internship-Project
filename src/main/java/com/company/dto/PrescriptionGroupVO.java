package com.company.dto;

import java.util.ArrayList;

/**
 * ó�� �� ( ���� ó��� ����Ʈ�� ���ԵǾ� ����)
 */
public class PrescriptionGroupVO {
	
	public ArrayList<PrescriptionVO> prescrList;
	public String prescrGroup;
	
	public PrescriptionGroupVO() {
	}

	public PrescriptionGroupVO(String prescrGroup)
	{
		prescrList = new ArrayList<PrescriptionVO>();
		this.prescrGroup = prescrGroup;
	}
	public ArrayList<PrescriptionVO> getPrescrList() {
		return prescrList;
	}

	public void setPrescrList(ArrayList<PrescriptionVO> prescrList) {
		this.prescrList = prescrList;
	}

	public String getPrescrGroup() {
		return prescrGroup;
	}

	public void setPrescrGroup(String prescrGroup) {
		this.prescrGroup = prescrGroup;
	}
}
