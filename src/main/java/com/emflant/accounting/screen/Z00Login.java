package com.emflant.accounting.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Z00Login {
	
	private static final Logger logger = Logger.getLogger(Z00Login.class);
	
	@Autowired
	private JFrame mainFrame;
	
	@Autowired @Qualifier("a01RegisterAccount")
	private EntScreen a01;
	@Autowired @Qualifier("a02InquiryAccountDetail")
	private EntScreen a02;
	
	
	public void init(){
		//logger.info("기본화면 셋팅."+a01);
		//this.frame = new JFrame();
		
		JMenuBar mb = new JMenuBar();
		JMenu screen = new JMenu("Account");
		
		JMenuItem menuItemA01 = new JMenuItem("[A01] 계좌등록");
		JMenuItem menuItemA02 = new JMenuItem("[A02] 계좌내역조회");
		
		menuItemA01.addActionListener(new MenuItemListener(this.a01));
		menuItemA02.addActionListener(new MenuItemListener(this.a02));

		screen.add(menuItemA01);
		screen.add(menuItemA02);

		mb.add(screen);
		
		this.mainFrame.setJMenuBar(mb);
		this.mainFrame.addWindowListener(new FrameWindowListener());
		this.mainFrame.setSize(800, 600);
		this.mainFrame.setVisible(true);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	class MenuItemListener implements ActionListener {
		
		private EntScreen screen;
		
		public MenuItemListener(EntScreen screen){
			this.screen = screen;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			logger.info(screen.display());
			screen.initScreen();
		}
		
	}
	
	
	class FrameWindowListener implements WindowListener {

		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			arg0.getWindow().setVisible(false);
			arg0.getWindow().dispose();
			System.exit(0);
		}

		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

}
