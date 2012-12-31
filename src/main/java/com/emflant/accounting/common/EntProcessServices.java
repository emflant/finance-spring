package com.emflant.accounting.common;

import org.apache.log4j.Logger;
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

	private static final Logger logger 
		= Logger.getLogger(EntProcessServices.class);
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	private ApplicationContext applicationContext;
	
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}


	/**
	 * 단일거래
	 * 하나의 거래를 한 트랜젝션으로 묶어서 처리.
	 * @param business
	 */
	public void doBusinessOpsOneTransaction(EntSingleBusiness business){
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("example-transaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
        TransactionStatus status = this.transactionManager.getTransaction(def);
        
        EntTransaction transaction = null;
        
    	try {
    		
    		transaction = business.getTransaction();
    		EntService s = this.applicationContext.getBean(transaction.getTransactionCode(), EntService.class);
			s.service(transaction);
			
			logger.info(Long.toHexString(System.currentTimeMillis())
					+ "-" + Integer.toHexString(business.hashCode())
					+ "-" + transaction.getTransactionCode()+" 거래성공");
			

    		this.transactionManager.commit(status);			//commit 처리
    		business.setComplete(true);						//거래성공
    		
    	} catch (Exception e) {
    		
			logger.info(Long.toHexString(System.currentTimeMillis())
					+ "-" + Integer.toHexString(business.hashCode())
					+ "-" + transaction.getTransactionCode()+" 거래실패");
    		logger.info(e.getCause().getMessage());
    		
    		this.transactionManager.rollback(status);		//rollback 처리
    		business.setComplete(false);					//거래실패
    		business.clearResult();							//결과값 삭제
    		business.setMessage(e.getCause().getMessage());	//에러메시지 추가
    		
    	}
    	
	}
	
	
	/**
	 * 연동거래
	 * 다수의 거래를 한 트랜젝션으로 묶어서 처리.
	 * @param business
	 */
	public void doBusinessOpsOneTransaction(EntMultiBusiness business){
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("example-transaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
        TransactionStatus status = this.transactionManager.getTransaction(def);
        
        EntTransaction transaction = null;
        
    	try {
    		
    		for(int i=0;i<business.size();i++){
    			
    			transaction = business.getTransaction(i);
    			
    			EntService s = this.applicationContext.getBean(transaction.getTransactionCode(), EntService.class);
    			
    			s.service(transaction);
    			
    			logger.info(Long.toHexString(System.currentTimeMillis())
    					+ "-" + Integer.toHexString(business.hashCode())
    					+ "-" + transaction.getTransactionCode()+" 거래성공");
    		}

    		this.transactionManager.commit(status);			//commit 처리
    		business.setComplete(true);						//거래성공
    		
    	} catch (Exception e) {
    		
			logger.info(Long.toHexString(System.currentTimeMillis())
					+ "-" + Integer.toHexString(business.hashCode())
					+ "-" + transaction.getTransactionCode()+" 거래실패");
    		logger.info(e.getCause().getMessage());
    		
    		this.transactionManager.rollback(status);		//rollback 처리
    		business.setComplete(false);					//거래실패
    		business.clearResults();						//결과값 삭제
    		business.setMessage(e.getCause().getMessage());	//에러메시지 추가
    		
    	}
    	
	}

	/**
	 * 다수거래
	 * 여러 거래를 처리할 때, 각각의 거래시에 트랜젝션을 나누어 관리.
	 * @param business
	 */
	public void doBusinessOpsEachTransaction(EntMultiBusiness business){
		
    	
        
	}
	


}
