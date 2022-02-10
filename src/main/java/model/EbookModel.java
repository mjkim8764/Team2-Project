package model;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NotExistException;
import model.domain.BookDTO;
import model.domain.MemberDTO;
import model.domain.RentDTO;

public class EbookModel {
	
	//Member CRUD
	public static boolean addMember(MemberDTO member)throws SQLException{
		return MemberDAO.createMember(member);
	}
	
	public static MemberDTO getMember(String id) throws SQLException, NotExistException{
		MemberDTO member = MemberDAO.getMember(id);
		
		if(member != null) {
			return member;
		}
		throw new NotExistException("회원 정보가 없습니다.");
	}
	
	public static boolean updateMember (String id, String pw, String name) throws SQLException{
		return MemberDAO.updateMember(id, pw, name);
	}
	
	public static boolean deleteMember (String id) throws SQLException{
		return MemberDAO.deleteMember(id);
	}
	
	public static boolean isManager (String id) throws SQLException{
		return MemberDAO.isManager(id);
	}
	
	
	
	//Book CRUD
	public static boolean addBook(String id, BookDTO book)throws SQLException{
		if(isManager(id)) {
			return BookDAO.createBook(book);
		}
		return false;
	}
	
	public static BookDTO getBook(String id) throws SQLException{
		return BookDAO.getBook(id);
	}
	
	public static ArrayList<BookDTO> getAllBooks() throws SQLException{
		return BookDAO.getAllBooks();
	}
	
	public static boolean updateBook (String id, String bid, int bcnt) throws SQLException{
		if(isManager(id)) {
			return BookDAO.updateBook(bid, bcnt);
		}
		return false;
	}
	
	public static boolean deleteBook (String id, String id) throws SQLException{
		if(isManager(id)) {
			return BookDAO.deleteBook(id);
		}
		return false;
	}
	
	
	
	//Rent CRUD
	public static boolean addRent(String id, String bid)throws SQLException{
		//책 권수 확인
		//대출 가능 권수 확인
		return RentDAO.createRent(id, bid);
	}
	
	public static ArrayList<RentDTO> getAllRents() throws SQLException{
		return RentDAO.getAllRents();
	}
	
	public static boolean deleteRent (String id) throws SQLException{
		RentDAO.deleteRent(id);
	}
}
