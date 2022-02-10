package model;

import java.sql.SQLException;

import model.domain.BookDTO;
import model.domain.MemberDTO;
import model.domain.RentDTO;

public class EbookModel {
	//Member CRUD
	public static void addMember(MemberDTO member)throws SQLException{
		MemberDAO.createMember(member);
	}
	
	public static MemberDTO getMember(String id) throws SQLException{
		return MemberDAO.getMember(id);
	}
	
	public static void updateMember (MemberDTO member) throws SQLException{
		MemberDAO.updateMember(member);
	}
	
	public static void deleteMember (String id) throws SQLException{
		MemberDAO.deleteMember(id);
	}
	
	
	
	//Book CRUD
	public static void addBook(BookDTO book)throws SQLException{
		BookDAO.createBook(book);
	}
	
	public static BookDTO getBook(String id) throws SQLException{
		return BookDAO.getBook(id);
	}
	
	public static BookDTO getAllBooks() throws SQLException{
		return BookDAO.getAllBooks();
	}
	
	public static void updateBook (BookDTO book) throws SQLException{
		BookDAO.updateBook(book);
	}
	
	public static void deleteBook (String id) throws SQLException{
		BookDAO.deleteBook(id);
	}
	
	
	
	//Rent CRUD
	public static void addRent(RentDTO rent)throws SQLException{
		RentDAO.createRent(rent);
	}
	
	public static RentDTO getRent(String id) throws SQLException{
		return RentDAO.getRent(id);
	}
	
	public static RentDTO getAllRents() throws SQLException{
		return RentDAO.getAllRents();
	}
	
	public static void updateRent (RentDTO rent) throws SQLException{
		RentDAO.updateRent(rent);
	}
	
	public static void deleteRent (String id) throws SQLException{
		RentDAO.deleteRent(id);
	}
}
