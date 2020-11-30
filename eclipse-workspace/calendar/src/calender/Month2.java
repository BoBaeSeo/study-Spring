package calender;

import java.util.Scanner;

public class Month2 {

	//월을 입력하면 그 달이 몇일로 구성되어 있는지 출력하는 프로그램 작성하기
	//원하는 입력횟수를 먼저 입력받는다.
	
	public static void main(String[] args) {
		Month2 mon = new Month2();
		Scanner scan = new Scanner(System.in);
		System.out.println("반복횟수를 입력하세요.");
		int repeatNum = scan.nextInt();
		int[] month = new int[repeatNum];
		System.out.println("월을 입력하세요.");
		for(int i=0; i<repeatNum; i++) {
			month[i] = scan.nextInt();
			System.out.printf("%d월은 %d일까지 있습니다. \n", month[i], mon.getDay(month[i]));
		}
		System.out.println("프로그램 종료");
	}
	
	public int getDay(int month) {
		int day = 0;
		if (month < 8) {
			if (month % 2 == 1) {
				day = 31;
			} else {
				day = 30;
			}
		} else if (month < 13) {
			if (month % 2 == 0) {
				day = 31;
			} else {
				day = 30;
			}
		}
		return day;
	}
}
