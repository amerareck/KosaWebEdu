package day5;

public class ArrayLab3 {

	public static void main(String[] args) {
		char[] arr = {'J', 'a', 'v', 'a'};
		for (int i=0; i<arr.length; i++) {
			if (arr[i]<91) arr[i] += 32;
			else arr[i] -= 32;
		}
		
		for (char c : arr) System.out.println(c);
	}

}
