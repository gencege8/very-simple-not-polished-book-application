package bookStore;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class ActionHandler {
	
	public ActionHandler() {	
	}
	public int[] loginAction(String username, String password){
		DBHandler testConnection=new DBHandler();
        testConnection.connectDB("bookstore");
        int flag=0;
        int id=0;
        ResultSet rs=testConnection.selectFromCustomers();
        //if flag is 1 it means Customer if its 2 it means Admin. 0 means no such user.
        try {
			while(rs.next()) {
				String uname=rs.getString("username");
				String pass=rs.getString("password");
				PasswordManager pwmanager=new PasswordManager();
				if (uname.equals(username) && pwmanager.checkPassword(password, pass)) {
                    flag=1;
                    id=rs.getInt("id");
                    break;
                } else {
                	ResultSet rs1=testConnection.selectFromAdmins();
                    while (rs1.next()) {
                    	String uname1=rs1.getString("username");
        				String pass1=rs1.getString("password");
        				PasswordManager pwmanager1=new PasswordManager();
        				if (uname1.equals(username) && pwmanager1.checkPassword(password, pass1)) {
                            flag=2;
                            id=rs1.getInt("id");
                            break;
                        } else {
                        	flag=0;
                        }
                    }
                }
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return new int[] {flag,id};
        
	}
	public void registerAction(String username, String password, String name, String surname, String address) {
		PasswordManager pwmanager=new PasswordManager();
        String hashpw=pwmanager.hashPassword(password);

        DBHandler testConnection=new DBHandler();
		testConnection.connectDB("bookstore");
		testConnection.insertIntoCustomers(username, hashpw, name, surname, address);
	}
	public void logOutAction() {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI();
            }
        });
	}
	public Customer getCurrentCustomer(int id) {
		ResultSet rs;
		DBHandler testConnection=new DBHandler();
        testConnection.connectDB("bookstore");
        rs=testConnection.selectFromCustomersWithID(id);
        Customer currentCust=new Customer(0,"null","null","null","null","null");
        try {
        	while(rs.next()) {
        		int idusr=rs.getInt("id");
        		String username=rs.getString("username");
        		String password=rs.getString("password");
        		String name=rs.getString("name");
        		String surname=rs.getString("surname");
        		String address=rs.getString("address");
        		currentCust=new Customer(idusr,username,password,name,surname,address);
        	}
        }catch(SQLException e1){
        	e1.printStackTrace();
        }
        return currentCust;
	}
	public void registerBook(String name, int price, String author, String url) {
		DBHandler db=new DBHandler();
		db.connectDB("bookstore");
		db.insertIntoBooks(name, price, author, url);
	}
	public ArrayList<Book> returnBooksAsArrayList() {
		ArrayList<Book> toBeReturned=new ArrayList<>();
		ResultSet rs;
		DBHandler testConnection=new DBHandler();
        testConnection.connectDB("bookstore");
        rs=testConnection.selectFromBooks();
        try {
        	while(rs.next()) {
        		int idBook=rs.getInt("id");
        		String bookName=rs.getString("name");
        		int price=rs.getInt("price");
        		String author=rs.getString("author");
        		String imgUrl=rs.getString("url");
        		Book tempBook=new Book();
        		tempBook.setID(idBook);
        		tempBook.setName(bookName);
        		tempBook.setPrice(price);
        		tempBook.setAuthor(author);
        		URL a;
				try {
					a = new URL(imgUrl);
					tempBook.setURL(a);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				toBeReturned.add(tempBook);
        		
        	}
        }catch(SQLException e1){
        	e1.printStackTrace();
        }
       return toBeReturned; 
	}
	public BufferedImage createBufferedImageFromURL(URL url) {
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception accordingly
        }
        return null; // Return null if the image couldn't be read
    }
	public void purchaseAction(int bookid, int customerid, LocalDate date) {
		DBHandler db=new DBHandler();
		db.connectDB("bookstore");
		db.insertIntoPurchases(bookid, customerid, date);
	}
}
