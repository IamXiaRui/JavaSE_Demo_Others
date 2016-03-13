package xr_enumretion_enum;

/*
 * 
 * 枚举的基本使用方法
 * 
 * 
 * */
public class EnumTest {

	public static void main(String[] args) {
		// Week.Mon 也就相当于 新建了一个Mon对象，只不过枚举类已经创建过了
		String day = Week.Mon.getWeek();
		sop("英文日期 ： " + day);

		String nameDay = Week.Mon.nameDay();
		sop("\n中文日期 ： " + nameDay);

	}

	public static void sop(Object obj) {
		System.out.print(obj);
	}
}

// 定义枚举类
enum Week {
	// 以下是创建枚举对象
	Mon("Monday") {
		// 实现枚举类抽象方法
		public String nameDay() {
			return "星期一";
		}
	},
	Tues("Tuesday") {
		public String nameDay() {
			return "星期二";
		}
	},
	Wed("Wednesday") {
		public String nameDay() {
			return "星期三";
		}
	},
	Thur("Thursday") {
		public String nameDay() {
			return "星期四";
		}
	},
	Fri("Friday") {
		public String nameDay() {
			return "星期五";
		}
	},
	Sat("Saturday") {
		public String nameDay() {
			return "星期六";
		}
	},
	Sun("Sunday") {
		public String nameDay() {
			return "星期日";
		}
	};

	private String day;

	// 枚举类的构造函数必须是私有的
	private Week(String day) {
		this.day = day;
	}

	public String getWeek() {
		return this.day;
	}

	// 枚举类的抽象方法
	public abstract String nameDay();

}