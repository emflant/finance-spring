package com.emflant.accounting.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntMultiBusiness {
	
	private List<EntTransaction> transactions;
	
	private boolean complete;
	private String message;
	
	public EntMultiBusiness(){
		this.transactions = new ArrayList<EntTransaction>();
	}
	
	
	public void addTransaction(EntTransaction transaction){
		this.transactions.add(transaction);
	}
	
	public void addTransaction(String transactionCode){
		addTransaction(new EntTransaction(transactionCode));
	}
	public void addTransaction(String transactionCode, HashMap<String, Object> input){
		addTransaction(new EntTransaction(transactionCode, input));
	}
	
	public EntTransaction getTransaction(int index){
		return this.transactions.get(index);
	}
	
	public int size(){
		return this.transactions.size();
	}



	
	public void clearResults(){
		
		for(int i=0;i<this.transactions.size();i++){
			EntTransaction transaction = this.transactions.get(i);
			transaction.clearResult();
		}
		
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
