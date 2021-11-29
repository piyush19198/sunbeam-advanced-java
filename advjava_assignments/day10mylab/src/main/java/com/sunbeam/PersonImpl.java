package com.sunbeam;

public class PersonImpl implements Person {
	private String name;
	private int age;
	private String email;
	
	public PersonImpl() {
	}
	public PersonImpl(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "PersonImpl [name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	@Override
	public void setPerson(Person person) {
		@SuppressWarnings("unused")
		Person somePerson = person;
		
	}

}
