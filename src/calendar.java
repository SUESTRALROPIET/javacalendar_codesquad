import java.util.Scanner;

public class calendar {

	public static void main(String[] args) {
		System.out.println("Hello");

		System.out.println(" 일 월  화 수  목 금  토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력 
		System.out.println("달을 입력하세요.");
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		if (a == 2) {
			System.out.printf("%d월은 28일까지 있습니다.",a);
		}
		else if (a%2 == 1) {
			System.out.printf("%d월은 31일까지 있습니다.",a);
		}
		else {
			System.out.printf("%d월은 30일까지 있습니다.",a);
		}
		
		scan.close();
	}
}
