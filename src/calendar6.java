import java.util.Scanner;

public class  calendar6 {
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public boolean LEAP_YEAR(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}
	
	private final static String PARSE = "   ";
	
	public int getMaxDays(int year, int month) {
		if (LEAP_YEAR(year)) {
			return LEAP_MAX_DAYS[month-1];
		}
		else {
			return MAX_DAYS[month-1];
		}
	}
	
	public int WHOLE_DAYS_OF_YEAR(int year) {		
		if (LEAP_YEAR(year)) {
			return 366;
		}
		else {
			return 365;
		}
	}
	
	public int count_YEAR(int year) {
		int sum = 0;
		for (int i = 1970; i < year; i++) { 
			sum  += WHOLE_DAYS_OF_YEAR(i);
		}
		return (sum + 4) % 7;
	}
	
	public int count_DATE(int year, int month) {
		int sum = 0;
		int sum_year = count_YEAR(year);
		
		for (int j = 0; j < month-1; j++ ) {
			if (LEAP_YEAR(year)) {
				sum += LEAP_MAX_DAYS[j];
			}
			else {
				sum += MAX_DAYS[j];
			}
		}
		return (sum + sum_year) % 7;
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf("   <<%4d년 %3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		int maxDay = getMaxDays(year, month);
		
		int parse = 0;
		while(parse< count_DATE(year,month)) {
			System.out.printf(PARSE);
			parse++;
		}

		for(int i = 1; i <= (7 - count_DATE(year,month)); i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		
		for(int j = (7 - count_DATE(year,month)+1); j <= maxDay; j++) {
				System.out.printf("%3d",j);
				if ((j + count_DATE(year,month)) % 7 == 0) {
					System.out.println();
				}			
		}
		System.out.println();
	}

	public void runPormpt() {
		calendar6 cal = new calendar6();
		Scanner scan = new Scanner(System.in);
		
		int year,month;
		
		while (true) {
			System.out.println("년도를 입력하세요.(exit: -1)");
			System.out.printf("YEAR> ");
			year = scan.nextInt();
			
			if (year == -1) {
				break;
			}
			else if (year < 1970 || year > 9999) {
				System.out.println("잘못된 입력입니다. (1970년 보다 큰 값 입력)");
				continue;
			}
			
			System.out.println("달을 입력하세요.");
			System.out.printf("MONTH> ");
			month = scan.nextInt();
			
			if(month>12 || month<1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			cal.printCalendar(year, month);
		}
		System.out.println("Bye-");
		scan.close();
	}
	
	public static void main(String[] args) {
		calendar6 p = new calendar6();
		p.runPormpt();
	}
}