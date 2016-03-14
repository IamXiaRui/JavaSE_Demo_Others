package xr_java_reflect;

/*
 * 反射的基本概念
 * 
 * 加载类的三种方式
 * 
 * 
 * */
public class ReflectTest {

	public static void main(String[] args) throws ClassNotFoundException {

		// 加载类的第一种方法
		Class class_one = Class.forName("/xr_java_reflect/src/xr_java_reflect/Person");

		// 加载类的第二种方法
		Class class_two = new Person(null, 0).getClass();

		// 加载类的第三种方法
		Class class_three = Person.class;
	}

}
