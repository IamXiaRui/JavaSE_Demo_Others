package xr_java_introspector;

/*
 * ���͵�JavaBean
 * 
 * 1��������˽�е� 
 * 
 *2������ӵ��get ��  set �ķ���
 *
 *3�����Եĸ���  ��get �� set�����ĸ���    
 *
 *4��ÿ��JavaBean����һ��class������
 * 
 * */
import java.util.List;

public class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person() {
		System.out.println("person");
	}

}
