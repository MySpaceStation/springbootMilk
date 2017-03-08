package com.hc.system.admin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * 用户表
 *
 */
@SuppressWarnings("serial")
@XmlRootElement
public class User extends Model<User> {

	/** 主键ID */
	@TableId(value = "test_id")
	private Long id;

	/** 名称 */
	private String name;

	/** 年龄 */
	private Integer age;

	/** 测试下划线字段命名类型 */
	@TableField(value = "test_type")
	private Integer testType;

	private Long role;
	private String phone;

	public User() {
	}

	public User(Long id, String name, Integer age, Integer testType) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.testType = testType;
	}

	public User(String name, Integer age, Integer testType) {
		this.name = name;
		this.age = age;
		this.testType = testType;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getTestType() {
		return this.testType;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
	}

	public Long getRole() {
		return this.role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", testType=" + testType + ", role="
				+ role + ", phone=" + phone + '}';
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return id;
	}

}
