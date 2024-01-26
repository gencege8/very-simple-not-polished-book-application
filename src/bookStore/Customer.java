package bookStore;

public class Customer {
	
	private int ID;
	private String userName;
	private String password;
	private String name;
	private String surname;
	private String address;
	
	public Customer(int id, String userName, String password, String name, String surname, String address) {
		this.ID=id;
		this.userName=userName;
		this.password=password;
		this.name=name;
		this.surname=surname;
		this.address=address;
		
	}
	
	// ID
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	// userName
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// password
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// surname
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	// address
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
