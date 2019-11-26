package com.marlabs;

import com.marlabs.exception.BusinessException;
import com.marlabs.service.SearchService;
import com.marlabs.service.SearchServiceImpl;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	private static Scanner input;

	public static void main(String[] args) throws BusinessException, FileNotFoundException {
		String fileName = null;
		input = new Scanner(System.in);
		SearchService service = new SearchServiceImpl();
		HashMap<Integer, String> dirDetails = (HashMap<Integer, String>) service.openDir();
		System.out.println("enter the key to select book");
		try {
			fileName = dirDetails.get(input.nextInt());
		} catch (Exception e) {
			System.err.print("Opps! input type mismatch");
		}
		if (fileName != null) {
			System.out.println("Search in file :" + fileName);
			System.out.println("Enter the keyword to search: ");
			String keyword = input.next();

			service.searchKeyword(keyword, fileName);
		} else {
			System.err.println("Please enter right key");
		}
	}
}
