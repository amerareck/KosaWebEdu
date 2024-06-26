package day9;

class AchademyFriend {
	static String academyName = "KOSA";
	String taineeName;
	String color;
	String hobby;
	String food;
	
	AchademyFriend(String taineeName, String color, String hobby, String food) {
		this.taineeName = taineeName;
		this.color = color;
		this.hobby = hobby;
		this.food = food;
	}
	
	String getName() {
		return taineeName;
	}
	
	String getColor() {
		return color;
	}
	
	String getHobby() {
		return hobby;
	}
	
	String getFood() {
		return food;
	}
}
public class AFTest {

	public static void main(String[] args) {
		AchademyFriend[] af = {
				new AchademyFriend("정준범","빨강색","게임","제육볶음"),
				new AchademyFriend("양정윤","보라색","운동","쌀국수"),
				new AchademyFriend("김채홍","검정","뜨개질","메밀소바")
		};
		
		for (AchademyFriend e : af) {
			System.out.printf("%s 동료는 좋아하는 칼라가 %s이며 취미는 %s입니다. "
					+ "그리고 제일 좋아하는 음식은 %s입니다. "
					+ "현재 %s에서 학습하고 있어요.\n", 
					e.getName(), e.getColor(), e.getHobby(), e.getFood(), AchademyFriend.academyName);
		}
	}

}
