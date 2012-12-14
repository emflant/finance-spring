package com.emflant.accounting.service;

import com.emflant.accounting.common.EntTransaction;

public interface EntService {
	void service(EntTransaction transaction);
}
