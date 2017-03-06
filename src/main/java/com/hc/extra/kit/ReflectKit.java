/**********************************************************************
 *@Project： LifeCMS
 *@File: ReflectKit
 *@Date: 2016/10/26
 *@Copyright huchanmilk@qq.com All Rights Reserved.
 ***********************************************************************
 *注意： 本内容仅限于个人学习，禁止外泄
 **********************************************************************
 */
package com.hc.extra.kit;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author milk.huchan
 * @version 1.0
 * @createTime 2016/10/26 22:45
 * @ChangeLog
 */
public class ReflectKit {

	/**
	 * 通过param得到属性值
	 * @param bean
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static Object getProperty(Object bean, String param) throws Exception {
		Field[] fields = bean.getClass().getDeclaredFields();//得到类中的所有属性集合
		Field.setAccessible(fields, true);// 设置些属性是可以访问的
		Object obj = null;
		for (Field field :fields) {
			if (param.equals(field.getName())) {
				obj = field.get(bean);//得到此属性的值
			}
		}
		return obj;
	}

	/**
	 * 获取当前类下的注解类型
	 *
	 * @param clazz
	 * @param index
	 * @param <T>
	 * @return
	 */
	public static <T> Class<T> findParameterizedType(Class<?> clazz, int index) {
		Type parameterizedType = clazz.getGenericSuperclass();
		if(!(parameterizedType instanceof ParameterizedType)) {
			parameterizedType = clazz.getSuperclass().getGenericSuperclass();
		}

		return parameterizedType instanceof ParameterizedType?(Class)((ParameterizedType)parameterizedType).getActualTypeArguments()[index]:null;
	}
}
