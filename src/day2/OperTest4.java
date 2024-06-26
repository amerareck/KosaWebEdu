package day2;
public class OperTest4 {
	public static void main(String[] args) {
		int num=10;
		System.out.println(num);	// 10
		System.out.println(++num);	// 11
		System.out.println(++num);	// 12
		System.out.println(++num);	// 13
		
		System.out.println(num++);	// 13	
		System.out.println(num++);	// 14
		
		System.out.println(num);    // 15
		System.out.println(--num);	// 14
		System.out.println(num);	// 14						
		
		
		int a = 4, b = 5, c, d;
		c = a++ - b == 0 ? 1 : 0;
		a=4;
		d = ++a - b == 0 ? 1 : 0;
		System.out.println(""+c+d);
	}
}
