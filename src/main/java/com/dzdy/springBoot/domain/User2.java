package com.dzdy.springBoot.domain;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User2 {
	@Value("${com.dzdy.name}")
	private String name;
	@Value("${com.dzdy.age}")
	private Integer age;
	private Date birthday;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public User2(String name, Integer age, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	public User2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
