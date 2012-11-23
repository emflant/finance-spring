package com.emflant.accounting.screen.component;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


class EntJTextFiledLimit extends PlainDocument {

	public int maxLength;
	private JTextField jTextField;
	
	public EntJTextFiledLimit(int maxLength, JTextField jTextField){
		this.maxLength = maxLength;
		this.jTextField = jTextField;
	}
	
	@Override
	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		
		//EntLogger.debug(offs+" : "+str+", "+jTextField.getSelectedText());
		
		if(str == null) return;
		
		if(str.length() == 1) {
			
			if(!(str.equals("0") || str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4")
				|| str.equals("4") || str.equals("5") ||  str.equals("6") || str.equals("7") || str.equals("8") || str.equals("9")
					 
				)){
				return;
			}
			
			
			if(getLength() + str.length() > this.maxLength
					|| offs == 10){
				return;
			}
			super.insertString(offs, str, a);
			
		} else {
			
//			String origin = jTextField.getText();
//			origin = origin.replaceAll("[^0-9]", "");
//			StringBuilder sbOrigin = new StringBuilder(origin);
//			StringBuilder sbTemp = new StringBuilder(str);
//			
//			StringBuilder sbResult = new StringBuilder();
//			int nTemp = 0;
//			
//			if(sbOrigin.length() > offs){
//				
//				sbResult.append(sbOrigin.substring(0, offs));
//				sbResult.append(sbTemp);
//				
//				for(int i=offs;i<sbOrigin.length();i++){
//				
//					try{
//						sbOrigin.replace(i, i+1, ""+sbTemp.charAt(nTemp));
//						nTemp++;
//					} catch(IndexOutOfBoundsException e){
//						e.printStackTrace();
//					}
//					
//				}
//			}
//			
//			String temp = str.replaceAll("[^0-9]", "");
//			EntLogger.debug(temp);
//			String total = origin + temp;
//			EntLogger.debug(total);
//			if(total.length() > 8){
//				total = total.substring(0, 8);
//			}
//			
//			EntLogger.debug(total);
//			StringBuilder sb = new StringBuilder(total);
//			
//			
//			int nSize = sb.length();
//			EntLogger.debug(nSize);
//			for(int i=nSize;i<8;i++){
//				sb.append("_");
//			}
//			
//			sb = sb.insert(4, "-");
//			sb = sb.insert(7, "-");
			


			//str = sb.toString();
			
			if(getLength() + str.length() <= this.maxLength
					&& offs != 10){
				super.insertString(offs, str, a);
			}
			
		}
		

	}
}
