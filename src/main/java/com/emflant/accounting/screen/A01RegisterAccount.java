package com.emflant.accounting.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emflant.accounting.common.EntProcessServices;
import com.emflant.accounting.common.EntSingleBusiness;
import com.emflant.accounting.screen.component.EntFrame;
import com.emflant.accounting.screen.component.EntJButton;
import com.emflant.accounting.screen.component.EntJComboBox;
import com.emflant.accounting.screen.component.EntJTable;
import com.emflant.accounting.screen.component.EntJTextFieldForAmount;
import com.emflant.accounting.screen.component.EntJTextFieldForDate;
import com.emflant.accounting.screen.component.EntJTextFieldForRemarks;
import com.emflant.accounting.screen.component.EntScreen;

@Component
public class A01RegisterAccount implements EntScreen {
	
	private static final Logger logger = Logger.getLogger(A01RegisterAccount.class);
	
	@Autowired
	private EntFrame mainFrame;
	@Autowired
	private EntProcessServices processServices;

	private JPanel centerPanel;
	private JPanel southPanel;
	private EntJTextFieldForRemarks tfRemarks;
	private EntJComboBox cbAccountType;
	private JLabel lbAmount;
	private EntJTextFieldForAmount tfAmount;
	private JLabel lbCashAmount;
	private EntJTextFieldForAmount tfCashAmount;
	
	private JLabel lbNewDate;
	private EntJTextFieldForDate tfNewDate;
	
	private EntJButton btnInsert;
	private EntJTable tbAccountList;
	
	public A01RegisterAccount(){
		
		this.tfRemarks = new EntJTextFieldForRemarks();
		this.cbAccountType = new EntJComboBox();
		this.lbAmount = new JLabel("금액");
		this.tfAmount = new EntJTextFieldForAmount(7);
		this.lbCashAmount = new JLabel("현금");
		this.tfCashAmount = new EntJTextFieldForAmount(7);
		this.lbNewDate = new JLabel("신규일자");
		this.tfNewDate = new EntJTextFieldForDate();
		this.btnInsert = new EntJButton("등록");
		this.btnInsert.addActionListener(new btnInsertListener());
		
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
		this.southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		this.cbAccountType.addPanel(this.southPanel);
		tfRemarks.addPanel(this.southPanel);
		this.southPanel.add(lbNewDate);
		tfNewDate.addPanel(this.southPanel);
		this.southPanel.add(lbAmount);
		tfAmount.addPanel(this.southPanel);
		
		this.southPanel.add(lbCashAmount);
		tfCashAmount.addPanel(this.southPanel);
		btnInsert.addPanel(this.southPanel);
		
		this.centerPanel.add(BorderLayout.CENTER, new JScrollPane(tbAccountList));
		
	}

	
	public void initScreen()
	{
		this.mainFrame.getContentPane().add(BorderLayout.SOUTH, this.southPanel);
		this.mainFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		setComboBox();
		search();
	}
	
	public void setComboBox(){
		EntSingleBusiness business = new EntSingleBusiness("A0102");
		this.mainFrame.doBusinessOpsOneTransaction(business);
		
		List comboResult = (List)business.getResult(0);
		this.cbAccountType.setList(comboResult);
	}
	
	public void search(){
		
		EntSingleBusiness business = new EntSingleBusiness("A0101");
		this.mainFrame.doBusinessOpsOneTransaction(business);

		if(business.isComplete()){
			List result = (List)business.getResult(0);
			this.tbAccountList.entSetTableModel(result);
		}

	}
	
	public String display() {
		return "A01RegisterAccount screen.";
	}

	
	class btnInsertListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			EntSingleBusiness business = new EntSingleBusiness("A0103");
			mainFrame.doBusinessOpsOneTransaction(business);
		}
		
	}
	
}
