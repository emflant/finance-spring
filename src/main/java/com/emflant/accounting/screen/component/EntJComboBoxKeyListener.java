package com.emflant.accounting.screen.component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;


class EntJComboBoxKeyListener implements KeyListener {

	private JComboBox jComboBox;
	
	public EntJComboBoxKeyListener(JComboBox jComboBox){
		this.jComboBox = jComboBox;
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	//EntLogger.debug(this.jComboBox.isPopupVisible());
		if(!this.jComboBox.isPopupVisible()){
			if(e.getKeyCode() == 10){
				this.jComboBox.transferFocus();
				return;
			}
		}
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
