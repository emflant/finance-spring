import javax.swing.UIManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emflant.accounting.screen.Z00Login;
import com.emflant.accounting.screen.component.EntFrame;


public class ZExecute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try { 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String configLocation = "META-INF/spring/app-context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		Z00Login zz = (Z00Login)context.getBean("z00Login");
		
		zz.init();
		zz.loginDialog();
	}

}
