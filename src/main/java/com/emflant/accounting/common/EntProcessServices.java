package com.emflant.accounting.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.emflant.accounting.service.EntService;


@Component
public class EntProcessServices implements ApplicationContextAware {

	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	private ApplicationContext applicationContext;
	
	
	@Deprecated
	public void doBusinessOpsEachTransaction(EntBusiness business){
		
    	
        
	}
	
	
	
	public void doBusinessOpsOneTransaction(EntBusiness business){
		

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("example-transaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
        TransactionStatus status = this.transactionManager.getTransaction(def);
        
    	try {
    		
    		for(int i=0;i<business.size();i++){
    			
    			EntTransaction transaction = business.getTransaction(i);
    			
    			EntService s = this.applicationContext.getBean(transaction.getTransactionCode(), EntService.class);
    			
    			s.service(transaction);
    		}

    		this.transactionManager.commit(status);
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		this.transactionManager.rollback(status);
    	}

	}



	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
}
