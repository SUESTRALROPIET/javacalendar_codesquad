package java_calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class retry_calendar {

	// 윤년 구분(true/false)
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}
	// 각 달의 최댓값 
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	//각 달의 최댓값 구하는 함수(윤년 구분) 
	public int getMaxDays(int year, int month) {
		if(isLeapYear(year))
			return LEAP_MAX_DAYS[month-1];
		else
			return MAX_DAYS[month-1];
	}

	private int getWeekDay(int year, int month) {
		//1970-01-01 : Thursday 
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4;
		
		//매년 1월 1일 요일값 추출 
		int count = 0;
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		//매달 1일 요일값 추출 
		for (int i = 1; i < month; i++) {
			int delta = getMaxDays(year,i);
			count += delta;
		}
		
//		count += day - 1;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf("   <<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		//get weekday automatically
		int weekday = getWeekDay(year, month);
		//print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.printf("   ");
		}
		
		int maxDay = getMaxDays(year, month);
		int count = 7 - weekday;
		
		//print first week
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
//		new line 기준 
		int delim = (count < 7) ? count : 0;
		
//		//print from second to last
		for(int i = count + 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}
	
	//PlanMap에는 2개의 argument Date(키),Strig(일정)이 들어간다 :) 
//	private HashMap <Date, String> planMap;
	private HashMap <Date, PlanItem> planMap;
	
	private static final String SAVE_FILE = "calendar.dat";
	
	//생성자 만들기  
	//class 파일명과 동일한 메소드명으로 설정해야한다. 아니면 안됨! 
	//캘린더를 초기화하 것 
	public retry_calendar () {
//		planMap = new HashMap<Date, String>();
		planMap = new HashMap<Date, PlanItem>();
		//저장된 파일을 불러와 데이터 조회하기 
		File f = new File(SAVE_FILE);
		if (!f.exists())
			return;
		
		try {
			Scanner s = new Scanner(f);
			//읽을 파일이 있다면 
			while(s.hasNext()) {
				String date = s.next();
				String detail = s.next();
				PlanItem p = new PlanItem(date, detail);
				planMap.put(p.getDate(), p);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//일정 저장 
	public void registerPlan(String strdate, String plan) {
//		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strdate);
//		planMap.put(date, text);
		PlanItem p = new PlanItem(strdate, plan);
		planMap.put(p.getDate(), p);
		
		//파일저장 
		File f = new File(SAVE_FILE);
		String item = p.saveString();
		
		//파일에 데이터 추가 
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public String searchPlan(String strdate) throws ParseException {
	public PlanItem searchPlan(String strdate) {
//		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strdate);
		Date date = PlanItem.getDateformatString(strdate);
//		String plan = planMap.get(date);
//		return plan;
		return planMap.get(date);
	}
	
	public static void main(String[] args) {
		retry_calendar cal = new retry_calendar();
		cal.printCalendar(2021, 2);
	}
}
