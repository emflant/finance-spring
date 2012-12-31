package com.emflant.accounting.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emflant.accounting.screen.component.EntFrame;
import com.emflant.accounting.screen.component.EntJComboBox;
import com.emflant.accounting.screen.component.EntJTable;
import com.emflant.accounting.screen.component.EntJTextFieldForAmount;
import com.emflant.accounting.screen.component.EntJTextFieldForDate;
import com.emflant.accounting.screen.component.EntScreen;


@Component
public class A02InquiryAccountDetail implements EntScreen {
	
	private static final Logger logger = Logger.getLogger(A02InquiryAccountDetail.class);

	@Autowired
	private EntFrame mainFrame;



	private JPanel centerPanel;
	private JPanel northPanel;
	private JPanel southPanel;
	
	private JPanel panel1;
	private JPanel panel2;
	
	private JLabel lbAccount;
	private EntJComboBox cbAccount;
	
	private JLabel lbBalance;
	private EntJTextFieldForAmount tfBalance;
	
	private JLabel lbTradeDate;
	private EntJTextFieldForDate tfTradeDate;
	
	private EntJTable tbAccountDetail;
	
	
	public A02InquiryAccountDetail(){
		
		this.northPanel = new JPanel();
		this.northPanel.setBackground(Color.WHITE);
		this.northPanel.setLayout(new BoxLayout(this.northPanel, BoxLayout.Y_AXIS));
		
		this.panel1	= new JPanel();
		this.panel1.setBackground(Color.WHITE);
		this.panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.panel2	= new JPanel();
		this.panel2.setBackground(Color.WHITE);
		this.panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.centerPanel = new JPanel();
		this.centerPanel.setBackground(Color.WHITE);
		this.centerPanel.setLayout(new BorderLayout());
		
		this.southPanel = new JPanel();
		this.southPanel.setBackground(Color.WHITE);
		this.southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		this.lbAccount = new JLabel("계좌");
		this.cbAccount = new EntJComboBox();
		//this.cbAccount.addActionListener(new CbAccountChangeListener());
		
		this.lbBalance = new JLabel("       잔액");
		this.tfBalance = new EntJTextFieldForAmount(10);
		this.tfBalance.setEnabled(false);
		
		this.lbTradeDate = new JLabel("       기산일자");
		this.tfTradeDate = new EntJTextFieldForDate(7);
				
		this.tbAccountDetail = new EntJTable();
		
		this.tbAccountDetail.entAddTableHeader("trade_sequence", "#", JLabel.CENTER, 50);
		this.tbAccountDetail.entAddTableHeader("format_reckon_date", "거래일자", JLabel.CENTER, 100);
		this.tbAccountDetail.entAddTableHeader("trade_type_name", "종류", JLabel.CENTER, 50);
		this.tbAccountDetail.entAddTableHeader("cancel_type_name", "취소", JLabel.CENTER, 50);
		this.tbAccountDetail.entAddTableHeader("format_trade_amount", "거래금액", JLabel.RIGHT, 120);
		this.tbAccountDetail.entAddTableHeader("format_after_reckon_balance", "잔액", JLabel.RIGHT, 120);
		this.tbAccountDetail.entAddTableHeader("remarks", "적요", JLabel.LEFT, 260);
		
		this.panel1.add(lbAccount);
		this.cbAccount.addPanel(panel1);
		this.panel1.add(lbBalance);
		tfBalance.addPanel(this.panel1);
		this.panel1.add(lbTradeDate);
		tfTradeDate.addPanel(this.panel1);
		
		this.northPanel.add(panel1);
		this.southPanel.add(panel2);
		this.centerPanel.add(BorderLayout.CENTER, new JScrollPane(tbAccountDetail));

	}
	
	
	public String display() {
		return "A02InquiryAccountDetail screen.";
	}

	public void initScreen()
	{
		this.mainFrame.getContentPane().add(BorderLayout.NORTH, this.northPanel);
		this.mainFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}
	

}
