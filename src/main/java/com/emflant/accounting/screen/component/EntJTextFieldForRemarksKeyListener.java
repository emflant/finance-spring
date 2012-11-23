package com.emflant.accounting.screen.component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

class EntJTextFieldForRemarksKeyListener implements KeyListener {

	
	private JTextField jTextField;
	
	public EntJTextFieldForRemarksKeyListener(JTextField jTextField){
		this.jTextField = jTextField;
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 10){
			this.jTextField.transferFocus();
			return;
		}
		
	}


	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
