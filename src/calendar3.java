import java.util.Scanner;

public class calendar3 {
	private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public int getmaxDaysofmonth(int month) {
		return MAX_DAYS[month-1];
	}
	
	public void printSampleCalendar() {
		System.out.println(" 일 월  화 수  목 금  토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}
	
	public static void main(String[] args) {
		String PROMPT = "cal> ";
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력 
		Scanner scan = new Scanner(System.in);
		calendar3 cal = new calendar3();
		
		int month = 1;
		
		while(true) {
			System.out.println("달을 입력하세요.");
			System.out.print(PROMPT);
			month = scan.nextInt();
			if (month == -1) {
				//loop를 빠져나가시오. 
				break;
			}
			if (month > 12) {
				//loop의 처음으로 돌아가는 명령어 
				continue;
			}	
			System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getmaxDaysofmonth(month));
		} 
		System.out.println("Bye-");
		scan.close();
	}
}
