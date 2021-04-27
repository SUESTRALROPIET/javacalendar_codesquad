import java.util.Scanner;

public class  calendar5 {
	
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private final static String PARSE = "   ";
	
	public int getMaxDays(int year, int month) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return LEAP_MAX_DAYS[month-1];
		}
		else {
			return MAX_DAYS[month-1];
		}
	}
	
	public int getParseDays(String weekday) {
		if(weekday.equals("SUN")) return 0;
		else if(weekday.equals("MON")) return 1;
		else if(weekday.equals("TUE")) return 2;
		else if(weekday.equals("WED")) return 3;
		else if(weekday.equals("THU")) return 4;
		else if(weekday.equals("FRI")) return 5;
		else if(weekday.equals("SAT")) return 6;
		return 0;		
	}
	
	public void printCalendar(int year, int month, String weekday) {
		System.out.printf("   <<%4d년 %3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		int maxDay = getMaxDays(year, month);
		
		int parse = 0;
		while(parse< getParseDays(weekday)) {
			System.out.printf(PARSE);
			parse++;
		}
		
		for(int i = 1; i <= (7 - getParseDays(weekday)); i++) {
			System.out.printf("%3d",i);
		}
		
		System.out.println();
		
		for(int j = (7 - getParseDays(weekday)+1); j <= maxDay; j++) {
				System.out.printf("%3d",j);
				if ((j + getParseDays(weekday)) % 7 == 0) {
					System.out.println();
				}			
		}
		
		System.out.println();
	}
	
	public void runPormpt() {
		calendar5 cal = new calendar5();
		Scanner scan = new Scanner(System.in);
		
		int year,month;
		String weekday;
		
		System.out.println("년도를 입력하세요.");
		System.out.printf("YEAR> ");
		year = scan.nextInt();
		
		System.out.println("달을 입력하세요.");
		System.out.printf("MONTH> ");
		month = scan.nextInt();

		System.out.println("첫번째 요일을 입력하세요.(SUN,MON,TUE,WED,THU,FRI,SAT)");
		System.out.printf("WEEKDAY> ");
		weekday = scan.next();
		
		cal.printCalendar(year, month, weekday);
	}

	public static void main(String[] args) {
		calendar5 p = new calendar5();
		p.runPormpt();
	}
}