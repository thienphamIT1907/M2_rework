package com.validateformdangki.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigCustomValidation implements WebMvcConfigurer {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("message-error");
        return messageSource;
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        StringToLocalDateConverter stringToLocalDateConverter = new
//                StringToLocalDateConverter("dd/MM/yyyy");
//        registry.addConverter(stringToLocalDateConverter);
//    }
}
