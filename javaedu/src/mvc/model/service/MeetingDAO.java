package mvc.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import mvc.model.domain.MeetingDTO;
import mvc.model.domain.ReplyDTO;

public class MeetingDAO {
	public List<MeetingDTO> listM() {
		Connection conn = ConnectJdbcTest.connect();
		Statement stmt = null;
		ResultSet rs = null;
		List<MeetingDTO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT id,name, title, TO_CHAR(meetingdate, 'yy/mm/dd hh24:mi') AS meetingdate FROM meeting");
			MeetingDTO dto = null;
			while (rs.next()) {
				dto = new MeetingDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setMeetingDate(rs.getString("meetingDate"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs, conn);
		}
		return list;
	}

	public boolean insertM(MeetingDTO dto) {
		Connection conn = ConnectJdbcTest.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO meeting VALUES(meeting_seq.NEXTVAL,?,?,?)");
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());

			String[] dateStr = dto.getMeetingDate().split("/");
			int[] dateArr = new int[dateStr.length];
			int i = 0;
			for (String a : dateStr) {
				dateArr[i] = Integer.parseInt(a);
				i++;
			}
			LocalDateTime d = LocalDateTime.of(dateArr[0], dateArr[1] - 1, dateArr[2], dateArr[3], dateArr[4]);
			pstmt.setTimestamp(3, Timestamp.valueOf(d));
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("meeting insert 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}

	public List<MeetingDTO> searchM(String name) {
		Connection conn = ConnectJdbcTest.connect();
		PreparedStatement pstmt = null;
		MeetingDTO dto = null;
		ResultSet rs = null;
		List<MeetingDTO> list = new ArrayList<>();
		System.out.println(name);
		try {
			pstmt = conn.prepareStatement(
					"SELECT id, name, title, TO_CHAR(meetingdate, 'yy/mm/dd hh24:mi') AS md FROM meeting WHERE name = ?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new MeetingDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setMeetingDate(rs.getString("md"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs, conn);
		}
		return list;
	}

	public boolean deleteM(int id) {
		Connection conn = ConnectJdbcTest.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("DELETE FROM meeting WHERE id = " + id);

			if (pstmt.executeUpdate() != 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.err.println("delete 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}

	public List<ReplyDTO> listReply(int refid) {
		Connection conn = ConnectJdbcTest.connect();
		Statement stmt = null;
		ResultSet rs = null;
		List<ReplyDTO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, name, content FROM reply where refid = " + refid);
			ReplyDTO dto = null;
			while (rs.next()) {
				dto = new ReplyDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content"));
				dto.setRefid(refid);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs, conn);
		}
		return list;
	}

	public boolean insertReply(ReplyDTO dto) {
		Connection conn = ConnectJdbcTest.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO reply VALUES(reply_seq.NEXTVAL,?,?,?)");
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getRefid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("reply insert 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}

	private void close(Statement s, ResultSet r, Connection conn) {
		try {
			if (r != null)
				r.close();
			if (s != null)
				s.close();
			ConnectJdbcTest.close(conn);
		} catch (SQLException e) {
			System.err.println("search과정에서 문제 발생" + e);
		}
	}

}
