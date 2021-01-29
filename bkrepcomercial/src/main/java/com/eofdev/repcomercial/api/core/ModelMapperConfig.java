package com.eofdev.repcomercial.api.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
// Instancia o ModelMapper para que o Spring possa gerencia-la
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
}
