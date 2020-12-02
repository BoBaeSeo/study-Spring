package calender;

import java.util.Scanner;

public class Month {

	public static void main(String[] args) {
		// 월을 입력하면 그 달이 몇일로 구성되어 있는지 출력하는 프로그램 작성하기
		Month mon = new Month();
		Scanner scan = new Scanner(System.in);
		System.out.println("달을 입력하세요.");
		int month = scan.nextInt();
		mon.getDay(month);
		
		//
		
	}
	
	public void getDay(int month) {
		if(month < 8) {
			if(month % 2 == 1) {
				System.out.printf("%d 월은 31일까지 있습니다.", month);
			} else {
				System.out.printf("%d 월은 30일까지 있습니다.", month);
			}
		} else if(month < 13) {
			if(month % 2 == 0) {
				System.out.printf("%d 월은 31일까지 있습니다.", month);
			} else {
				System.out.printf("%d 월은 30일까지 있습니다.", month);
			}
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
}
