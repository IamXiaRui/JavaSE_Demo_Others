package xr_java_reflect;

import java.util.List;

public class Person {
	String name = "Reflect";
	int age;

	public Person() {
		System.out.println("person");
	}

	public Person(String name) {
		System.out.println("name");
	}

	public Person(String name, int age) {
		System.out.println("name age");
	}

	private Person(List list) {
		System.out.println("list");
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

}
