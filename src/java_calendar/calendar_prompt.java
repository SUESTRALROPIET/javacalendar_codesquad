package java_calendar;

import java.text.ParseException;
import java.util.Scanner;

public class calendar_prompt {
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록   ");
		System.out.println("| 2. 일정 검색  ");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	public int parseDay(String week) {
		if (week.equals("su"))	return 0;
		else if (week.equals("mo"))	return 1;
		else if (week.equals("tu"))	return 2;
		else if (week.equals("we"))	return 3;
		else if (week.equals("th"))	return 4;
		else if (week.equals("fr"))	return 5;
		else if (week.equals("sa"))	return 6;
		else
			return 0;
	}

	public void runPrompt() throws ParseException {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		calendar_final cal = new calendar_final();

		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next(); //한글자 scanner 받음 
			
//			파라미터를 넣지 않으면 메소드에 
//			Scanner s = new ~ s.close();
//			Calender c = new Calendar(); 를 추가해야함. 
//			참조호출을 해서 쓰는 것이 더 효율적임.
			if(cmd.equals("1")) cmdRegister(scanner, cal);
			else if(cmd.equals("2")) cmdSearch(scanner, cal);
			else if(cmd.equals("3")) cmdCal(scanner, cal);
			else if(cmd.equals("h")) printMenu();
			else if(cmd.equals("q")) break;
		}

		System.out.println("Bye!");
		scanner.close();
	}

//	Scanner를](//scanner를) 패러미터로 넘겨받음.

	private void cmdCal(Scanner s, calendar_final c) {
		int month = 1;
		int year = 2017;

		System.out.println("년도를 입력하세요.");
		System.out.println("YEAR> ");
		year = s.nextInt();
		
		System.out.println("달을 입력하세요.");
		System.out.println("MONTH> ");
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
//			loop가 없고, 함수 및 메소드를 종료하려면 return;
			return;
		}

		c.printCalendar(year, month);
	}

	private void cmdSearch(Scanner s, calendar_final c) {
		System.out.println("[일정검색]");
		System.out.println("날짜를 입력해주세요(yyyy-mm-dd)");
		String date = s.next();
		String plan = "";
		try {
			plan = c.searchPlan(date);
		}
		catch (ParseException e) {
			e.printStackTrace();
			System.out.println("일정검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);
	}

	private void cmdRegister(Scanner s, calendar_final c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요(yyyy-mm-dd)");

		String date = s.next();
		
		String text = "";

		s.nextLine();	// ignore](//ignore) one newline
		System.out.println("일정을 입력해주세요");

		text = s.nextLine();

		c.registerPlan(date, text);

	}

	public static void main(String[] args) throws ParseException {
		calendar_prompt p = new calendar_prompt();
		p.runPrompt();
	}
}
