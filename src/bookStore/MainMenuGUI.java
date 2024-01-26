package bookStore;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Oct 31 15:35:41 TRT 2023
 */



/**
 * @author s4lea
 */
public class MainMenuGUI extends JPanel {
	/**
	 * 
	 */
	

	public MainMenuGUI(int a, String b) {
		initComponents(a,b);
	}
	private JFrame getEnclosingFrame() {
        Window window = SwingUtilities.windowForComponent(this);
        if (window instanceof JFrame) {
            return (JFrame) window;
        }
        return null;
    }

	private void logOut(ActionEvent e) {
		ActionHandler act=new ActionHandler();
		act.logOutAction();
		JFrame frame=getEnclosingFrame();
		frame.dispose();
	}

	private void rentBook(ActionEvent e) {
		// TODO add your code here
	}

	private void buyBook(ActionEvent e) {
		SwingUtilities.invokeLater(() -> new BookListGUI(this.currentUser));
		JFrame frame=getEnclosingFrame();
		frame.dispose();
	}

	private void userSetting(ActionEvent e) {
		SwingUtilities.invokeLater(() -> new UserInfoEditor(this.currentUser));
		JFrame frame=getEnclosingFrame();
		frame.dispose();
	}

	private void initComponents(int a, String b) {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Ege
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItem1 = new JMenuItem();
		label2 = new JLabel();
		userLabel = new JLabel();
		idLabel = new JLabel();
		logOutButton = new JButton();
		headLabel = new JLabel();
		rentButton = new JButton();
		buyButton = new JButton();
		userSettingButton = new JButton();
		currentUserID=a;
		currentUsername=b;
		ActionHandler act=new ActionHandler();
		currentUser=act.getCurrentCustomer(currentUserID);

		//======== this ========
		setPreferredSize(new Dimension(500, 500));
		setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
		. EmptyBorder( 0, 0, 0, 0) , "Made by, Ege GENC", javax. swing. border. TitledBorder. CENTER, javax
		. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,
		12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
		. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .
		getPropertyName () )) throw new RuntimeException( ); }} );
		setLayout(new GridBagLayout());
		((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0};
		((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
		((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("Contact");

				//---- menuItem1 ----
				menuItem1.setText("gencege8@gmail.com");
				menu1.add(menuItem1);
			}
			menuBar1.add(menu1);
		}
		add(menuBar1, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 0), 0, 0));

		//---- label2 ----
		label2.setText("             ");
		add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- userLabel ----
		userLabel.setText("Username: "+currentUser.getUserName());
		add(userLabel, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.NORTHEAST, GridBagConstraints.NONE,
			new Insets(0, 0, 5, 0), 0, 0));

		//---- idLabel ----
		idLabel.setText("UserID: "+currentUserID);
		add(idLabel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 5, 0), 64, 0));

		//---- logOutButton ----
		logOutButton.setText("Logout");
		logOutButton.addActionListener(e -> logOut(e));
		add(logOutButton, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 0), 0, 0));

		//---- headLabel ----
		headLabel.setText("BookStore App");
		headLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		add(headLabel, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- rentButton ----
		rentButton.setText("Rent a book");
		rentButton.addActionListener(e -> rentBook(e));
		add(rentButton, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- buyButton ----
		buyButton.setText("Buy a book");
		buyButton.addActionListener(e -> buyBook(e));
		add(buyButton, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- userSettingButton ----
		userSettingButton.setText("User Settings");
		userSettingButton.addActionListener(e -> userSetting(e));
		add(userSettingButton, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Ege
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItem1;
	private JLabel label2;
	private JLabel userLabel;
	private JLabel idLabel;
	private JButton logOutButton;
	private JLabel headLabel;
	private JButton rentButton;
	private JButton buyButton;
	private JButton userSettingButton;
	private int currentUserID;
	private String currentUsername;
	private Customer currentUser;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

