package mvc.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvc.model.domain.VisitorDTO;

public class VisitorDAO {
	public List<VisitorDTO> listAll() {
		List<VisitorDTO> list = new ArrayList<>();
		Connection conn = ConnectJdbcTest.connect();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select id, name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), memo  from visitor");) {
			VisitorDTO dto;
			while(rs.next()) {
				dto = new VisitorDTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setWriteDate(rs.getString(3));
				dto.setMemo(rs.getString(4));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectJdbcTest.close(conn);
		}
		return list;
	}
	
	public VisitorDTO one(int id) {
		Connection conn = ConnectJdbcTest.connect();
		VisitorDTO dto = null;
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select id, name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), memo  from visitor where id = "+id);) {			
			if(rs.next()) {
				dto = new VisitorDTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setWriteDate(rs.getString(3));
				dto.setMemo(rs.getString(4));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectJdbcTest.close(conn);
		}
		return dto;
	}
	public List<VisitorDTO> search(String keyword) {
		List<VisitorDTO> list = new ArrayList<>();
		Connection conn = ConnectJdbcTest.connect();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select id, name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), memo "
						+"from visitor where memo like '%"+keyword+"%'");) {
			VisitorDTO dto;
			while(rs.next()) {
				dto = new VisitorDTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setWriteDate(rs.getString(3));
				dto.setMemo(rs.getString(4));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectJdbcTest.close(conn);
		}
		return list;
	}
	public boolean insert(VisitorDTO dto) {
		System.out.println(dto);
		boolean result = true;
		Connection conn = ConnectJdbcTest.connect();
		try (PreparedStatement pstmt = conn.prepareStatement(
						"insert into visitor values(visitor_seq.nextval, ?, sysdate, ?)");) {
			pstmt.setString(1, dto.getName());
			pstmt.setString(2,  dto.getMemo());
			
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			ConnectJdbcTest.close(conn);
		}
		return result;
	}
	public boolean delete(int id) {
		boolean result = true;
		Connection conn = ConnectJdbcTest.connect();
		try (PreparedStatement pstmt = conn.prepareStatement(
						"delete from visitor where id = ?");) {
			pstmt.setInt(1, id); 
			int deleteNum = pstmt.executeUpdate();
			if(deleteNum != 1)
				result =false;
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			ConnectJdbcTest.close(conn);
		}
		return result;
	}
	public boolean update(VisitorDTO dto) {
		
		boolean result = true;
		Connection conn = ConnectJdbcTest.connect();
		try (PreparedStatement pstmt = conn.prepareStatement(
						"update visitor set name = ?, memo = ? where id = ?");) {
			pstmt.setString(1, dto.getName());
			pstmt.setString(2,  dto.getMemo());
			pstmt.setInt(3,  dto.getId());
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			ConnectJdbcTest.close(conn);
		}
		return result;
	}
}


