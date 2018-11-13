package com.zh.springboot.web.springbootcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

	@Bean
	public ViewResolver myview(){
		return new Myview();
	}

	private static class Myview implements ViewResolver{
		@Nullable
		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}

}
