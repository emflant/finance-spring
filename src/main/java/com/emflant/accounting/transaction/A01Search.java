package com.emflant.accounting.transaction;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A01Search {
	
	private static final Logger logger = Logger.getLogger(A01Search.class);
	
	@Autowired
	private SqlSession session;
	
	public List getAccountsByUserId(String userId){
		
		HashMap input = new HashMap();
		input.put("user_id", userId);
		
		List result = session.selectList("A01Mapper.select01", input);
		
		logger.info(result);
		
		return result;
	}

}
