package day12.case3;

public class TVFactory {
	public static TV getTV(String beanName){ //누군가가 관리해주는 객체 (bean)
		TV obj = null;
		if(beanName.equals("samsung")){
			obj = new SamsungTV();
		} else if(beanName.equals("lg")){
			obj = new LgTV();
		}
		return obj;
	}

}
