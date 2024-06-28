package day6;

public class TwoArrayLab2 {

	public static void main(String[] args) {
		char[][] charArr = {
				{'B', 'C', 'A', 'A'},
				{'C', 'C', 'B', 'B'},
				{'D', 'A', 'A', 'D'}
		};
		
		int[] numArr = new int[4];
		
		for(char[] arr : charArr) {
			for(char c : arr) {
				switch (c) {
				case 'A' :
					numArr[0]++;
					break;
				case 'B' :
					numArr[1]++;
					break;
				case 'C' :
					numArr[2]++;
					break;
				case 'D' :
					numArr[3]++;
					break;
				}
			}
		}
		
		for (int i=0; i<numArr.length; i++) {
			System.out.printf("%c 는 %d개 입니다.\n", (char)(i+65), numArr[i]);
		}
	}

}
