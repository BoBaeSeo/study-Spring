package gugudan;

public class GugudanArray {

	public static void main(String[] args) {
		int[] numList = {1,2,3,4,5,6,7,8,9};
		for(int i=2; i<10; i++) {
			for(int j=0; j<numList.length; j++) {
				System.out.print(" || "+i+"*"+numList[j]+"= "+(i*numList[j]));
			}
			System.out.println();
		}
	}
}
