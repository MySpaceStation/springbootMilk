package com.hc.core.base;

import com.hc.extra.kit.ReflectKit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author milk.huchan
 * @version 1.0
 * @createTime 2016/10/27 23:42
 * @ChangeLog 优化代码结构
 */
public abstract class BaseController<T> implements InitializingBean {
	private final Class<T> entityClass = ReflectKit.findParameterizedType(this.getClass(), 0);
	private String viewPrefix;

	BaseController() {
		this.setViewPrefix(this.defaultViewPrefix());
	}

	public void afterPropertiesSet() throws Exception {
	}

	protected void setDefaultData(T t){
		
	}

	protected void setCommonData(T t){

	}

	protected void updateCommonData(T t){

	}

	private String getViewPrefix() {
		return this.viewPrefix;
	}

	private void setViewPrefix(String viewPrefix) {
		if(viewPrefix.startsWith("/")) {
			viewPrefix = viewPrefix.substring(1);
		}

		this.viewPrefix = viewPrefix;
	}

	String viewName(String suffixName) {
		if(!suffixName.startsWith("/")) {
			suffixName = "/" + suffixName;
		}

		return this.getViewPrefix() + suffixName;
	}

	/**
	 * 获取当前的第一个注解值
	 * @return currentViewPrefix
	 */
	private String defaultViewPrefix() {
		String currentViewPrefix = "";
		RequestMapping requestMapping =  AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class); //获取RequestMapping注解
		if(requestMapping != null && requestMapping.value().length > 0) {
			currentViewPrefix = requestMapping.value()[0];//获取当前第一个注解的value值
		}

		if(StringUtils.isEmpty(currentViewPrefix)) {
			currentViewPrefix = this.entityClass.getSimpleName();
		}

		return currentViewPrefix;
	}
}
