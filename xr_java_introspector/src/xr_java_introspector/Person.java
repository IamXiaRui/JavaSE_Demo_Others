package xr_java_introspector;

/*
 * 典型的JavaBean
 * 
 * 1、属性是私有的 
 * 
 *2、属性拥有get 和  set 的方法
 *
 *3、属性的个数  看get 和 set方法的个数    
 *
 *4、每个JavaBean都有一个class的属性
 * 
 * */
import java.util.List;

public class Person {
	private String name;
	private int age;

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

	public Person() {
		System.out.println("person");
	}

}
