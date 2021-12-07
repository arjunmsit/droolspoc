package com.united.drools.service;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.drools.practice.bo.Sale;
import com.drools.practice.service.DiscountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FileProcessor {

	@Autowired
	private DiscountService discountService;

	@Value("${app.directory.output}")
	private String outputDirectory;

	@Value("${app.directory.input}")
	private String inputDirectory;

	@Value("${app.directory.error}")
	private String errorDirectory;

	private static final String HEADER_FILE_NAME = "file_name";

	private static final Logger logger = LoggerFactory.getLogger(FileProcessor.class);

	public void process(Message<String> msg) {

		String fileName = (String) msg.getHeaders().get(HEADER_FILE_NAME);

		logger.info("New file has been received. File Name : "+fileName);

		String content = msg.getPayload();

		try {

			Sale sale = new ObjectMapper().readValue(content, Sale.class);

			this.discountService.applyDiscount(sale);

			logger.info("Rule has executed successfully against the input.");

			removeFileFromInputDirectory(fileName);

			writeResponseToOutputDirectory(sale, fileName);

			logger.info("Rule output has sent to output file successfully.");

		} catch (JsonProcessingException e) {

			logger.error("Invalid JSON input received in the input file.");

			handleError(fileName, content);

		} catch (IOException e) {

			logger.error("Error while deleting/creating a file to the specified directory. File Name: "+fileName);

			handleError(fileName, content);
		}  
	}

	private void handleError(String fileName, String content) {

		try {

			removeFileFromInputDirectory(fileName);
			moveFileToErrorDirectory(content, fileName);

		} catch (IOException e) {

			logger.error("Error while handling the exception for the input file :"+fileName);
		}
	}

	private void removeFileFromInputDirectory(String fileName) {

		File myObj = new File(inputDirectory + fileName); 

		myObj.delete();
	}

	private void moveFileToErrorDirectory( String content, String fileName ) throws IOException {

		File outputFile = new File(errorDirectory+fileName);

		outputFile.createNewFile();

		FileWriter myWriter = new FileWriter(errorDirectory+fileName);

		myWriter.write(content);

		myWriter.close();

	}

	private void writeResponseToOutputDirectory( Sale sale, String fileName ) throws IOException {

		ObjectMapper Obj = new ObjectMapper();  

		String output = Obj.writeValueAsString(sale); 

		File outputFile = new File(outputDirectory+fileName);

		outputFile.createNewFile();

		FileWriter myWriter = new FileWriter(outputDirectory+fileName);

		myWriter.write(output);

		myWriter.close();

	}
}
