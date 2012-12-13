package com.emflant.accounting.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntBusiness {
	
	
	private List<EntTransaction> transactions;
	
	public EntBusiness(){
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

}
