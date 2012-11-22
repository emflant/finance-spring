package com.emflant.accounting.main.component;


import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntJTextFieldForRemarks {

	private JTextField jTextField;
	
	public EntJTextFieldForRemarks(){
		this(10);
	}
	
	public EntJTextFieldForRemarks(int size){
		this.jTextField = new JTextField(size);
		this.jTextField.setHorizontalAlignment(JTextField.LEFT);
		
		addEventListener();
	}
	
	private void addEventListener(){
		
		this.jTextField.addFocusListener(new EntJTextFieldForRemarksFocusListener(this.jTextField));
		this.jTextField.addKeyListener(new EntJTextFieldForRemarksKeyListener(this.jTextField));
	}
	
	public void setEnabled(boolean bool){
		this.jTextField.setEnabled(bool);
	}
	

	public String getText(){
		return this.jTextField.getText();
	}
	
	public void setText(String value){
		this.jTextField.setText(value);
	}
	


	
	public void addPanel(JPanel jPanel){
		jPanel.add(this.jTextField);
	}
	
}
