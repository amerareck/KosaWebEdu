package mvc.model.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvc.model.domain.EmpDTO;

public class EmpDAO {
	
	public List<EmpDTO> listAll() {
		List<EmpDTO> list = new ArrayList<>();
		Connection conn = ConnectScott.connect();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select empno, ename, job, to_char(hiredate, 'yyyy\"년\" mm\"월\" dd\"일\"') hd, sal  from emp");) {
			EmpDTO dto;
			while(rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setHiredate(rs.getString("hd"));
				dto.setSal(rs.getInt("sal"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectScott.close(conn);
		}
		return list;
	}
	
	public List<EmpDTO> page1(int start, int end) {
		List<EmpDTO> list =  new ArrayList<>();
		String sql = "select empno, ename, job, hiredate, sal from (select imsi.*, rownum r from (select emp.* from emp order by sal desc) imsi) where r >= ? and r <= ?";
		Connection conn = ConnectScott.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			EmpDTO dto;
			while(rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setSal(rs.getInt("sal"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectScott.close(conn);
		}
		return list;
	}
	public List<EmpDTO> page2(int start, int end) {
		List<EmpDTO> list =  new ArrayList<>();
		String sql = "SELECT empno, ename, job, hiredate, sal FROM emp ORDER BY sal DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		Connection conn = ConnectScott.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  start-1);
			pstmt.setInt(2, end-start+1);
			rs = pstmt.executeQuery();
			EmpDTO dto;
			while(rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setSal(rs.getInt("sal"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectScott.close(conn);
		}
		return list;
	}
}
