package xr_java_introspector;

/*
 * ������ʡ��ȡJavaBean������ 
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

		// ��ʡ�����������
		// BeanInfo bi = Introspector.getBeanInfo(Person.class);

		// ȥ��Object��Ĭ�ϵ�������
		BeanInfo bi = Introspector.getBeanInfo(Person.class, Object.class);

		// ��ȡ����������
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();

		// �������������� �õ����е�ÿһ������ �����Ǹ�������get �� set�����ĸ���������
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}
	}

	// ����bean�е�������
	@Test
	public void test2() throws Exception {
		Person p = new Person();

		// �õ�������Ե�������
		PropertyDescriptor pd = new PropertyDescriptor("name", Person.class);

		// ��ȡ������Եķ���
		System.out.println(pd.getPropertyType());

		// �õ�������Ե� set����
		Method me = pd.getWriteMethod();

		me.invoke(p, "iamxiarui");

		// �õ�������Ե�get����
		me = pd.getReadMethod();

		System.out.println(p.getName());
	}
}
