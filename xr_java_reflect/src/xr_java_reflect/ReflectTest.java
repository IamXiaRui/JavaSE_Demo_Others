package xr_java_reflect;

/*
 * ����Ļ�������
 * 
 * ����������ַ�ʽ
 * 
 * 
 * */
public class ReflectTest {

	public static void main(String[] args) throws ClassNotFoundException {

		// ������ĵ�һ�ַ���
		Class class_one = Class.forName("/xr_java_reflect/src/xr_java_reflect/Person");

		// ������ĵڶ��ַ���
		Class class_two = new Person(null, 0).getClass();

		// ������ĵ����ַ���
		Class class_three = Person.class;
	}

}
