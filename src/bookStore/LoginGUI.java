package bookStore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginGUI {

    private JFrame frame;
    private JPanel panel;
    private JLabel entranceLabel;
    private JLabel userLabel;
    private JLabel e1;
    private JTextField userText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JButton registerButton;
    private JButton bookRegisterButton;
    private JLabel statusLabel;
    private int currentCustomerID=15;
    public LoginGUI() {
        frame = new JFrame("Project BookStore");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        //Entrence Label
        entranceLabel=new JLabel("Welcome to Book Store App");
        constraints.gridx=2;
        constraints.gridy=0;
        panel.add(entranceLabel,constraints);
        
        //seemless space
        e1=new JLabel("");
        constraints.gridx=2;
        constraints.gridy=1;
        panel.add(e1,constraints);

        // Username Label
        userLabel = new JLabel("Username:");
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(userLabel, constraints);

        // Username Text Field
        userText = new JTextField(20);
        constraints.gridx = 2;
        constraints.gridy = 2;
        panel.add(userText, constraints);

        // Password Label
        passwordLabel = new JLabel("Password:");
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(passwordLabel, constraints);

        // Password Text Field
        passwordText = new JPasswordField(20);
        constraints.gridx = 2;
        constraints.gridy = 3;
        panel.add(passwordText, constraints);

        // Login Button
        loginButton = new JButton("Login");
        constraints.gridx = 2;
        constraints.gridy = 4;
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                ActionHandler action=new ActionHandler();
                int[] results=action.loginAction(username, password);
                if (results[0]==1) {
                	statusLabel.setText("Login Successful! User ID: "+ results[1]);
                	currentCustomerID=results[1];
                	SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                        	JFrame frame = new JFrame("Main Menu");
                            MainMenuGUI mainMenu = new MainMenuGUI(currentCustomerID, username); 
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.add(mainMenu);
                            frame.pack();
                            frame.setLocationRelativeTo(null); // Center the frame on the screen
                            frame.setVisible(true);
                        }
                    });
                	frame.dispose();
                	
                }else if(results[0]==2) {
                	statusLabel.setText("Admin login detected! ID: " + results[1]);
                }else {
                	statusLabel.setText("Login Failed!");
                }
                
                
            }
        });
        panel.add(loginButton, constraints);
        registerButton = new JButton("Register");
        constraints.gridx = 3;
        constraints.gridy = 4;
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new RegisterGUI();
                    }
                });
            }
        });
        panel.add(registerButton, constraints);
        
        bookRegisterButton = new JButton("Book Register");
        constraints.gridx = 4;
        constraints.gridy = 4;
        bookRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    	BookRegistration bookReg = new BookRegistration();
                        bookReg.setVisible(true);
                    }
                });
            }
        });
        panel.add(bookRegisterButton, constraints);

        // Status Label
        statusLabel = new JLabel("");
        constraints.gridx = 2;
        constraints.gridy = 5;
        panel.add(statusLabel, constraints);

        frame.setVisible(true);
     }
    public int getCurrentCustomerID() {
    	return this.currentCustomerID;
    }
    
}    

