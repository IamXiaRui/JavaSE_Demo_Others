package xr_enumretion_enum;

/*
 * 
 * ö�ٵĻ���ʹ�÷���
 * 
 * 
 * */
public class EnumTest {

	public static void main(String[] args) {
		// Week.Mon Ҳ���൱�� �½���һ��Mon����ֻ����ö�����Ѿ���������
		String day = Week.Mon.getWeek();
		sop("Ӣ������ �� " + day);

		String nameDay = Week.Mon.nameDay();
		sop("\n�������� �� " + nameDay);

	}

	public static void sop(Object obj) {
		System.out.print(obj);
	}
}

// ����ö����
enum Week {
	// �����Ǵ���ö�ٶ���
	Mon("Monday") {
		// ʵ��ö������󷽷�
		public String nameDay() {
			return "����һ";
		}
	},
	Tues("Tuesday") {
		public String nameDay() {
			return "���ڶ�";
		}
	},
	Wed("Wednesday") {
		public String nameDay() {
			return "������";
		}
	},
	Thur("Thursday") {
		public String nameDay() {
			return "������";
		}
	},
	Fri("Friday") {
		public String nameDay() {
			return "������";
		}
	},
	Sat("Saturday") {
		public String nameDay() {
			return "������";
		}
	},
	Sun("Sunday") {
		public String nameDay() {
			return "������";
		}
	};

	private String day;

	// ö����Ĺ��캯��������˽�е�
	private Week(String day) {
		this.day = day;
	}

	public String getWeek() {
		return this.day;
	}

	// ö����ĳ��󷽷�
	public abstract String nameDay();

}