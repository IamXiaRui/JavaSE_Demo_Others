package xr_java_reflect;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReflectClassTest {
	@Test
	public void test_one() throws Exception {
		// 反射无参类
		Class class_one = Class.forName("xr_java_reflect.Person");
		Constructor c_one = class_one.getConstructor(null);// public
		Person p_one = (Person) c_one.newInstance(null);
		System.out.println(p_one.name);
	}

	@Test
	public void test_two() throws Exception {
		// 反射一个参数类
		Class class_two = Class.forName("xr_java_reflect.Person");
		Constructor c_two = class_two.getConstructor(String.class);// public
		Person p_two = (Person) c_two.newInstance("name");
		System.out.println(p_two.name);
	}

	@Test
	public void test_three() throws Exception {
		// 反射一个参数类
		Class class_three = Class.forName("xr_java_reflect.Person");
		Constructor c_three = class_three.getConstructor(String.class, int.class);// public
		Person p_three = (Person) c_three.newInstance("name", 10);
		System.out.println(p_three.name);
	}

	@Test
	public void test_four() throws Exception {
		// 反射一个参数类
		Class class_four = Class.forName("xr_java_reflect.Person");
		Constructor c_four = class_four.getDeclaredConstructor(List.class); // private
		c_four.setAccessible(true);// 暴力反射
		Person p_four = (Person) c_four.newInstance(new ArrayList());
		System.out.println(p_four.name);
	}

	public void test_five() throws Exception {
		// 反射一个参数类
		Class class_five = Class.forName("xr_java_reflect.Person");
		// 创建无参类对象
		Person p_five = (Person) class_five.newInstance();
		System.out.println(p_five.name);
	}
}
