package com.emflant.accounting.main.component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.FieldPosition;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.emflant.common.EntException;
import com.emflant.common.EntLogger;

public class EntJTextFieldForAmount {
	
	private JTextField jTextField;
	private DecimalFormat decimalFormat;
	
	public EntJTextFieldForAmount(){
		this(7);
	}
	
	public EntJTextFieldForAmount(int size){
		this.jTextField = new JTextField(size);
		this.jTextField.setHorizontalAlignment(JTextField.RIGHT);
		this.jTextField.setText("0");
		addEventListener();
	}
	
	private void addEventListener(){
		
		this.decimalFormat = new DecimalFormat("#,###");
		this.jTextField.addFocusListener(new EntJTextFieldForAmountFocusListener(this.jTextField));
		this.jTextField.addKeyListener(new EntJTextFieldForAmountKeyListener(this.jTextField, this.decimalFormat));
	}
	
	public void setEnabled(boolean bool){
		this.jTextField.setEnabled(bool);
	}
	

	public String getText(){
		return this.jTextField.getText();
	}
	
	public void setValue(BigDecimal value) {
		setValue(value.toPlainString());
	}
	
	public void setValue(String value){
		
		//포맷전 값을 받아 필드에 포맷팅한 값을 보여준다.
		String str = this.decimalFormat.format(new BigDecimal(value).longValue());
		this.jTextField.setText(str);
	}

	public String getValue(){
		String str = this.jTextField.getText().replace(",", "");
		return str;
	}
	
	public void addPanel(JPanel jPanel){
		jPanel.add(this.jTextField);
	}
	

}
