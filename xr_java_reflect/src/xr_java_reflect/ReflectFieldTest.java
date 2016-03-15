package xr_java_reflect;

/*
 * 反射类的字段
 * */
import java.lang.reflect.Field;

import org.junit.Test;

public class ReflectFieldTest {
	@Test
	public void test() throws Exception {
		Person p = new Person();

		// 加载类
		Class cla = Class.forName("xr_java_reflect.Person");

		// 得到类的字段
		Field f = cla.getField("name");

		// 得到字段的值
		Object obj = f.get(p);

		// 得到字段的类型
		Class type = f.getType();

		// 判断字段的类型 如果是String 则强转
		if (type.equals(String.class)) {
			String name = (String) obj;
			System.out.println(name);
		}

		// 设置字段的值
		f.set(p, "iamxiarui");
		System.out.println(p.name);

	}
}
