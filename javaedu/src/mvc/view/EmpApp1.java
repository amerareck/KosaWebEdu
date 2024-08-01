package mvc.view;

import mvc.model.domain.EmpDTO;
import mvc.model.service.EmpDAO;

import java.util.List;

public class EmpApp1 {

	public static void main(String[] args) {
		List<EmpDTO> r = new EmpDAO().listAll();
		for(EmpDTO dto : r)
			System.out.println(dto);	
		System.out.println("===========");
		for(int i=3; i < 8; i++)
			System.out.println(r.get(i));
	}
}
