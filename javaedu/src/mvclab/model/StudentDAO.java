package mvclab.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";

	public boolean insertStudent(StudentDTO dto) {
		String sql = "INSERT INTO STUDENT VALUES(?, ?)";
		int success = -1;
		
		try(Connection conn = DriverManager.getConnection(url, "jdbctest", "jdbctest");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getScore());
			success = pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return success == 1;
	}
	
	public List<StudentDTO> getAllStudent() {
		List<StudentDTO> list = new ArrayList<>();
		String sql = "SELECT name, score FROM STUDENT";
		
		try(Connection conn = DriverManager.getConnection(url, "jdbctest", "jdbctest");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();) {
			
			while (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setName(rs.getString("name"));
				dto.setScore(rs.getInt("score"));
				list.add(dto);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return list;
	}
	
	public int getScore(StudentDTO dto) {
		String sql = "SELECT score FROM STUDENT WHERE name = ?";
		int result = -1;
		
		try(Connection conn = DriverManager.getConnection(url, "jdbctest", "jdbctest");
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, dto.getName());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("score");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return result;
	}
	
	public boolean updateStudent(StudentDTO dto) {
		String sql = "UPDATE STUDENT SET score = ? WHERE name = ?";
		int result = -1;
		
		try(Connection conn = DriverManager.getConnection(url, "jdbctest", "jdbctest");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
				
				pstmt.setInt(1, dto.getScore());
				pstmt.setString(2, dto.getName());
				result = pstmt.executeUpdate();

		} catch (SQLException sqle) {
				sqle.printStackTrace();
		}
		
		return result == 1;
	}
	
	public boolean deleteStudent(StudentDTO dto) {
		String sql = "DELETE FROM STUDENT WHERE name = ?";
		int result = -1;
		
		try(Connection conn = DriverManager.getConnection(url, "jdbctest", "jdbctest");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
				
				pstmt.setString(1, dto.getName());
				result = pstmt.executeUpdate();

		} catch (SQLException sqle) {
				sqle.printStackTrace();
		}
		
		return result == 1;
	}
	
}
