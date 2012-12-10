package com.emflant.accounting.screen.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class EntJComboBox {
	
	private JComboBox jComboBox;
	private List<EntJComboBoxDTO> model;
	private HashMap<String, EntJComboBoxDTO> index;
	
	public EntJComboBox(){
		this.jComboBox = new JComboBox();
	}
	
	
	public void addPanel(JPanel jPanel){
		jPanel.add(this.jComboBox);
	}
	
	public void setList(List<HashMap<String, String>> list){
		
		this.model = new ArrayList<EntJComboBoxDTO>();
		this.index = new HashMap<String, EntJComboBoxDTO>();
		
		for(HashMap<String, String> hm : list){
			
			EntJComboBoxDTO element = new EntJComboBoxDTO();
			element.setCode(hm.get("code"));
			element.setCodeName(hm.get("code_name"));
			
			this.model.add(element);
			this.index.put(hm.get("code"), element);
		}
		
		setModel(this.model);
	}
	
	public void setModel(List<EntJComboBoxDTO> model){
		this.jComboBox.setModel(new DefaultComboBoxModel(model.toArray()));
	}
	

}
