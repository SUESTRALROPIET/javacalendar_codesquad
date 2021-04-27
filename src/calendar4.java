import java.util.Scanner;

public class calendar4 {
		//변경이 없는 것 : final static, 변수명을 대문자로 씀 :) 
	private final static String PROMPT = "> ";
	private static final int[] Maxdate = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void perMonthCalendar(int month) {
		System.out.println(" 일  월  화  수  목  금  토");
		System.out.println("--------------------");
		for(int i=0; i < Maxdate[month-1]; i++) {
			if(i>1 && i%7 == 0) {
				System.out.println("");
			}
		System.out.print(i+1 + " ");
		}
	}
	
	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);

		int month = 0;
		
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
			perMonthCalendar(month);
			System.out.println("\n");
		}
		System.out.println("bye!");

		scan.close();
	}


	

}
