package gugudan;

import java.util.Scanner;

public class gugudan45 {

	public static void main(String[] args) {
		//구구단에서 4단과 5단을 계산한 결과 값을 변수에 저장한 후 저장한 변수 값을 출력한다.
		//그 뒤 사용자가 입력한 숫자 값에 해당하는 단을 출력한다.
		int result = 0;
		for(int i=1; i<10; i++) {
			result = (4 * i);
			System.out.print(" 4 * "+i+" = "+result + " ||");
		}
		System.out.println();
		for(int i=1; i<10; i++) {
			result = (5 * i);
			System.out.print(" 5 * "+i+" = "+result + " ||");
		}
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("4와 5 중 구구단을 출력할 숫자 하나를 선책하세요 >");
		int selNum = scan.nextInt();
		switch(selNum) {
		case 4:
			for(int i=1; i<10; i++) {
				result = (4 * i);
				System.out.print(" 4 * "+i+" = "+result + " ||");
			}
			break;
		case 5:
			for(int i=1; i<10; i++) {
				result = (5 * i);
				System.out.print(" 5 * "+i+" = "+result + " ||");
			}
			break;	
		default:
			System.out.println("잘못 눌렀습니다.");
			break;
		}
	}
}
