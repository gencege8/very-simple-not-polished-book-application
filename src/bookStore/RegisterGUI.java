package bookStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterGUI {

    private JFrame frame;
    private JTextField usernameField, nameField, surnameField, addressField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterGUI() {
        frame = new JFrame("Registration");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        // Labels
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel surnameLabel = new JLabel("Surname:");
        JLabel addressLabel = new JLabel("Address:");

        // Text Fields
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        nameField = new JTextField();
        surnameField = new JTextField();
        addressField = new JTextField();

        // Button
        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String name = nameField.getText();
                String surname = surnameField.getText();
                String address = addressField.getText();
            	ActionHandler regisHandle=new ActionHandler();
                if (username.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                	regisHandle.registerAction(username, password, name, surname, address);
                    JOptionPane.showMessageDialog(frame, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                }
            }
        });

        // Add components to frame
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(surnameLabel);
        frame.add(surnameField);
        frame.add(addressLabel);
        frame.add(addressField);
        frame.add(new JLabel()); // Placeholder
        frame.add(registerButton);

        frame.setVisible(true);
    }
}
