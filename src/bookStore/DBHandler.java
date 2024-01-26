package bookStore;
import java.sql.*;
import java.time.LocalDate;

public class DBHandler {
	Connection conn=null;
	public void connectDB(String dbName) {
		try {
			
			String dbURL="jdbc:mysql://localhost:3306/"+dbName;
			String dbUname="root";
			String dbPass="mysql";
			
			this.conn = DriverManager.getConnection(dbURL, dbUname, dbPass);
			
			if(this.conn != null) {
				System.out.println("Connection successfully established!!");
			}
			
		}catch(SQLException ex) {
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(ex.getMessage());
		}
	}
	public void insertIntoMock(String username, String userpass) {
		String SQLInsert="Insert Into mock (username, userpass) values (?, ?)";
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(SQLInsert);
			pstmt.setString(1, username);
			pstmt.setString(2, userpass);
			int rowInserted = pstmt.executeUpdate();
			System.out.println("Data inserted succesfully!!");
		} catch (SQLException e) {
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
		}
	}
	public ResultSet selectFromMock() {
		String SQLInsert="SELECT * FROM mock";
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(SQLInsert);
			ResultSet rs=pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			ResultSet rs=null;
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
			return rs;
		}
		
	}
	public void insertIntoCustomers(String username, String password, String name, String surname, String address) {
		String SQLInsert="Insert Into customers (username, password, name, surname, address) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(SQLInsert);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, surname);
			pstmt.setString(5, address);
			int rowInserted = pstmt.executeUpdate();
			System.out.println("Data inserted succesfully!!");
		} catch (SQLException e) {
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
		}
	}
	public ResultSet selectFromCustomers() {
		String SQLInsert="SELECT * FROM customers";
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(SQLInsert);
			ResultSet rs=pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			ResultSet rs=null;
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
			return rs;
		}
		
	}
	public ResultSet selectFromAdmins() {
		String SQLInsert="SELECT * FROM admins";
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(SQLInsert);
			ResultSet rs=pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			ResultSet rs=null;
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
			return rs;
		}
		
	}
	public ResultSet selectFromCustomersWithID(int id) {
		String SQLInsert="SELECT * FROM customers WHERE id = "+id;
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(SQLInsert);
			ResultSet rs=pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			ResultSet rs=null;
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
			return rs;
		}
		
	}
	public void updateCustomerInfo(String username, String password, String name, String surname, String address, int id) {
		String SQLInsert="UPDATE customers SET " +
                "username = ?, " +
                "password = ?, " +
                "name = ?, " +
                "surname = ?, " +
                "address = ? " +
                "WHERE id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(SQLInsert);
			pstmt.setString(1, username);
			pstmt.setString(2, password); 
			pstmt.setString(3, name);
			pstmt.setString(4, surname);
			pstmt.setString(5, address);
			pstmt.setInt(6, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
		}
	}
	public void updateCustomerInfoWithOutPass(String username, String name, String surname, String address, int id) {
		String SQLInsert="UPDATE customers SET " +
                "username = ?, " +
                "name = ?, " +
                "surname = ?, " +
                "address = ? " +
                "WHERE id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(SQLInsert);
			pstmt.setString(1, username);
			pstmt.setString(2, name); 
			pstmt.setString(3, surname);
			pstmt.setString(4, address);
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
		}
	}
	public void insertIntoBooks(String name, int price, String author, String url) {
		String SQLInsert="Insert Into books (name, price, author, url) values (?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(SQLInsert);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setString(3, author);
			pstmt.setString(4, url);
			int rowInserted = pstmt.executeUpdate();
			System.out.println("Data inserted succesfully!!");
		} catch (SQLException e) {
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
		}
	}
	public ResultSet selectFromBooks() {
		String SQLInsert="SELECT * FROM books";
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(SQLInsert);
			ResultSet rs=pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			ResultSet rs=null;
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
			return rs;
		}
	}
	public void insertIntoPurchases(int bookid, int customerid, LocalDate date) {
		String SQLInsert="Insert Into purchases (bookid, customerid, date) values (?, ?, ?)";
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(SQLInsert);
			pstmt.setInt(1, bookid);
			pstmt.setInt(2, customerid);
			pstmt.setDate(3, java.sql.Date.valueOf(date));
			int rowInserted = pstmt.executeUpdate();
			System.out.println("Data inserted succesfully!!");
		} catch (SQLException e) {
			System.out.println("Error occured while trying to connect to SQL!!");
			System.out.println(e.getMessage());
		}
	}
}
