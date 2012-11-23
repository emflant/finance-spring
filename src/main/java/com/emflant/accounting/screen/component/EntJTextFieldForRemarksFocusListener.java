package com.emflant.accounting.screen.component;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

class EntJTextFieldForRemarksFocusListener implements FocusListener {
	
	private JTextField jTextField;
	
	public EntJTextFieldForRemarksFocusListener(JTextField jTextField){
		this.jTextField = jTextField;
	}

	
	public void focusGained(FocusEvent e) {
		this.jTextField.setCaretPosition(0);
		this.jTextField.selectAll();
	}

	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

}
