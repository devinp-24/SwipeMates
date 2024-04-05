package ui;

import delegates.UserLoginDelegate;
import model.userModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JFrame {

    private UserLoginDelegate delegate;
    private JTextField usernameLoginField;
    private JButton loginButton;
    private JTextField usernameSignupField;
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> genderComboBox;
    private JTextArea bioText;
    private JButton signupButton;

    public UserLogin() {
        super("User Login/Sign Up");
        initializeComponents();
    }

    public void showFrame(UserLoginDelegate delegate) {
        this.delegate = delegate;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addLoginSection();
        addSectionDivider();
        addSignupSection();

        this.pack();
        this.setLocationRelativeTo(null); // Center on screen
        this.setVisible(true);
    }

    private void initializeComponents() {
        usernameLoginField = new JTextField(20);
        loginButton = new JButton("Log In");
        usernameSignupField = new JTextField(20);
        nameField = new JTextField(20);
        ageField = new JTextField(20);
        genderComboBox = new JComboBox<>(new String[]{"Gender", "Male", "Female", "Other"});
        bioText = new JTextArea(5, 20);
        signupButton = new JButton("Sign Up");
    }

    private void addLoginSection() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());

        loginPanel.add(new JLabel("Username: "));
        loginPanel.add(usernameLoginField);
        loginPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameLoginField.getText();
                System.out.println(username);
                if (delegate.checkUserId(username)) {
                    System.out.println("Exists");
                } else {
                    System.out.println("Not Exists");
                }
            }
        });

        this.add(loginPanel);
    }

    private void addSectionDivider() {
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 5));
        this.add(separator);
    }

    private void addSignupSection() {
        JPanel signupPanel = new JPanel();
        signupPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 2, 2, 2);

        signupPanel.add(new JLabel("Sign Up"), gbc);
        signupPanel.add(new JLabel("Username: "), gbc);
        signupPanel.add(usernameSignupField, gbc);
        signupPanel.add(new JLabel("Full Name: "), gbc);
        signupPanel.add(nameField, gbc);
        JLabel ageLabel = new JLabel("Age: ");
        signupPanel.add(ageLabel, gbc);
        signupPanel.add(ageField, gbc);
        signupPanel.add(new JLabel("Gender: "), gbc);
        signupPanel.add(genderComboBox, gbc);
        signupPanel.add(new JLabel("Bio: "), gbc);
        bioText.setLineWrap(true);
        bioText.setWrapStyleWord(true);
        JScrollPane bioScrollPane = new JScrollPane(bioText);
        signupPanel.add(bioScrollPane, gbc);
        signupPanel.add(signupButton, gbc);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameSignupField.getText();
                String name = nameField.getText();
                String ageText = ageField.getText();
                int age = 0;
                try {
                    age = Integer.parseInt(ageText);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(ageField, "Please enter a valid integer for age.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    ageField.requestFocus(); // Optionally, request focus back to the ageField for correction
                }
                String gender = (String) genderComboBox.getSelectedItem();
                String bio = bioText.getText();

                userModel user = new userModel(username, name, gender, bio, age);
                System.out.println(user.getUserID() + user.getAge() + user.getBio() + user.getName() + user.getGender());
                delegate.insertUser(user);
            }
        });

        this.add(signupPanel);
    }
}
