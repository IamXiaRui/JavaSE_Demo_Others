package xr_java_introspector;

/*
 * 利用内省获取JavaBean的属性 
 * 
 * */
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

public class IntrospectorTest {
	@Test
	public void test1() throws Exception {
		Person p = new Person();

		// 内省访问类的属性
		// BeanInfo bi = Introspector.getBeanInfo(Person.class);

		// 去掉Object中默认的类属性
		BeanInfo bi = Introspector.getBeanInfo(Person.class, Object.class);

		// 获取属性描述器
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();

		// 遍历属性描述器 得到类中的每一个属性 属性是根据类中get 和 set方法的个数决定的
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}
	}

	// 操作bean中单个属性
	@Test
	public void test2() throws Exception {
		Person p = new Person();

		// 得到这个属性的描述器
		PropertyDescriptor pd = new PropertyDescriptor("name", Person.class);

		// 获取这个属性的方法
		System.out.println(pd.getPropertyType());

		// 得到这个属性的 set方法
		Method me = pd.getWriteMethod();

		me.invoke(p, "iamxiarui");

		// 得到这个属性的get方法
		me = pd.getReadMethod();

		System.out.println(p.getName());
	}
}
