package gugudan;

import java.util.Scanner;

public class GugudanMain {

	public static void main(String[] args) {
		GugudanMain gugudan = new GugudanMain();
		Scanner scan = new Scanner(System.in);
		System.out.print("구구단을 출력할 숫자를 고르세요 >");
		gugudan.finalGugudan1(scan.nextInt());
		System.out.println("==========================");
		System.out.print("출력하고 싶은 구구단의 숫자 2개를 입력하세요 ex 3,2 >");
		String inputValue = scan.next();
		gugudan.finalGugudan2(inputValue);
	}
	
	public void finalGugudan1(int selNum){
		for(int i=2; i<selNum+1; i++) {
			for(int j=1; j<selNum+1; j++) {
				System.out.print(" " + i +"*"+ j +"="+ (i*j) + " ||");
			}
			System.out.println();
		}
	}
	
	public void finalGugudan2(String inputValue) {
		String[] splitedValue = inputValue.split(",");
		int first = Integer.parseInt(splitedValue[0]);
		int second = Integer.parseInt(splitedValue[1]);
		for(int i=2; i<first+1; i++) {
			for(int j=1; j<second+1; j++) {
				System.out.print(" " + i +"*"+ j +"="+ (i*j) + " ||");
			}
			System.out.println();
		}
	}
}
