package xr_java_reflect;

import java.util.List;

public class Person {
	String name = "Reflect";
	int age;

	// 几种不同的构造函数
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

	// 几种不同的方法

	public void get() {
		System.out.println("get");
	}

	public void getName(String name) {
		System.out.println(name);
	}

	private void getString(String name, int age) {
		System.out.println(name + age);
	}

}
