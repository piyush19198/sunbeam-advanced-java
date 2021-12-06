package com.sunbeam;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessorImpl implements BeanPostProcessor {
	public Object postProcessBeforeInitialization(Object bean, String beanName)  {
		if(bean instanceof Box || bean instanceof BoxInfo)
			System.out.println("CustomBeanPostProcessorImpl.postProcessBeforeInitialization() called for " + beanName);
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		if(bean instanceof Box || bean instanceof BoxInfo)
			System.out.println("CustomBeanPostProcessorImpl.postProcessAfterInitialization() called for " + beanName);
		return bean;
	}
}
