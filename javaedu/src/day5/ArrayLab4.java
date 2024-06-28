package day5;

public class ArrayLab4 {

	public static void main(String[] args) {
		int[] arr = new int[(int)(Math.random()*6)+5];
		for (int i=0; i<arr.length; i++) arr[i] = (int)(Math.random()*26)+1;
		
		char[] charArr = new char[arr.length];
		for (int i=0; i<arr.length; i++) charArr[i] = (char)(arr[i]+96);
		
		for (int i=0; i<arr.length; i++) {
			if (i==arr.length-1) {
				System.out.println(arr[i]);
			} else {
				System.out.printf("%d,",arr[i]);
			}
		}
		for (int i=0; i<charArr.length; i++) { 
			if (i==charArr.length-1) {
				System.out.println(charArr[i]);
			} else {
				System.out.printf("%c,",charArr[i]);
			}
		}
	}

}
