package com.drools.practice.adapter;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.transformer.FileToStringTransformer;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public class FileAdapter {
	
	@Value("${app.directory.input}")
	private String inputDirectory;

	@Bean
	@InboundChannelAdapter(value = "fileInputChannel", poller = @Poller(fixedDelay = "10000"))
	public MessageSource<File> fileReadingMessageSource() {

		CompositeFileListFilter<File> filters = new CompositeFileListFilter<>();

		filters.addFilter(new SimplePatternFileListFilter("*.txt"));

		FileReadingMessageSource source = new FileReadingMessageSource();
		source.setAutoCreateDirectory(true);
		source.setDirectory(new File(inputDirectory));
		source.setFilter(filters);
		
		return source;
	}

	@Bean
	public FileToStringTransformer fileToStringTransformer() {
		
		return new FileToStringTransformer();
	}

	@Bean
	public IntegrationFlow processFileFlow() {
		
		return IntegrationFlows
				.from("fileInputChannel")
				.transform(fileToStringTransformer())
				.handle("fileProcessor", "process").get();
	}

	@Bean
	public MessageChannel fileInputChannel() {
		
		return new DirectChannel();
	}

}
