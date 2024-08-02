package mvclab.controller;

import java.util.List;

import mvclab.model.StudentDAO;
import mvclab.model.StudentDTO;

public class StudentController {
	StudentDAO dao = new StudentDAO();
	StudentDTO dto = null;
	
	public void printAll() {
		List<StudentDTO> list = dao.getAllStudent();
		StringBuilder output = new StringBuilder();
		
		for(StudentDTO elem : list) {
			output.append(elem.toString());
		}
		System.out.println(output.toString());
	}
	
	public void printScore(String name) {
		dto = new StudentDTO();
		dto.setName(name);
		int result = dao.getScore(dto);
		
		if(result != -1) {
			dto.setScore(result);
			System.out.println(dto);
		} else {
			System.out.println(name+" 학생은 존재하지 않습니다.");
		}
	}
	
	public void insert(String name, int score) {
		dto = new StudentDTO();
		dto.setName(name);
		dto.setScore(score);
		
		if(dao.insertStudent(dto)) {
			System.out.println("입력 성공");
		} else {
			System.out.println("입력 실패");
		}
	}
	
	public void update(String name, int score) {
		dto = new StudentDTO();
		dto.setName(name);
		dto.setScore(score);
		
		if(dao.updateStudent(dto)) {
			System.out.println(name + "학생의 점수를 변경했습니다.");
		} else {
			System.out.println(name + "학생은 존재하지 않습니다.");
		}
	}
	
	public void delete(String name) {
		dto = new StudentDTO();
		dto.setName(name);
		
		if(dao.deleteStudent(dto)) {
			System.out.println(name + "학생의 데이터를 삭제했습니다.");
		} else {
			System.out.println(name + "학생은 존재하지 않습니다.");
		}
	}
}
