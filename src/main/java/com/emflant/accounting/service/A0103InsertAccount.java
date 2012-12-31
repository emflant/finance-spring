package com.emflant.accounting.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.emflant.accounting.common.EntBusiness;
import com.emflant.accounting.common.EntTransaction;


/**
 * 계좌신규등록
 * @author home
 *
 */

@Scope("prototype")
@Component("A0103")
public class A0103InsertAccount implements EntService {
	
	private static final Logger logger 
			= Logger.getLogger(A0103InsertAccount.class);

	@Autowired
	private SqlSession session;

	public void service(EntTransaction transaction) {

		//거래내역 등록
		logger.info("거래내역 등록");
		
		//계좌원장 등록
		logger.info("계좌원장 등록");
		
		//회계처리
		logger.info("회계처리");
	}

}
