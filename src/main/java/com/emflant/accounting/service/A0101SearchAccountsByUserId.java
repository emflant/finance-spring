package com.emflant.accounting.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.emflant.accounting.common.EntCommon;
import com.emflant.accounting.common.EntTransaction;

@Scope("prototype")
@Component("A0101")
public class A0101SearchAccountsByUserId implements EntService {
	
	private static final Logger logger 
			= Logger.getLogger(A0101SearchAccountsByUserId.class);
	
	@Autowired
	private SqlSession session;
	@Autowired
	private EntCommon common;
	
	public void service(EntTransaction transaction) {
		List result = session.selectList("A01Mapper.select01"
				, this.common.getUser());
		transaction.addResult(result);
	}

	
}
