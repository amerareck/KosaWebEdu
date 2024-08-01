package mvc.controller;

import mvc.model.domain.VisitorDTO;
import mvc.model.service.VisitorDAO;

import java.util.List;

public class VisitorController {
	private VisitorDAO dao;
	public VisitorController() {
		dao = new VisitorDAO();	
	}
	public void listVisitor() {			
		List<VisitorDTO> list = dao.listAll(); 
		for(VisitorDTO dto : list) {
			System.out.print(dto.getId()+"\t");
			System.out.print(dto.getName()+"\t");
			System.out.print(dto.getWriteDate()+"\t");
			System.out.println(dto.getMemo());
		}
	}
	public boolean oneVisitor(int id, boolean output) {			
		VisitorDTO dto = dao.one(id); 
		boolean result = false;		
		if(dto != null ) { 
			result = true;
			if(output) {
				System.out.print(dto.getId()+"\t");
				System.out.print(dto.getName()+"\t");
				System.out.print(dto.getWriteDate()+"\t");
				System.out.println(dto.getMemo());
			} 		
		}
		return result;
	}
	public void searchVisitor(String keyword) {
		List<VisitorDTO> list = dao.search(keyword); 
		if (list.size() == 0)
			System.out.println(keyword + "를 포함한 글은 없네요~~");
		else 
			for(VisitorDTO dto : list) {
				System.out.print(dto.getId()+"\t");
				System.out.print(dto.getName()+"\t");
				System.out.print(dto.getWriteDate()+"\t");
				System.out.println(dto.getMemo());
			}	
	}	
	public void insertVisitor(String name, String memo) {
		VisitorDTO dto = new VisitorDTO();
		dto.setName(name);
		dto.setMemo(memo);
		System.out.println(dto);
		boolean result = dao.insert(dto);
		if (result)
			System.out.println(name +"님의 글이 성공적으로 저장했어요^^");
		else 
			System.out.println(name +"님의 글 저장 작업을 실패했어요ㅜㅜ");
	}
	public void deleteVisitor(int id) {
		boolean result = dao.delete(id);
		if (result)
			System.out.println(id +"번 글을 성공적으로 삭제했어요^^");
		else 
			System.out.println(id +"번 글이 존재하지 않아요ㅜㅜ");

	}
	public void updateVisitor(int id, String name, String memo) {
		VisitorDTO dto = new VisitorDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setMemo(memo);
		boolean result = dao.update(dto);
		if (result)
			System.out.println(name +"님의 글이 성공적으로 수정했어요^^");
		else 
			System.out.println(name +"님의 글 수정 작업을 실패했어요ㅜㅜ");

	}
}
