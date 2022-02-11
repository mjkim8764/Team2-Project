package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.RentDTO;
import model.util.DBUtil;

public class RentDAO {

	// 책 대출하기
	public static boolean createRent(String id, String bid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		/*try {
			con = DBUtil.getConnection();
			
			//INSERT INTO RENT VALUES(1,'A0001','JS0107','2022-02-02');
			pstmt = con.prepareStatement("insert into rent values(?, ?, ?, ?)"); 
			pstmt.setInt(1,rent.getRentno());
			pstmt.setString(2,rent.getBid());
			pstmt.setString(3,rent.getMid());
			pstmt.setString(4,rent.getRdate());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;*/
		return false;
	}
	
	//책 대출 현황보기
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
				rent= (new RentDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return rent;
	}
	
	// select
	// 전체 출력
		public static ArrayList<RentDTO> getAllRents() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<RentDTO> rent = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from book");
				rset = pstmt.executeQuery();
				rent = new ArrayList<RentDTO>();
				while(rset.next()) {
					rent.add(new RentDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4)));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return rent;
		}
		
		public static boolean deleteRent(String id) throws SQLException{
			return false;
		}
}
