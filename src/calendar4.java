import java.util.Scanner;

public class calendar4 {
		//변경이 없는 것 : final static, 변수명을 대문자로 씀 :) 
	private final static String PROMPT = "> ";
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getmaxDaysofmonth(int month) {
		return MAX_DAYS[month-1];
	}
	
	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		calendar4 cal = new calendar4();
		
		int month = 1;
		
		while(true) {
			System.out.println("월을 입력하세요.");
			System.out.println(PROMPT);
			month = scan.nextInt();
			if(month == -1) {
				break;
			}
			if(month > 12) {
				continue;
			}	
			cal.printCalendar(2021, month);
		}
		System.out.println("Bye-!");
		scan.close();	
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf("   <<%4d년 %3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		int maxDay = getmaxDaysofmonth(month);
		
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
