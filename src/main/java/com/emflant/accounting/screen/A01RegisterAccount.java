package com.emflant.accounting.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emflant.accounting.main.component.EntJButton;
import com.emflant.accounting.main.component.EntJComboBox;
import com.emflant.accounting.main.component.EntJTable;
import com.emflant.accounting.main.component.EntJTextFieldForAmount;
import com.emflant.accounting.main.component.EntJTextFieldForDate;
import com.emflant.accounting.main.component.EntJTextFieldForRemarks;

@Component
public class A01RegisterAccount implements EntScreen {
	
	@Autowired
	private JFrame mainFrame;
	
	private JPanel northPanel;
	private JPanel panel1;

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
	
	//private JButton btnSearch;
	private EntJButton btnInsert;
	private EntJTable tbAccountList;
	
	public void initScreen()
	{
		
		this.northPanel = new JPanel();
		this.northPanel.setLayout(new BoxLayout(this.northPanel, BoxLayout.Y_AXIS));
		
		this.panel1 = new JPanel();
		this.panel1.setBackground(Color.WHITE);
		this.panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.centerPanel = new JPanel();
		this.centerPanel.setBackground(Color.WHITE);
		this.centerPanel.setLayout(new BorderLayout());
		
		this.southPanel = new JPanel();
		this.southPanel.setBackground(Color.WHITE);
		this.southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//this.lbUserId = new JLabel("User ID");
		//this.tfUserId = new JTextField();
		//this.tfUserId.setColumns(5);
		//this.tfUserId.setText(this.userId);
		
		//this.lbRemarks = new JLabel("���");
		this.tfRemarks = new EntJTextFieldForRemarks();
		
		//this.lbAccountType = new JLabel("��������");
		this.cbAccountType = new EntJComboBox();
		
		
		this.lbAmount = new JLabel("금액");
		this.tfAmount = new EntJTextFieldForAmount(7);
		
		this.lbCashAmount = new JLabel("현금");
		this.tfCashAmount = new EntJTextFieldForAmount(7);
		
		this.lbNewDate = new JLabel("신규일자");
		this.tfNewDate = new EntJTextFieldForDate();
		
		this.btnInsert = new EntJButton("등록");
		
		//this.btnInsert.addActionListener(new InsertButtonListener());


		//this.btnInsert.setEnabled(false);
		//this.btnUpdate.setEnabled(false);
		//this.btnDelete.setEnabled(false);

		

		this.tbAccountList = new EntJTable();
		//this.tbAccountList.getSelectionModel().addListSelectionListener(new TableSelectionListener());


		this.tbAccountList.entAddTableHeader("account_type_nm", "", JLabel.CENTER, 50);
		this.tbAccountList.entAddTableHeader("remarks", "", JLabel.LEFT, 300);
		this.tbAccountList.entAddTableHeader("format_new_date", "", JLabel.CENTER, 80);
		this.tbAccountList.entAddTableHeader("account_status_nm", "", JLabel.CENTER, 50);
		this.tbAccountList.entAddTableHeader("format_balance", "", JLabel.RIGHT, 100);
		
		
		
		//this.panel1.add(lbUserId);
		//this.panel1.add(tfUserId);
		//this.panel1.add(lbAccountType);
		



		//this.northPanel.add(panel1);

		this.southPanel.add(cbAccountType);
		//this.southPanel.add(lbRemarks);
		//this.southPanel.add(tfRemarks);
		tfRemarks.addPanel(this.southPanel);
		this.southPanel.add(lbNewDate);
		//this.southPanel.add(tfNewDate);
		tfNewDate.addPanel(this.southPanel);
		this.southPanel.add(lbAmount);
		//this.southPanel.add(tfAmount);
		tfAmount.addPanel(this.southPanel);
		this.southPanel.add(lbCashAmount);
		tfCashAmount.addPanel(this.southPanel);
		//this.southPanel.add(btnSearch);
		//this.southPanel.add(btnInsert);
		btnInsert.addPanel(this.southPanel);
		//this.southPanel.add(btnUpdate);
		//this.southPanel.add(btnDelete);
		this.centerPanel.add(BorderLayout.CENTER, new JScrollPane(tbAccountList));
		
		//this.frame.getContentPane().add(BorderLayout.NORTH, this.northPanel);
		this.mainFrame.getContentPane().add(BorderLayout.SOUTH, this.southPanel);
		this.mainFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);

		
		
	}
	
	public String display() {
		// TODO Auto-generated method stub
		return "A01RegisterAccount screen.";
	}

}
