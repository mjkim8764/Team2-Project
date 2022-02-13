package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.MemberDTO;
import model.domain.ManagerDTO;
import model.util.DBUtil;

public class MembersDAO {
	// 회원 가입
	public static boolean createMember(MemberDTO member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into members values(?, ?, ?, ?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMdate());
			pstmt.setInt(5, member.getMaxloan());
			pstmt.setString(6, "USER");

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 회원 탈퇴
	public static boolean deleteMember(String memberId, String memberPw) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from members where id=? AND pw=?");
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

//	update members set id ='koll02' where id='koll01'
	// manager ID 는 소문자로
	public static boolean updateMember(String id, String pw, String name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update members set pw=?, name=? where id=?");
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, id);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean updateMemberCnt(String id, int cnt) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update members set maxloan=maxloan + ? where id=?");
			pstmt.setInt(1, cnt);
			pstmt.setString(1, id);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static MemberDTO getMember(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from members where id=?");
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}

	public static ArrayList<MemberDTO> getAllSelect() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberDTO> member = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from members");
			rset = pstmt.executeQuery();
			member = new ArrayList<MemberDTO>();
			while (rset.next()) {
				member.add(new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getInt(5)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}

	public static boolean isManager(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String member = null;

		try {
			con = DBUtil.getConnection();
//			return id.equals(Query출력문)
			pstmt = con.prepareStatement("select ? from members where job='MANAGER'");
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				System.out.println(rset.getString(1));
				if(rset.getString(1).equals(id)) {
					return true;
				}
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return false;
	}
	
	//아이디가있는지, 그게 일치하는지 반환은 t/f
	public static boolean isMember(String mid, String mpw) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String member = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select id,pw from members where id=? and pw=?");
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rset = pstmt.executeQuery();
			
			// id 비교 -> pw
			// id return
			if (rset.next()) {
				if(rset.getString(1).equals(mid)) {
					if(rset.getString(2).equals(mpw)) {
						return true;
					}
				}
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return false;
	}

	public static void main(String args[]) {
		try {
			isManager("koll01");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
