package bookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.JTextComponent;

public class UserInfoEditor {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField addressField;
    private JButton saveChangesButton;
    private Customer currCust;

    public UserInfoEditor(Customer currentCust) {
        frame = new JFrame("User Info Editor");
        currCust=currentCust;
        frame.setLayout(new GridLayout(6, 2));

        usernameField = createTextField(currCust.getUserName());
        passwordField = createPasswordField(null);
        nameField = createTextField(currCust.getName());
        surnameField = createTextField(currCust.getSurname());
        addressField = createTextField(currCust.getAddress());

        frame.add(new JLabel("Username:"));
        frame.add(createEditablePanel(usernameField, "Edit Username"));
        frame.add(new JLabel("Password:"));
        frame.add(createEditablePanel(passwordField, "Edit Password"));
        frame.add(new JLabel("Name:"));
        frame.add(createEditablePanel(nameField, "Edit Name"));
        frame.add(new JLabel("Surname:"));
        frame.add(createEditablePanel(surnameField, "Edit Surname"));
        frame.add(new JLabel("Address:"));
        frame.add(createEditablePanel(addressField, "Edit Address"));

        saveChangesButton = new JButton("Save Changes");
        frame.add(new JLabel()); // Placeholder for alignment
        frame.add(saveChangesButton);
        
        saveChangesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle save changes action
            	DBHandler dbhandle=new DBHandler();
            	dbhandle.connectDB("bookstore");
            	String password=new String(passwordField.getPassword());
            	if(password.isEmpty()) {
            		dbhandle.updateCustomerInfoWithOutPass(usernameField.getText(), nameField.getText(), surnameField.getText(), addressField.getText(), currCust.getID());
            		
            	}else {
            		PasswordManager pwmanager=new PasswordManager();
                    String hashpw=pwmanager.hashPassword(password);
                	dbhandle.updateCustomerInfo(usernameField.getText(),hashpw, nameField.getText(), surnameField.getText(), addressField.getText(), currCust.getID());
            	}
            	
                JOptionPane.showMessageDialog(frame, "Changes Saved!", "Info", JOptionPane.INFORMATION_MESSAGE);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    	JFrame frame = new JFrame("Main Menu");
                        MainMenuGUI mainMenu = new MainMenuGUI(currCust.getID(), currCust.getUserName()); 
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.add(mainMenu);
                        frame.pack();
                        frame.setLocationRelativeTo(null); // Center the frame on the screen
                        frame.setVisible(true);
                    }
                });
                frame.dispose();
                
            }
        });

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JTextField createTextField(String placeholder) {
        JTextField textField = new JTextField(placeholder);
        textField.setEditable(false);
        return textField;
    }

    private JPasswordField createPasswordField(String placeholder) {
        JPasswordField passwordField = new JPasswordField(placeholder);
        passwordField.setEditable(false);
        return passwordField;
    }

    private JPanel createEditablePanel(JTextComponent textComponent, String buttonText) {
        JPanel panel = new JPanel(new BorderLayout());
        JButton button = new JButton(buttonText);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textComponent.setEditable(!textComponent.isEditable());
                if (textComponent.isEditable()) {
                    textComponent.requestFocus();
                }
            }
        });

        panel.add(textComponent, BorderLayout.CENTER);
        panel.add(button, BorderLayout.EAST);

        return panel;
    }

}
