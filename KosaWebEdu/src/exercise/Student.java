package exercise;

class Human {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Human() {}
	public Human(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public String printInformation() {
		String tab = "\t";
		return name+tab+age+tab+height+tab+weight;
	}
}

class Student extends Human {
	private String number;
	private String major;
	
	public Student() {}
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	public String printInformation() {
		String tab = "\t";
		return super.printInformation()+tab+number+tab+major;
	}
}