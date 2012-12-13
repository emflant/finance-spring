package com.emflant.accounting.screen.component;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class EntDialog {
	private EntMessageType messageType;
	private String message;
	
	public enum EntMessageType{
		INFORMATION,	//서버에서 내려주는 정상적인 메시지유형
		WARNING,		//화면에서 체크시에 사용하는 메시지유형
		ERROR			//서버에서 에러날시 사용하는 메시지유형
	}
	
	public EntDialog(){}
	
	public EntDialog(EntMessageType messageType, String message){
		this.messageType = messageType;
		this.message = message;
	}
	
	public EntDialog(Exception e){
		this.messageType = EntMessageType.ERROR;
		this.message = e.getMessage();
	}
	

	public EntMessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(EntMessageType messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public void showMessageDialog(JFrame frame){
		
		String strTitle = null;
		int nMessageType = 0;
		if(messageType == EntMessageType.INFORMATION){
			strTitle = "정보";
			nMessageType = JOptionPane.INFORMATION_MESSAGE;
		} 
		else if(messageType == EntMessageType.ERROR){
			strTitle = "에러";
			nMessageType = JOptionPane.ERROR_MESSAGE;
		} 
		else if(messageType == EntMessageType.WARNING){
			strTitle = "확인";
			nMessageType = JOptionPane.WARNING_MESSAGE;
		}
		
		StringBuffer sb = new StringBuffer(1024);
		sb.append("<html><p width=300>");
		sb.append(this.message);
		sb.append("</p></html>");
		
		JOptionPane.showMessageDialog(frame, sb.toString()
				, strTitle, nMessageType);
		


	}
	
	public int showConfirmDialog(JFrame frame){
		
		StringBuffer sb = new StringBuffer(1024);
		sb.append("<html><p width=300>");
		sb.append(this.message);
		sb.append("</p></html>");
		
		return JOptionPane.showConfirmDialog(frame, sb.toString()
				, "확인", JOptionPane.OK_CANCEL_OPTION);
	}
	
	
	public String showInputDialog(JFrame frame){
		
		StringBuffer sb = new StringBuffer(1024);
		sb.append("<html><p width=300>");
		sb.append(this.message);
		sb.append("</p></html>");
		
		return JOptionPane.showInputDialog(frame, sb.toString()
				, "접속", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String showInputDialog2(JFrame frame){
		
		StringBuffer sb = new StringBuffer(1024);
		sb.append("<html><p width=300>");
		sb.append(this.message);
		sb.append("</p></html>");
		
		return JOptionPane.showInputDialog(frame, sb.toString()
				, "접속", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void show_old(JFrame frame){
		
		String strTitle = null;
		if(messageType == EntMessageType.INFORMATION){
			strTitle = "정보";
		} else if(messageType == EntMessageType.ERROR){
			strTitle = "에러";
		} else if(messageType == EntMessageType.WARNING){
			strTitle = "확인";
		}
		
		JDialog dialog = new JDialog(frame,strTitle,true);
		dialog.setSize(400,100);
		dialog.setLayout(new FlowLayout());
		dialog.setLocation(frame.getX() + 150, frame.getY() + 200);
		dialog.setResizable(false);
		JLabel lbMessage = new JLabel(this.message);
		
		dialog.add(lbMessage);
		dialog.setVisible(true);
	}
}
