package mvclab;

import java.util.Scanner;

import mvclab.controller.StudentController;

public class StudentMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentController ctrl = new StudentController();

		
		main: while (true) {
			String name = "";
			int score = -1;
			
			System.out.println("처리하려는 기능을 선택하세요.");
			System.out.println("1. 학생 정보 출력 ");
			System.out.println("2. 학생 정보 입력 ");
			System.out.println("3. 학생 정보 삭제 ");
			System.out.println("4. 학생 정보 수정 ");
			System.out.println("5. 학생 점수 확인 ");
			System.out.println("6. 종료 ");
			System.out.print("입력 : ");
			String input = sc.nextLine().replaceAll("[^1-6]", "");
			
			switch(input) {
				case "1":
					ctrl.printAll();
					break;
					
				case "2":
					System.out.print("추가하실 학생의 이름을 입력해주세요 : ");
					name = sc.nextLine().trim();
					System.out.print("추가하실 학생의 점수를 입력해주세요 : ");
					score = Integer.parseInt(sc.nextLine().replaceAll("[^0-9]", ""));
					ctrl.insert(name, score);
					break;
					
				case "3":
					System.out.print("삭제하실 학생의 이름을 입력해주세요 : ");
					name = sc.nextLine().trim();
					ctrl.delete(name);
					break;
					
				case "4":
					System.out.print("변경하실 학생의 이름을 입력해주세요 : ");
					name = sc.nextLine().trim();
					System.out.print("변경하실 학생의 점수를 입력해주세요 : ");
					score = Integer.parseInt(sc.nextLine().replaceAll("[^0-9]", ""));
					ctrl.update(name, score);
					break;
					
				case "5":
					System.out.print("검색하실 학생의 이름을 입력해주세요 : ");
					name = sc.nextLine().trim();
					ctrl.printScore(name);
					break;
					
				case "6":
					System.out.println("프로그램을 종료합니다...");
					break main;
					
				default :
					System.out.println("입력 값이 잘못되었습니다. 다시 입력하여 주세요.");
					continue;
			}
		}
		sc.close();
	}
}
