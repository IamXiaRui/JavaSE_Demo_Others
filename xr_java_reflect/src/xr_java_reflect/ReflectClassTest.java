package xr_java_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;

public class ReflectClassTest {
	@Test
	public void test_one() throws Exception {
		// 反射无参类
		Class class_one = Class.forName("xr_java_reflect.Person");
		Constructor c_one = class_one.getConstructor(null);
		Person p_one = (Person) c_one.newInstance(null);
		System.out.println(p_one.name);

	}

}
