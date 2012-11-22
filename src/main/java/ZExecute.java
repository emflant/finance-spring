import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emflant.accounting.screen.Z00Login;


public class ZExecute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLocation = "META-INF/spring/app-context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		Z00Login zz = (Z00Login)context.getBean("z00Login");
		zz.init();
	}

}
