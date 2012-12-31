package com.emflant.accounting.screen.component;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;

import com.emflant.accounting.common.EntMultiBusiness;
import com.emflant.accounting.common.EntProcessServices;
import com.emflant.accounting.common.EntSingleBusiness;
import com.emflant.accounting.screen.component.EntDialog.EntMessageType;


public class EntFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EntProcessServices processServices;
	
	
	public void doBusinessOpsOneTransaction(EntSingleBusiness business){
		
		this.processServices.doBusinessOpsOneTransaction(business);
		
		if(!business.isComplete()){
			EntDialog dialog = new EntDialog(EntMessageType.ERROR, 
					business.getMessage());
			
			dialog.showMessageDialog(this);
		}
		
		
	}
	
	public void doBusinessOpsOneTransaction(EntMultiBusiness business){
		
		this.processServices.doBusinessOpsOneTransaction(business);
		
		if(!business.isComplete()){
			EntDialog dialog = new EntDialog(EntMessageType.ERROR, 
					business.getMessage());
			
			dialog.showMessageDialog(this);
		}
		
		
	}
	
	
	
}
