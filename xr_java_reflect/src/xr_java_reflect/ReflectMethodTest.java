package xr_java_reflect;

/*
 * 反射类的方法
 * 
 * 创建方法
 * */
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectMethodTest {

	@Test
	public void test1() throws Exception {
		Person p = new Person();
		Class class1 = Class.forName("xr_java_reflect.Person");
		// 第一个参数 是反射类中方法的名字
		// 第二个参数 是方法中的参数 无参方法 直接写null
		Method me = class1.getMethod("get", null);
		// 第一个参数 是类的对象 第二个参数 是方法中要传递的参数
		me.invoke(p, null);

	}

	@Test
	public void test2() throws Exception {
		Person p = new Person();
		Class class2 = Class.forName("xr_java_reflect.Person");
		// 第二个方法 中 接收的是一个String参数 所以要写 String.class
		Method me = class2.getMethod("getName", String.class);
		me.invoke(p, "xiarui");
	}

	@Test
	public void test3() throws Exception {
		Person p = new Person();
		Class class3 = Class.forName("xr_java_reflect.Person");
		// 私有方法 的反射 必须要使用getDeclaredMethod方法 返回的是私有类型
		Method me = class3.getDeclaredMethod("getString", String.class, int.class);
		// 暴力反射
		me.setAccessible(true);
		me.invoke(p, "xiarui", 123);
	}

	// 反射静态方法
	@Test
	public void test4() throws Exception {
		Class class4 = Class.forName("xr_java_reflect.Person");
		Method me = class4.getMethod("getNames", int.class);
		// 静态方法的反射 不需要指定对象
		me.invoke(null, 23);
	}

	// 反射main方法
	@Test
	public void test5() throws Exception {
		Class class4 = Class.forName("xr_java_reflect.Person");
		Method me = class4.getMethod("main", String[].class);
		// main方法一定要返回 Object类型
		me.invoke(null, new Object[] { new String[] { "xiarui", "iamxiarui" } });
		// me.invoke(null, (Object) new String[] { "xiarui", "iamxiarui" });
	}

}
