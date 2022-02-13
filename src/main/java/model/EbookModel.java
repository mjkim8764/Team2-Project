package model;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NoAvailableRent;
import exception.NotExistException;
import model.DAO.BookDAO;
import model.DAO.MembersDAO;
import model.DAO.RentDAO;
import model.domain.BookDTO;
import model.domain.MemberDTO;
import model.domain.RentDTO;

public class EbookModel {
	
	public static void Login(String id, String pw) throws Exception{
		if(MembersDAO.isMember(id, pw)) {
		}else {
			throw new NotExistException("존재하지 않는 회원입니다");
		}
	}
	
	//Member CRUD
	public static boolean addMember(MemberDTO member)throws SQLException{
		return MembersDAO.createMember(member);
	}
	
	public static MemberDTO getMember(String id) throws SQLException, NotExistException{
		MemberDTO member = MembersDAO.getMember(id);
		
		if(member != null) {
			return member;
		}
		throw new NotExistException("회원 정보가 없습니다.");
	}
	
	public static boolean updateMember (String id, String pw, String name) throws SQLException{
		return MembersDAO.updateMember(id, pw, name);
	}
	
	public static boolean deleteMember (String id, String pw) throws SQLException{
		return MembersDAO.deleteMember(id, pw);
	}
	
	
	
	//Book CRUD
	public static boolean addBook(String id, BookDTO book)throws SQLException{
		if(MembersDAO.isManager(id)) {
			return BookDAO.createBook(book);
		}
		return false;
	}
	
	public static BookDTO getBook(String bname) throws SQLException{
		return BookDAO.getBook(bname);
	}
	
	public static ArrayList<BookDTO> getAllBooks() throws SQLException{
		return BookDAO.getAllBooks();
	}
	
	public static boolean updateBook (String id, String bid, int bcnt) throws SQLException{
		if(MembersDAO.isManager(id)) {
			return BookDAO.updateBook(bid, bcnt);
		}
		return false;
	}
	
	public static boolean deleteBook (String id, String bid) throws SQLException{
		if(MembersDAO.isManager(id)) {
			return BookDAO.deleteBook(bid);
		}
		return false;
	}
	
	public static boolean deleteAllBook (String id, String[] bid) throws SQLException{
		if(MembersDAO.isManager(id)) {
			for(String b : bid) {
				BookDAO.deleteBook(b);
			}
			return true;
		}
		return false;
	}

	
	
	
	
	
	//Rent CRUD
	public static boolean addRent(String id, String bid)throws Exception{
		//책 권수 확인
		//대출 가능 권수 확인
		if(RentDAO.createRent(id, bid)) {
			System.out.println(11111);
			BookDAO.minusBook(bid, 1);
			MembersDAO.updateMemberCnt(id, -1);
		}
		return false;
	}
	
	public static boolean addAllRent(String id, String[] bid)throws Exception{
		//책 권수 확인
		//대출 가능 권수 확인
		if(bid.length > MembersDAO.getMember(id).getMaxloan()) {
			throw new NoAvailableRent("대출 가능 권수를 초과했습니다.");
		}else {
			for(String b : bid) {
				if(RentDAO.createRent(id, b)) {
					BookDAO.minusBook(id, 1);
					MembersDAO.updateMemberCnt(id, -1);
				}
			}
			return true;
		}
	}

	public static ArrayList<RentDTO> getAllRents(String id) throws SQLException{
		return RentDAO.getAllRents(id);
	}

	
	public static boolean deleteRent (String id) throws SQLException{
		return RentDAO.deleteRent(id);
	}
}
