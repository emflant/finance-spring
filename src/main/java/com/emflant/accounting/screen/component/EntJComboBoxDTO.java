package com.emflant.accounting.screen.component;

public class EntJComboBoxDTO {
	
	
	private String code;
	private String codeName;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return code+":"+codeName;
	}
}
