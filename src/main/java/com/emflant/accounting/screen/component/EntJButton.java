package com.emflant.accounting.screen.component;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EntJButton {

	private JButton jButton;
	
	public EntJButton(String text){
		this.jButton = new JButton(text);
		this.jButton.setFocusable(false);
	}
	
	public void addActionListener(ActionListener actionListener){
		this.jButton.addActionListener(actionListener);
	}
	
	
	public void addPanel(JPanel jPanel){
		jPanel.add(this.jButton);
	}
	
}
