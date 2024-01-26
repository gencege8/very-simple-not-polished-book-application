package bookStore;

import java.net.URL;

public class Book {
	
	private String name;
	private int ID;
	private float price;
	private String author;
	private URL imgUrl;
	
	
	public void setName(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for ID
    public int getID() {
        return ID;
    }
    //Setter for ID
    public void setID(int id) {
        this.ID=id;
    }

    // Setter for price
    public void setPrice(float price) {
        this.price = price;
    }

    // Getter for price
    public float getPrice() {
        return price;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }
    public void setURL(URL a) {
    	this.imgUrl=a;
    }
    public URL getURL() {
    	return imgUrl;
    }

}
