package com.emflant.accounting.common;

import java.util.HashMap;

public class EntSingleBusiness {
	
	private EntTransaction transaction;
	
	private boolean complete;
	private String message;
	
	public EntSingleBusiness(String transactionCode){
		setTransaction(new EntTransaction(transactionCode));
	}
	
	public EntSingleBusiness(String transactionCode, HashMap<String, Object> input){
		setTransaction(new EntTransaction(transactionCode, input));
	}
	
	public void setTransaction(EntTransaction transaction){
		this.transaction = transaction;
	}
	
	
	public EntTransaction getTransaction(){
		return this.transaction;
	}
	
	public Object getResult(int index){
		return this.transaction.getResult(index);
	}
	
	public int size(){
		return (this.transaction == null) ? 0 : 1;
	}
	
	public void clearResult(){
		transaction.clearResult();
	}


	public boolean isComplete() {
		return complete;
	}


	public void setComplete(boolean complete) {
		this.complete = complete;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
}
