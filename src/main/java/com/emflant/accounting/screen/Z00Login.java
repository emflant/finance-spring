package com.emflant.accounting.screen;

import java.awt.Container;
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
	
	@Autowired @Qualifier("mainFrame")
	private JFrame frame;
	
	@Autowired @Qualifier("a01RegisterAccount")
	private EntScreen a01;
	@Autowired @Qualifier("a02InquiryAccountDetail")
	private EntScreen a02;
	
	
	public void init(){
		//logger.info("기본화면 셋팅."+a01);
		//this.frame = new JFrame();
		logger.info("skdlfsdjkl");
		try { 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			logger.info(UIManager.getSystemLookAndFeelClassName());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JMenuBar mb = new JMenuBar();
		JMenu screen = new JMenu("Account");
		
		JMenuItem menuItemA01 = new JMenuItem("[A01] 계좌등록");
		JMenuItem menuItemA02 = new JMenuItem("[A02] 계좌내역조회");
		
		menuItemA01.addActionListener(new MenuItemListener(this.a01));
		menuItemA02.addActionListener(new MenuItemListener(this.a02));

		screen.add(menuItemA01);
		screen.add(menuItemA02);

		mb.add(screen);
		
		this.frame.setJMenuBar(mb);
		this.frame.addWindowListener(new FrameWindowListener());
		this.frame.setSize(800, 600);
		this.frame.setVisible(true);
		
	}
	
	class MenuItemListener implements ActionListener {
		
		private EntScreen screen;
		
		public MenuItemListener(EntScreen screen){
			this.screen = screen;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			
			frame.getContentPane().removeAll();
			
			//logger.info("==================");
			logger.info(screen.display());
			screen.initScreen();
		}
		
	}
	
	
	class FrameWindowListener implements WindowListener {

		public void windowActivated(WindowEvent arg0) {
			
		}

		public void windowClosed(WindowEvent arg0) {
			
		}

		public void windowClosing(WindowEvent arg0) {
			logger.info("Exit Program.");
			arg0.getWindow().setVisible(false);
			arg0.getWindow().dispose();
			System.exit(0);
		}

		public void windowDeactivated(WindowEvent arg0) {
			
		}

		public void windowDeiconified(WindowEvent arg0) {
			
		}

		public void windowIconified(WindowEvent arg0) {
			
		}

		public void windowOpened(WindowEvent arg0) {
			
		}
		
	}
	

}
