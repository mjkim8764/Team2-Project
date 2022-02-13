package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.domain.RentDTO;
import model.util.DBUtil;

public class RentDAO {

	// 책 대출하기
	public static boolean createRent(String id, String bid) throws Exception {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		ResultSet rset2 = null;
		

		try {
			con = DBUtil.getConnection();

			stmt = con.createStatement();
			pstmt = con.prepareStatement("select maxloan from members where id = ?");
			pstmt.setString(1, id);
			
			stmt = con.createStatement();
			pstmt2 = con.prepareStatement("select bcnt from book where id = ?");
			pstmt2.setString(1, bid);
			
			rset = pstmt.executeQuery();
			
			int maxloan = 10;
			if(rset.next())
				maxloan = rset.getInt(1);
			
			rset2 = pstmt2.executeQuery();
			int bcnt = 0;
			if(rset2.next())
				bcnt = rset2.getInt(1);

			if (maxloan > 0 && bcnt > 0) {
				pstmt = con.prepareStatement("insert into rent values(?, ?, ?, ?)");
				
				
				pstmt.setString(1, id + bid + Integer.toString(maxloan));
				pstmt.setString(2, bid);
				pstmt.setString(3, id);
				pstmt.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

				int result = pstmt.executeUpdate();

				if (result == 1) {
					return true;
				}
			} else {

			}

			// INSERT INTO RENT VALUES(1,'A0001','JS0107','2022-02-02');

		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 책 대출 현황보기
	public static RentDTO rentNow(String rentId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RentDTO rent = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from rent where id=?");
			pstmt.setString(1, rentId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				rent = (new RentDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return rent;
	}

	// select
	// 전체 출력
	public static ArrayList<RentDTO> getAllRents(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentDTO> rent = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from rent where mid = ?");
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			rent = new ArrayList<RentDTO>();
			while(rset.next()) {
				rent.add(new RentDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return rent;
	}

	
	/*
	public static ArrayList<RentDTO> getAllRents(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RentDTO> rent = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from rent where mid = ?");
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			rent = new ArrayList<RentDTO>();
			while(rset.next()) {
				rent.add(new RentDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return rent;
	}
	*/


	// 책 반납
	public static boolean rentDelete(String Mid, String Bid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from rent where mid=? AND bid=?");
			pstmt.setString(1, Mid);
			pstmt.setString(2, Bid);
			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}


	public static boolean deleteRent(String rid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update book set bcnt=bcnt + 1 where id = (select bid from rent where rentno = ?)");
			pstmt.setString(1, rid);
			int result = pstmt.executeUpdate();
			pstmt = con.prepareStatement("update members set maxloan=maxloan + 1 where id = (select mid from rent where rentno = ?)");
			pstmt.setString(1, rid);
			int result3 = pstmt.executeUpdate();
			pstmt = con.prepareStatement("delete from rent where rentno=?");
			pstmt.setString(1, rid);
			int result2 = pstmt.executeUpdate();
			

			if (result == 1 && result2 == 1 && result3 == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

}
