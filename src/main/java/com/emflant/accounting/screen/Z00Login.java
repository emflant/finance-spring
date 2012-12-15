package com.emflant.accounting.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.emflant.accounting.common.EntCommon;
import com.emflant.accounting.screen.component.EntDialog;
import com.emflant.accounting.screen.component.EntFrame;
import com.emflant.accounting.screen.component.EntScreen;
import com.emflant.accounting.screen.component.EntDialog.EntMessageType;

@Component
public class Z00Login implements ApplicationContextAware {

	private static final Logger logger = Logger.getLogger(Z00Login.class);
	private Map<String, EntScreen> screens;
	private String currentScreen;
	
	@Autowired @Qualifier("mainFrame")
	private EntFrame frame;
	
	@Autowired
	private PooledDataSource dataSource;
	
	@Autowired
	private EntCommon common;
	
	public void init(){
		
		JMenuBar mb = new JMenuBar();
		JMenu screen = new JMenu("Account");
		
		JMenuItem menuItemA01 = new JMenuItem("[A01] 계좌등록");
		JMenuItem menuItemA02 = new JMenuItem("[A02] 계좌내역조회");
		
		menuItemA01.addActionListener(new MenuItemListener("a01RegisterAccount"));
		menuItemA02.addActionListener(new MenuItemListener("a02InquiryAccountDetail"));

		screen.add(menuItemA01);
		screen.add(menuItemA02);

		mb.add(screen);
		
		this.frame.setJMenuBar(mb);
		this.frame.addWindowListener(new FrameWindowListener());
		this.frame.setSize(800, 600);
		this.frame.setVisible(true);
		
	}
	
	class MenuItemListener implements ActionListener {
		
		private String screen;
		
		
		public MenuItemListener(String screen){
			this.screen = screen;
		}
		
		public void actionPerformed(ActionEvent arg0) {

			if(currentScreen != null && currentScreen.equals(this.screen)){
				logger.info("같은 화면 skip.");
				return;
			} else {
				logger.info("화면 : "+this.screen);
			}
			
			currentScreen = this.screen;
			
			EntScreen entScreen = screens.get(this.screen);

			frame.getContentPane().removeAll();
			logger.info(entScreen.display());
			entScreen.initScreen();
			frame.setVisible(true);
			frame.getContentPane().repaint();
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

	/**
	 * ApplicationContext 객체를 얻고 싶을 때 ApplicationContextAware 인터페이스를
	 * 구현해서 멤버변수로 set 해주기만 하면 된다.
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.screens = applicationContext.getBeansOfType(EntScreen.class);
	}
	
	
	public void loginDialog(){
		EntDialog message = new EntDialog(EntMessageType.INFORMATION, "로그인정보");
		String ip = message.showInputDialog(frame);
		
		EntDialog messageResult = null;
		
		//finance 라고 입력하면 real DB 로 접속한다.
		if(ip != null && ip.equals("finance")){
			this.dataSource.setUrl("jdbc:mysql://localhost/finance");
			logger.info("운영 DB 접속.");
			messageResult = new EntDialog(EntMessageType.INFORMATION, "운영 DB 접속.");
			this.frame.setTitle("[Real]");
		} 
		//그 외의 것들은 테스트DB로 접속한다.
		else {
			this.dataSource.setUrl("jdbc:mysql://localhost/finance_test");
			logger.info("테스트 DB 접속.");
			messageResult = new EntDialog(EntMessageType.INFORMATION, "테스트 DB 접속.");
			this.frame.setTitle("[Test]");
		}
		
		messageResult.showMessageDialog(frame);
		
		
		//공통정보 셋팅.
		this.common.setUser("emflant");
	}

}
