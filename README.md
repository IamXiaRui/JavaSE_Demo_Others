#枚举与反射
##枚举

###枚举的基本概念

1、枚举是一些程序在运行时，它需要的数据不能是任意的．而必须是一定范围内的值。

２、枚举可以有构造函数、字段和方法。

３、格式：Ｔｅｓｔ类只能用Ａ，Ｂ，Ｃ，Ｄ，Ｅ这五个对象。
	ｅｎｕｍ　Ｔｅｓｔ｛
		Ａ，Ｂ，Ｃ，Ｄ，Ｅ；
	｝

4、枚举对象一定要跟构造函数中的参数类型一致。

5、当枚举中有抽象方法的时候，在定义枚举对象的时候就需要实现抽象方法。

###枚举类和方法

１、枚举类是特殊的Ｊａｖａ类，枚举的构造函数必须是私有的。

２、枚举类中声明的每一个枚举值代表枚举类的一个实例化对象。

３、枚举类也可以实现接口或者继承抽象类。

４、若枚举类只有一个枚举值，则可以当做单例设计模式使用。

	 String	name() 
		          返回此枚举常量的名称，在其枚举声明中对其进行声明。

	 int	ordinal() 
		          返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。

	static 	valueOf(Class<T> enumType, String name) <T extends Enum<T>>  T	          
	返回带指定名称的指定枚举类型的枚举常量。



##反射

###反射的基本概念

１、反射就是加载类，并解剖出类的各个组成部分，比如成员变量、方法、构造方法等。

2、反射是用来做框架用的，平常不需要用到反射。

3、加载类：Ｊａｖａ中Ｃｌａｓｓ类代表某个类的字节码

加载类的三种方法：

	// 加载类的第一种方法
		Class class_one = Class.forName("xr_java_reflect.Person");

		// 加载类的第二种方法
		Class class_two = new Person(null, 0).getClass();

		// 加载类的第三种方法
		Class class_th

3、反射类：

>返回 public

	Field	getField(String name) 
		   返回一个 Field 对象，它反映此 Class 对象所表示的类或接口的指定公共成员字段。

	Constructor<T>	getConstructor(Class<?>... parameterTypes) 
		   返回一个 Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法。

	 Method	getMethod(String name, Class<?>... parameterTypes) 
	       返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法。


>返回 private

	Method	getDeclaredMethod(String name, Class<?>... parameterTypes) 
		 返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法。
	
	Constructor<T>	getDeclaredConstructor(Class<?>... parameterTypes) 
		 返回一个 Constructor 对象，该对象反映此 Class 对象所表示的类或接口的指定构造方法。
	
	Field	getDeclaredField(String name)  
	 返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段。



###利用Constructor创建对象

	T	newInstance(Object... initargs) 
	   使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。

>普通反射类
	public void test_one() throws Exception {
			// 反射无参类
			Class class_one = Class.forName("xr_java_reflect.Person");
			Constructor c_one = class_one.getConstructor(null);// public
			Person p_one = (Person) c_one.newInstance(null);
			System.out.println(p_one.name);
		}

>暴力反射
	public void test_four() throws Exception {
		// 反射一个参数类
		Class class_four = Class.forName("xr_java_reflect.Person");
		Constructor c_four = class_four.getDeclaredConstructor(List.class); // private
		c_four.setAccessible(true);// 暴力反射
		Person p_four = (Person) c_four.newInstance(new ArrayList());
		System.out.println(p_four.name);
	}


###利用Method创建方法


	Object	invoke(Object obj, Object... args) 
	          对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。

示例代码：

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

###反射字段：


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

##内省
###基本概念

１、Ｊａｖａｂｅａｎ：公共Java类，但是为了编辑工具识别，需要满足至少三个条件：

>①有一个public默认构造器（例如无参构造器）。

>②属性使用public 的get，set方法访问，也就是说设置成private，同时get，set方法与属性名的大小也需要对应。例如属性name，get方法就要写成，public String getＮame(){},N大写。

>③需要序列化。这个是框架，工具跨平台反映状态必须的。

２、Ｉｎｔｒｏｓｐｅｃｔｏｒ：内省是Java语言对Bean类属性、事件的一种缺省处理方法。

３、属性由ｇｅｔ和ｓｅｔ方法来决定。


###内省操作ｂｅａｎ的属性

１、内省访问类属性

	static BeanInfo	getBeanInfo(Class<?> beanClass) 
	  在 Java Bean 上进行内省，了解其所有属性、公开的方法和事件。


２、得到属性描述器

	PropertyDescriptor[]	getPropertyDescriptors() 
	  获得 beans PropertyDescriptor。


３、得到属性的ｓｅｔ　和　ｇｅｔ方法

	Method	getReadMethod() 
	   获得应该用于读取属性值的方法。
	Method	getWriteMethod() 
	   获得应该用于写入属性值的方法。

示例代码：

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

操作单个属性：

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













