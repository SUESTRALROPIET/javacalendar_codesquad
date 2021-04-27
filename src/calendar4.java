import java.util.Scanner;

public class calendar4 {
		//변경이 없는 것 : final static, 변수명을 대문자로 씀 :) 
	private final static String PROMPT = "> ";
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public boolean isleapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}
	
	public int getmaxDaysofmonth(int year, int month) {
		if (isleapYear(year)) {
			return LEAP_MAX_DAYS[month-1];
		}
		else {
			return MAX_DAYS[month-1];
		}
	}
	
	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		calendar4 cal = new calendar4();
		
		int month = 1;
		int year = -1;
		
		while(true) {
			System.out.println("년도를 입력하세요.");
			System.out.print(PROMPT);
			year = scan.nextInt();

			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			month = scan.nextInt();
			
			if(month == -1) {
				break;
			}
			if(month > 12) {
				continue;
			}	
			cal.printCalendar(year, month);
		}
		System.out.println("Bye-!");
		scan.close();	
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf("   <<%4d년 %3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		int maxDay = getmaxDaysofmonth(year, month);
		
		for(int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d",i);
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {		
		calendar4 p = new calendar4();
		p.runPrompt();
	}
}
