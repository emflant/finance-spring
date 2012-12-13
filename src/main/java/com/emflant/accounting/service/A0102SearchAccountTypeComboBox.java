package com.emflant.accounting.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.emflant.accounting.common.EntTransaction;

@Scope("prototype")
@Component("A0102")
public class A0102SearchAccountTypeComboBox implements EntService {
	
	private static final Logger logger 
		= Logger.getLogger(A0102SearchAccountTypeComboBox.class);
	
	@Autowired
	private SqlSession session;

	

	public void service(EntTransaction transaction) {
		List result = this.session.selectList("A01Mapper.select02");
		logger.info(result);
		transaction.addResult(result);
	}
}
