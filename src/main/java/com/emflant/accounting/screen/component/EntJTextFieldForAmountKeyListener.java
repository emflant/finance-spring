package com.emflant.accounting.screen.component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.JTextField;


class EntJTextFieldForAmountKeyListener implements KeyListener {
	
	private JTextField jTextField;
	private DecimalFormat decimalFormat;
	public EntJTextFieldForAmountKeyListener(JTextField jTextField, DecimalFormat decimalFormat){
		this.jTextField = jTextField;
		this.decimalFormat = decimalFormat;
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		char chr = e.getKeyChar();
		int  key = e.getKeyCode();
		//EntLogger.debug("input2 : "+key+", "+chr);
		if(e.getKeyCode() == 10){
			this.jTextField.transferFocus();
			return;
		}
		
	}

	public void keyReleased(KeyEvent e) {

		//EntLogger.debug(e.getKeyCode());
		
		if(e.getKeyCode() == 10){
			return;
		}
		
		String strOrigin = this.jTextField.getText().replace(",", "");
		
		if(strOrigin.equals("") 
				|| e.getKeyCode() == 37 
				|| e.getKeyCode() == 39
				|| e.getKeyCode() == 16){
			return;
		}
		
		String str = this.decimalFormat.format(new BigDecimal(strOrigin).longValue());
		this.jTextField.setText(str);
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
				
	}
	
	

}
