package com.emflant.accounting.screen.component;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

class EntJTextFieldForAmountFocusListener implements FocusListener {
	
	private JTextField jTextField;
	
	public EntJTextFieldForAmountFocusListener(JTextField jTextField){
		this.jTextField = jTextField;
	}

	public void focusGained(FocusEvent e) {
		if(this.jTextField.getText().length() == 0){
			this.jTextField.setText("0");
		}
		this.jTextField.selectAll();
	}

	public void focusLost(FocusEvent e) {
		if(this.jTextField.getText().length() == 0){
			this.jTextField.setText("0");
		}
		
	}
}