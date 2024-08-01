package mvc.controller;

import java.util.List;

import mvc.model.domain.MeetingDTO;
import mvc.model.domain.ReplyDTO;
import mvc.model.service.MeetingDAO;

public class MeetingController {
	private MeetingDAO dao;
	public MeetingController() {
		dao = new MeetingDAO();	
	}
	
	public void meetingCreate(String name, String title, String stringmdate) {
		MeetingDTO dto = new MeetingDTO();
		dto.setName(name);
		dto.setTitle(title);
		dto.setMeetingDate(stringmdate);
		
		boolean result = dao.insertM(dto);
		if (result)
			System.out.println("meeting 저장 성공");
		else 
			System.out.println("meeting 저장 실패");
		
	}
	public void replyCreate(int refid, String name, String content) {
		ReplyDTO dto = new ReplyDTO();
		dto.setName(name);
		dto.setContent(content);
		dto.setRefid(refid);
		
		boolean result = dao.insertReply(dto);
		if (result)
			System.out.println("reply 저장 성공");
		else 
			System.out.println("reply 저장 실패");
	}
	public void meetingRead() {
		List<MeetingDTO> list = dao.listM(); 
		if (list.size() == 0) {
			System.out.println("아직 작성된 글이 없어요 ㅠㅠ");
		} else {
			for(MeetingDTO dto : list) {
				System.out.print(dto.getId()+"\t");
				System.out.print(dto.getName()+"\t");
				System.out.print(dto.getMeetingDate()+"\t");
				System.out.println(dto.getTitle());
			}		
		}
	}
	public void meetingRWithName(String name) {
		List<MeetingDTO> list = dao.searchM(name); 
		for(MeetingDTO dto : list) {
			System.out.print(dto.getId()+"\t");
			System.out.print(dto.getName()+"\t");
			System.out.print(dto.getMeetingDate()+"\t");
			System.out.println(dto.getTitle());
		}	
	}

	public void replyRead(int refid) {
		List<ReplyDTO> list = dao.listReply(refid); 
		if (list.size() == 0) {
			System.out.println("<<<<아직 댓글이 없어요 ㅠㅠ>>>>");
		} else {
			for(ReplyDTO dto : list) {
				System.out.print("\t");
				System.out.print(dto.getId()+"\t");
				System.out.print(dto.getName()+"\t");
				System.out.print(dto.getContent()+"\t");
				System.out.println(dto.getRefid());
			}
		}
	}

	public void meetingDelete(int id) {
		boolean result = dao.deleteM(id);
		if (result)
			System.out.println("삭제 성공");
		else 
			System.out.println("삭제 실패");
	}
}
