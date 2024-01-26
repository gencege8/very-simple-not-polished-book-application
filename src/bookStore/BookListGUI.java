package bookStore;

import java.time.LocalDate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;

public class BookListGUI {
	Customer currentCustomer;
	JPanel mainPanel;
	JPanel bookPanel;
	ImagePanel bookImageLabel;
	JLabel bookNameLabel;
	JButton bookButton;
	JFrame frame;
	ArrayList<Book> bookList=new ArrayList<>();
	ActionHandler action=new ActionHandler();
	
	public BookListGUI(Customer currentCustomer) {
		bookList=action.returnBooksAsArrayList();
		this.currentCustomer=currentCustomer;
		int columns=3;
		int sizeBooks=bookList.size();
		int rows=(sizeBooks/3)+1;
		mainPanel=new JPanel(new GridLayout(rows, columns));
		for(Book book : bookList) {
			bookPanel=new JPanel(new BorderLayout());
			BufferedImage bookImage=action.createBufferedImageFromURL(book.getURL());
			bookImageLabel=new ImagePanel(bookImage);
			bookImageLabel.setPreferredSize(new Dimension(480,320));
			bookPanel.add(bookImageLabel, BorderLayout.NORTH);
			bookNameLabel = new JLabel(book.getName());
			bookPanel.add(bookNameLabel, BorderLayout.CENTER);
			bookButton = new JButton("Buy");
			bookButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	LocalDate currDate=LocalDate.now();
	            	action.purchaseAction(book.getID(), currentCustomer.getID(), currDate);
	            }
	        });
			bookPanel.add(bookButton, BorderLayout.SOUTH);
			mainPanel.add(bookPanel);
		}
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frame=new JFrame("Buy Books");
		frame.add(scrollPane);
		frame.setSize(800,600);
		frame.setVisible(true);
	}

}
