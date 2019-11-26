package com.marlabs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.marlabs.exception.BusinessException;

public class SearchServiceImplTest {
	@Spy
	SearchServiceImpl searchServiceImpl;

	@BeforeEach
	void mockitoInit() {
		MockitoAnnotations.initMocks(this);
	}

	@ParameterizedTest
	@CsvSource(value = { "java, input.txt" }) // book will fail
	void testSearchKeyword(String keyword, String fileName) throws BusinessException {
		assertEquals(4, searchServiceImpl.searchKeyword(keyword, fileName));
	}

	@Test
	void testBusinessException() {
		assertThrows(BusinessException.class, () -> {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the book name");
			searchServiceImpl.searchKeyword("asad", sc.next());
		});
	}
}
