import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		int first,second;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("두 수를 입력하세요");
		first = scan.nextInt();
		second = scan.nextInt();
		//int total = first + second;
		
		//System.out.println("두 수의 합은 " + total + "입니다.");
		System.out.printf("%d와 %d의 합은 %d입니다", first,second,first+second);
	
		//Resource leak 
		scan.close();
	}

}
