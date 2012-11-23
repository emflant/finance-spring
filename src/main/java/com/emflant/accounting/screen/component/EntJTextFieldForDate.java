package com.emflant.accounting.screen.component;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.emflant.accounting.common.EntDate;


public class EntJTextFieldForDate {

	private JTextField jTextField;
	
	public EntJTextFieldForDate(){
		this(8);
	}
	
	public EntJTextFieldForDate(int size){
		this.jTextField = new JTextField(size);
		this.jTextField.setHorizontalAlignment(JTextField.CENTER);
		this.jTextField.setDocument(new EntJTextFiledLimit(11,this.jTextField));
		this.jTextField.setText("____-__-__");
		addEventListener();
		setToday();
	}
	
	private void addEventListener(){
		
		this.jTextField.addFocusListener(new EntJTextFieldForDateFocusListener(this.jTextField));
		this.jTextField.addKeyListener(new EntJTextFieldForDateKeyListener(this.jTextField));
	}
	
	public void setEnabled(boolean bool){
		this.jTextField.setEnabled(bool);
	}
	

	public String getText3(){
		return this.jTextField.getText();
	}
	
	public void setToday(){
		String strToday = EntDate.getToday();
		StringBuilder sb = new StringBuilder(strToday);
		sb = sb.insert(4, '-');
		sb = sb.insert(7, '-');
		
		this.setValue(sb.toString());
	}
	
	
	public void setValue(String value){
		
		//������ ���� �޾� �ʵ忡 �������� ���� �����ش�.
		this.jTextField.setText(value);
	}

	public String getValue(){
		String str = this.jTextField.getText().replace("-", "");
		return str;
	}
	
	public void addPanel(JPanel jPanel){
		jPanel.add(this.jTextField);
	}
	

}
