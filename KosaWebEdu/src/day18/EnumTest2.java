package day18;
enum Season2{
	// JAVA는 유니코드를 지원하는 언어라서
	// ENUM 뿐만 아니라, CLASS, METHOD, VARUABLE 등 이름에도 한글이 올 수 있다. (헤헿)
     봄, 여름, 가을 ,겨울
}
public class EnumTest2 {
   public static void main(String args[]) {
      System.out.println(Season2.봄);
      System.out.println(Season2.여름);
      System.out.println(Season2.가을);
      System.out.println(Season2.겨울);     
   }
}
