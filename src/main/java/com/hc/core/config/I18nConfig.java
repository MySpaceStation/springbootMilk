package com.hc.core.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class I18nConfig {

    /**
     * thymeleaf国际化消息配置
     *
     * @return messageSource
     */
    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setBasename("i18n/messages"); //设置路径
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(2);
        return messageSource;
    }

    /**
     * 自定义消息配置文件路径，指定路径必须加classpath
     *
     * @return validatorMessageSource
     */
    @Bean
    public ReloadableResourceBundleMessageSource validationMessageSource(){
        ReloadableResourceBundleMessageSource validatorMessageSource = new ReloadableResourceBundleMessageSource();
        validatorMessageSource.setBasenames("classpath:i18n/messages","classpath:i18n/validation"); //设置路径
        validatorMessageSource.setDefaultEncoding("UTF-8");
        validatorMessageSource.setUseCodeAsDefaultMessage(false);
        return validatorMessageSource;
    }

    /**
     * hibernate校验国际化消息显示
     *
     * @return validatorFactoryBean
     */
    @Bean
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setProviderClass(HibernateValidator.class);
        validatorFactoryBean.setValidationMessageSource(validationMessageSource());
        return validatorFactoryBean;
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}