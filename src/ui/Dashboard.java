package ui;

import delegates.DashBoardDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private DashBoardDelegate delegate;
    private String username;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JSplitPane splitPane;
    private final CardLayout cardLayout = new CardLayout();

    public Dashboard() {
        super("Dashboard");
        initializeComponents();
    }

    private void initializeComponents() {
        // Setting up the layout for the right panel where content will be switched
        rightPanel = new JPanel(cardLayout);
        rightPanel.setBackground(Color.WHITE);

        // Setting up the left panel with buttons
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(220, 220, 220)); // A light grey color

        String[] buttonLabels = {
                "Update", "Delete", "Selection", "Projection", "Join",
                "Group By", "Group By Having", "Group By Nested", "Division"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(rightPanel, label);
                }
            });
            leftPanel.add(button);
        }

        // Initialize panels for each button
        initializePanelsForButtons(buttonLabels);

        // Creating and setting up the split pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, new JScrollPane(rightPanel));
        splitPane.setDividerLocation(150); // You can adjust this value to suit your layout
        splitPane.setDividerSize(5);

        getContentPane().add(splitPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Adjust the size as needed
        setLocationRelativeTo(null); // Center the window
    }

    private void initializePanelsForButtons(String[] buttonLabels) {
        for (String label : buttonLabels) {
            JPanel panel;
            if ("Update".equals(label)) {
                panel = createUpdatePanel();
            } else {
                panel = new JPanel();
                panel.add(new JLabel(label + " Content"));
            }
            rightPanel.add(panel, label);
        }
    }

    private JPanel createUpdatePanel() {
        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel updateSocialsLabel = new JLabel("Update Socials");
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        updatePanel.add(updateSocialsLabel, gbc);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        updatePanel.add(emailLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        updatePanel.add(emailField, gbc);

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JTextField phoneNumberField = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 2;
        updatePanel.add(phoneNumberLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        updatePanel.add(phoneNumberField, gbc);

        JLabel instaHandleLabel = new JLabel("Instagram Handle:");
        JTextField instaHandleField = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 3;
        updatePanel.add(instaHandleLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        updatePanel.add(instaHandleField, gbc);

        JButton saveChangesButton = new JButton("Save Changes");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        updatePanel.add(saveChangesButton, gbc);

        saveChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();
                String instaHandle = instaHandleField.getText();

                delegate.updateSocialPageHas(username, email, phoneNumber, instaHandle);
            }
        });

        return updatePanel;
    }

    public void showFrame(DashBoardDelegate delegate, String username) {
        this.delegate = delegate;
        this.username = username;
        setVisible(true);
    }
}
