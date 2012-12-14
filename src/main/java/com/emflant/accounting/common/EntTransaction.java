package com.emflant.accounting.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntTransaction {
	
	
	private List<Object> results;
	private HashMap<String, Object> input;
	private String transactionCode;
	
	
	public EntTransaction(){
		this(null);
	}
	
	public EntTransaction(String transactionCode){
		this(transactionCode, null);
	}
	public EntTransaction(String transactionCode, HashMap<String, Object> input){
		this.transactionCode = transactionCode;
		this.input = input;
		this.results = new ArrayList<Object>();
	}
	
	public HashMap<String, Object> getInput(){
		return input;
	}
	
	public void addResult(Object result){
		this.results.add(result);
	}
	
	public Object getResult(int index){
		return this.results.get(index);
	}


	public String getTransactionCode() {
		return transactionCode;
	}


	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	
	public void clearResult(){
		this.results.clear();
	}

}
