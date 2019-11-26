package com.marlabs.service;

import java.util.Map;

import com.marlabs.exception.BusinessException;

public interface SearchService {
	public Map<Integer, String> openDir();
	long searchKeyword(String keyword, String fileName) throws BusinessException;
}
