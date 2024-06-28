package lambdalab;
import java.util.Random;

@FunctionalInterface
interface Drawable {
	void draw();
}

class Rect implements Drawable {
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
}

class Circle implements Drawable {
	public void draw() {
		System.out.println("원을 그립니다.");
	}
}

class Diamond implements Drawable {
	public void draw() {
		System.out.println("마름모를 그립니다.");
	}
}

public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(3);
		Drawable d = null;
		if (num == 0)
			d = ()->System.out.println("사각형을 그립니다.");
		else if (num == 1)
			d = ()->System.out.println("원을 그립니다.");
		else if (num == 2)
			d = ()->System.out.println("마름모를 그립니다.");
		output(d);
		output(Rect::new); // 객체 생성해서 넘겼는데 왜 draw는 호출을 안할까? 왜왜왜왜왜?????
		output(Rect::new); 
		output(Circle::new); // 결국 객체 생성해서 넘기는게 아니란 뜻이네...
		output(Circle::new); // 실제로 클래스 명도 Circle이 아닌 DrawableTest$$Lambda$5/0x0000000800002218 이 나옴.
		output(Diamond::new); 
		output(Diamond::new);
		output(new Rect()); // 얘는 잘 나옴. 객체 생성이 되었다는 소리.
		output(new Circle());
		output(new Diamond());
		System.out.println();
		d = Rect::new;
		d.draw();
		d = new Rect();
		d.draw();
	}

	public static void output(Drawable d) {
		System.out.println("전달된 객체의 클래스명 : " + d.getClass().getName());
		d.draw();
	}
}
