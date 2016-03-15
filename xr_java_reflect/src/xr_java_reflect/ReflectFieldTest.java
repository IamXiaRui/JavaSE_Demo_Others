package xr_java_reflect;

/*
 * ��������ֶ�
 * */
import java.lang.reflect.Field;

import org.junit.Test;

public class ReflectFieldTest {
	@Test
	public void test() throws Exception {
		Person p = new Person();

		// ������
		Class cla = Class.forName("xr_java_reflect.Person");

		// �õ�����ֶ�
		Field f = cla.getField("name");

		// �õ��ֶε�ֵ
		Object obj = f.get(p);

		// �õ��ֶε�����
		Class type = f.getType();

		// �ж��ֶε����� �����String ��ǿת
		if (type.equals(String.class)) {
			String name = (String) obj;
			System.out.println(name);
		}

		// �����ֶε�ֵ
		f.set(p, "iamxiarui");
		System.out.println(p.name);

	}
}
