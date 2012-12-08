package com.emflant.accounting.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emflant.accounting.screen.component.EntJButton;
import com.emflant.accounting.screen.component.EntJComboBox;
import com.emflant.accounting.screen.component.EntJTable;
import com.emflant.accounting.screen.component.EntJTextFieldForAmount;
import com.emflant.accounting.screen.component.EntJTextFieldForDate;
import com.emflant.accounting.screen.component.EntJTextFieldForRemarks;


@Component
public class A02InquiryAccountDetail implements EntScreen {
	
	private static final Logger logger = Logger.getLogger(A02InquiryAccountDetail.class);

	@Autowired
	private JFrame mainFrame;



	private JPanel centerPanel;
	private JPanel southPanel;
	private EntJTextFieldForRemarks tfRemarks;
	private JComboBox cbAccountType;
	private JLabel lbAmount;
	private EntJTextFieldForAmount tfAmount;
	private JLabel lbCashAmount;
	private EntJTextFieldForAmount tfCashAmount;
	
	private JLabel lbNewDate;
	private EntJTextFieldForDate tfNewDate;
	
	private EntJButton btnInsert;
	private EntJTable tbAccountList;
	
	
	public A02InquiryAccountDetail(){
		//logger.info("session : "+session);
		//HashMap hm = (HashMap)session.selectOne("SqlSampleMapper.selectSampleMsSql", new HashMap<String, Object>());
		//logger.info("result : "+this.tbAccountList);
		//logger.info("call initScreen : ");
		
		

		//this.tfRemarks = new EntJTextFieldForRemarks();
		this.cbAccountType = new JComboBox();
		this.lbAmount = new JLabel("금액");
		//this.tfAmount = new EntJTextFieldForAmount(7);
		this.lbCashAmount = new JLabel("현금");
		//this.tfCashAmount = new EntJTextFieldForAmount(7);
		this.lbNewDate = new JLabel("신규일자");
		//this.tfNewDate = new EntJTextFieldForDate();
		//this.btnInsert = new EntJButton("취소");
		
		this.tbAccountList = new EntJTable();
		this.tbAccountList.entAddTableHeader("account_type_nm", "계좌유형", JLabel.CENTER, 50);
		this.tbAccountList.entAddTableHeader("remarks", "적요", JLabel.LEFT, 300);
		this.tbAccountList.entAddTableHeader("format_new_date", "신규일자", JLabel.CENTER, 80);
		this.tbAccountList.entAddTableHeader("account_status_nm", "상태", JLabel.CENTER, 50);
		this.tbAccountList.entAddTableHeader("format_balance", "잔액", JLabel.RIGHT, 100);
		
		this.centerPanel = new JPanel();
		this.centerPanel.setBackground(Color.WHITE);
		this.centerPanel.setLayout(new BorderLayout());
		
		this.southPanel = new JPanel();
		this.southPanel.setBackground(Color.WHITE);
		//this.southPanel.setSize(800, 300);
		this.southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//this.southPanel.add(cbAccountType);
		//tfRemarks.addPanel(this.southPanel);
		this.southPanel.add(lbNewDate);
		//tfNewDate.addPanel(this.southPanel);
		//this.southPanel.add(lbAmount);
		//tfAmount.addPanel(this.southPanel);
		
		///this.southPanel.add(lbCashAmount);
		//tfCashAmount.addPanel(this.southPanel);
		//btnInsert.addPanel();
		
		//this.southPanel.add(btnInsert);
		
		this.centerPanel.add(BorderLayout.CENTER, new JScrollPane(tbAccountList));
		
	}
	
	
	public String display() {
		// TODO Auto-generated method stub
		return "A02InquiryAccountDetail screen.";
	}

	public void initScreen()
	{
		this.mainFrame.getContentPane().add(BorderLayout.SOUTH, this.southPanel);
		this.mainFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}
	

}
