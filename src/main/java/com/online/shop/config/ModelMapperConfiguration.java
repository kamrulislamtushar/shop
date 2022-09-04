package com.online.shop.config;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Configuration
public class ModelMapperConfiguration {

	private Converter<LocalDate, String> localDateToStringConverter = new AbstractConverter<LocalDate, String>() {
		@Override
		protected String convert(LocalDate localDate) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			return localDate == null ? null : format.format(localDate);
		}
	};

	private Converter<LocalDateTime, String> localDateTimeToStringConverter = new AbstractConverter<LocalDateTime, String>() {
		@Override
		protected String convert(LocalDateTime localDateTime) {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			return localDateTime == null ? null : localDateTime.format(format);
		}
	};

	private Converter<LocalTime, String> localTimeToStringConverter = new AbstractConverter<LocalTime, String>() {
		@Override
		protected String convert(LocalTime localTime) {
			// create formatter Object for ISO_LOCAL_TIME
			DateTimeFormatter formatter
					= DateTimeFormatter.ISO_LOCAL_TIME;
			return localTime == null ? null : localTime.format(formatter);
		}
	};

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.getConfiguration().setFullTypeMatchingRequired(true)
				.setFieldAccessLevel(AccessLevel.PRIVATE);

		// The matching strategy uses strict mode
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.addConverter(localDateToStringConverter);
		modelMapper.addConverter(localDateTimeToStringConverter);
		modelMapper.addConverter(localTimeToStringConverter);

		return modelMapper;
	}
}
