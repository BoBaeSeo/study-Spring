package calender;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		// 두 수의 합 구하기
		Scanner scan = new Scanner(System.in);
		System.out.println("두 수를 입력하세요.");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int sum = a + b;
		System.out.println("두 수의 합은 :" + sum);
	}
}
