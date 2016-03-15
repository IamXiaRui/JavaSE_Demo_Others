package xr_java_reflect;

/*
 * ������ķ���
 * 
 * ��������
 * */
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectMethodTest {

	@Test
	public void test1() throws Exception {
		Person p = new Person();
		Class class1 = Class.forName("xr_java_reflect.Person");
		// ��һ������ �Ƿ������з���������
		// �ڶ������� �Ƿ����еĲ��� �޲η��� ֱ��дnull
		Method me = class1.getMethod("get", null);
		// ��һ������ ����Ķ��� �ڶ������� �Ƿ�����Ҫ���ݵĲ���
		me.invoke(p, null);

	}

	@Test
	public void test2() throws Exception {
		Person p = new Person();
		Class class2 = Class.forName("xr_java_reflect.Person");
		// �ڶ������� �� ���յ���һ��String���� ����Ҫд String.class
		Method me = class2.getMethod("getName", String.class);
		me.invoke(p, "xiarui");
	}

	@Test
	public void test3() throws Exception {
		Person p = new Person();
		Class class3 = Class.forName("xr_java_reflect.Person");
		// ˽�з��� �ķ��� ����Ҫʹ��getDeclaredMethod���� ���ص���˽������
		Method me = class3.getDeclaredMethod("getString", String.class, int.class);
		// ��������
		me.setAccessible(true);
		me.invoke(p, "xiarui", 123);
	}

}
