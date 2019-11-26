package com.marlabs.service;

import org.apache.commons.lang.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.marlabs.exception.BusinessException;

import lombok.val;
import lombok.var;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

@Log4j2
public class SearchServiceImpl implements SearchService {

//	private static final Logger logger = LogManager.getLogger(SearchServiceImpl.class);

	Scanner input = new Scanner(System.in);
	public static final String CANNOT_BE_NULL_EMPTY = "Input keyword cannot be null/empty.";
	public static final String FILE_READING_EXCEPTION = "Exception while reading the file.";

	public long searchKeyword(String keyword, String fileName) throws BusinessException {
		long count = 0;
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		try ( Stream<String> stream = Files.lines(Paths.get("D:\\textFile\\" + fileName))) {
			log.debug("debug");
			log.error("logger Error");
			log.info("logger info"); 
			log.fatal("fatal h");
			log.trace("trace h");
			//Counting keyword feq
			count = stream.parallel().filter(line -> line.matches("(.*)" + keyword + "(.*)")).count();

			if (count > 0) {
				System.out.println(keyword + " is present and frequency is " + count + " .Time taken "
						+ stopWatch.getTime() + "ms.");
			} else {
				System.out.print(keyword + " is not present");
				System.out.print(". Time taken " + stopWatch.getTime() + " ms.");
			}
		} catch (IOException e) { 
			log.error("{}", e);
			throw new BusinessException("100",CANNOT_BE_NULL_EMPTY);
			
		}
		log.debug("{}", () -> openDir());
		stopWatch.stop();
		return count;
	}

	@Override
	public Map<Integer, String> openDir() {
		int countTotalBook = 0;
		var hashMap = new HashMap<Integer, String>();
		File directory = new File("D:\\textFile");
		int fileCount = directory.list().length;
		System.out.println("Total file in directory :" + fileCount);
		if (fileCount > 0) {

			for (int i = 0; i < fileCount; i++) {

				hashMap.put(countTotalBook++, directory.list()[i]);
			}
			for (val entry : hashMap.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		}
		return hashMap;
	}
}
