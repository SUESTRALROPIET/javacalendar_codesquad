package java_calendar;

import java.text.ParseException;
import java.util.Scanner;

public class retry_prompt {
	
	public void printMenu() {
		System.out.println("---------------------");
		System.out.println("ㅣ 1. 일정 등록        ");
		System.out.println("ㅣ 2. 일정 검색        ");
		System.out.println("ㅣ 3. 달력 보기        ");
		System.out.println("ㅣ h. 도움말   q. 종료  ");
		System.out.println("---------------------");
	}
	
	public void runPrompt() throws ParseException {
		printMenu();
	
		Scanner scan = new Scanner(System.in);
		retry_calendar cal = new retry_calendar();
		
//		while(true) {
//			System.out.println("명령 (1, 2, 3, h, q)");
//			String cmd = scan.next();
//			
//			if(cmd.equals("1")) cmdRegister(scan, cal);
//			else if(cmd.equals("2")) cmdSearch(scan, cal);
//			else if(cmd.equals("3")) cmdCalendar(scan, cal);
//			else if(cmd.equals("h")) printMenu();
//			else if (cmd.equals("q")) break;
//		}
		
		//Swtich 구문
		boolean isLoop = true;
		
		while(isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scan.next();
			
			switch(cmd){
			case "1" : 
				cmdRegister(scan, cal);
				break;
			case "2" :
				cmdSearch(scan, cal);
				break;
			case "3" : 
				cmdCalendar(scan, cal);
				break;
			case "h" : 
				printMenu();
				break;
			case "q" :
				isLoop = false;
				break;
			}
		}
		
		System.out.println("Bye-");
		scan.close();
	}

	private void cmdCalendar(Scanner scan, retry_calendar cal) {
		int year = 2017;
		int month = 1;
		
		System.out.println("년도를 입력하세요.");
		System.out.printf("YEAR> ");
		year = scan.nextInt();
		
		System.out.println("달을 입력하세요.");
		System.out.printf("MONTH> ");
		month = scan.nextInt();
		
		if(month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			
		return;
		}
		
		cal.printCalendar(year,month);
	}

	private void cmdSearch(Scanner scan, retry_calendar cal) {
		System.out.println("[일정검색]");
		System.out.println("날짜를 입력해주세요.(yyyy-mm-dd)");
		
		String date = scan.next();
//		String plan = "";
		PlanItem plan; 
		
//		try {
			plan = cal.searchPlan(date);
//		} catch (ParseException e) {
//			e.printStackTrace();
//			System.out.println("일정 검색 중 오류가 발생했습니다.");
//		}
	
		if (plan != null) {
			System.out.println(plan.detail);
		}
		else {
			System.out.println("일정이 없습니다.");
		}
	}

	private void cmdRegister(Scanner scan, retry_calendar cal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요.(yyyy-mm-dd)");
		
		String date = scan.next();
		String text = "";
		
		scan.nextLine();
		
		System.out.println("일정을 입력해주세요.");
	
		text = scan.nextLine();
		
		cal.registerPlan(date,text);		
	}

	public static void main(String[] args) throws ParseException {
		retry_prompt p = new retry_prompt();
		p.runPrompt();
	}
}
