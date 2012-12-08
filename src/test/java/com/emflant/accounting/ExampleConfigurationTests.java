package com.emflant.accounting;

import static org.junit.Assert.assertNotNull;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleConfigurationTests {
	
	Logger logger = Logger.getLogger(ExampleConfigurationTests.class);

	@Test
	public void testSimpleProperties() throws Exception {
		
		String configLocation = "META-INF/spring/screen-context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		//A01RegisterAccount a01 = (A01RegisterAccount)context.getBean("a01RegisterAccount");

		//assertNotNull(a01);
		//logger.info(a01);
	}
	
}
