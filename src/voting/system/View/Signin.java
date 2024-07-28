package voting.system.View;

import java.awt.*;
<<<<<<< Updated upstream
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Signin extends JFrame {
    private JTextField fullname_entry;
    private JTextField Address_entry;
    private JTextField Voter_ID_entry;
    private JTextField Email_entry;
    private JTextField Phone_no_entry;
    private JTextField password_entry;
    private JTextField conform_pass_entry;
    private JButton signup_button; 
    
    public Signin() {
        setTitle("SignIn page");
        setSize(1920, 1080);
        getContentPane().setBackground(new Color(109, 156, 198));
        setLayout(null);

        ImageIcon signin_img = new ImageIcon(ClassLoader.getSystemResource("online/voting/system/View/Images/signin_bg.jpg"));
        Image original_signin_img = signin_img.getImage();
        Image resized_signin_img = original_signin_img.getScaledInstance(1600, 800, Image.SCALE_SMOOTH);
        ImageIcon resized_signin_img_icon = new ImageIcon(resized_signin_img);
        JLabel signin_img_label = new JLabel(resized_signin_img_icon);
        signin_img_label.setBounds(0, 0, 1600, 800);
        add(signin_img_label);

        JLabel top_label = new JLabel("Voter Registration");
        top_label.setFont(new Font("times new roman", Font.BOLD, 32));
        top_label.setForeground(Color.white);
        top_label.setBounds(180, 5, 300, 40);
        signin_img_label.add(top_label);

        JPanel signin_panel = new JPanel();
        signin_panel.setLayout(null);
        signin_panel.setBounds(30, 50, 500, 700);
        signin_panel.setBackground(Color.white);
        signin_img_label.add(signin_panel);

        fullname_entry = new JTextField("Full Name");
        fullname_entry.setBounds(20, 30, 300, 40);
        fullname_entry.setFont(new Font("times new roman", Font.BOLD, 18));
        fullname_entry.setBackground(new Color(217, 217, 217));
        fullname_entry.setBorder(null);
        entryAction(fullname_entry);
        signin_panel.add(fullname_entry);

        Address_entry = new JTextField("Address");
        Address_entry.setBounds(20, 90, 300, 40);
        Address_entry.setFont(new Font("times new roman", Font.BOLD, 18));
        Address_entry.setBackground(new Color(217, 217, 217));
        Address_entry.setBorder(null);
        entryAction(Address_entry);
        signin_panel.add(Address_entry);

        Voter_ID_entry = new JTextField("Voter ID");
        Voter_ID_entry.setBounds(20, 150, 300, 40);
        Voter_ID_entry.setFont(new Font("times new roman", Font.BOLD, 18));
        Voter_ID_entry.setBackground(new Color(217, 217, 217));
        Voter_ID_entry.setBorder(null);
        entryAction(Voter_ID_entry);
        signin_panel.add(Voter_ID_entry);

        Email_entry = new JTextField("Email");
        Email_entry.setBounds(20, 210, 300, 40);
        Email_entry.setFont(new Font("times new roman", Font.BOLD, 18));
        Email_entry.setBackground(new Color(217, 217, 217));
        Email_entry.setBorder(null);
        entryAction(Email_entry);
        signin_panel.add(Email_entry);

        Phone_no_entry = new JTextField("Phone Number");
        Phone_no_entry.setBounds(20, 270, 300, 40);
        Phone_no_entry.setFont(new Font("times new roman", Font.BOLD, 18));
        Phone_no_entry.setBackground(new Color(217, 217, 217));
        Phone_no_entry.setBorder(null);
        entryAction(Phone_no_entry);
        signin_panel.add(Phone_no_entry);

        password_entry = new JTextField ("Password");
        password_entry.setBounds(20, 330, 300, 40);
        password_entry.setFont(new Font("times new roman", Font.BOLD, 18));
        password_entry.setBackground(new Color(217, 217, 217));
        password_entry.setBorder(null);
        entryAction(password_entry);
        signin_panel.add(password_entry);

        conform_pass_entry = new JTextField ("Conform Password");
        conform_pass_entry.setBounds(20, 390, 300, 40);
        conform_pass_entry.setFont(new Font("times new roman", Font.BOLD, 18));
        conform_pass_entry.setBackground(new Color(217, 217, 217));
        conform_pass_entry.setBorder(null);
        entryAction(conform_pass_entry);
        signin_panel.add(conform_pass_entry);

        signup_button = new JButton("Register");
        signup_button.setBounds(120, 480, 100, 40);
        signup_button.setBackground(Color.blue);
        signup_button.setForeground(Color.white);
        signup_button.setBorderPainted(false);
        signup_button.setFocusPainted(false);
        signup_button.setFont(new Font("Times new roman", Font.BOLD, 18));
        
        signin_panel.add(signup_button);

        JButton button = new JButton("Already have a account?");
        button.setBounds(20, 540, 300, 40);
        button.setForeground(Color.BLACK);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(Color.white);
        button.setFont(new Font("times new roman", Font.PLAIN, 20));
        
        setVisible(true);
    }

    
    final void entryAction(JTextField a) {
        String defaultText = a.getText();
        a.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a.setText("");
            }
        });

        a.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (a.getText().isEmpty()) {
                    a.setText(defaultText);
                }
            }
        });
    }

    public JTextField getFullname_entry() {
        return fullname_entry;
    }

    public void setFullname_entry(JTextField fullname_entry) {
        this.fullname_entry = fullname_entry;
    }

    public JTextField getAddress_entry() {
        return Address_entry;
    }

    public void setAddress_entry(JTextField Address_entry) {
        this.Address_entry = Address_entry;
    }

        public JTextField getVoter_ID_entry() {
        return Voter_ID_entry;
    }

    public void setVoter_ID_entry(JTextField Voter_ID_entry) {
        this.Voter_ID_entry = Voter_ID_entry;
    }

    public JTextField getEmail_entry() {
        return Email_entry;
    }

    public void setEmail_entry(JTextField Email_entry) {
        this.Email_entry = Email_entry;
    }

    public JTextField getPhone_no_entry() {
        return Phone_no_entry;
    }

    public void setPhone_no_entry(JTextField Phone_no_entry) {
        this.Phone_no_entry = Phone_no_entry;
    }

    public JTextField getPassword_entry() {
        return password_entry;
    }

    public void setPassword_entry(JTextField  password_entry) {
        this.password_entry = password_entry;
    }

    public JTextField getConform_pass_entry() {
        return conform_pass_entry;
    }

    public void setConform_pass_entry(JTextField  conform_pass_entry) {
        this.conform_pass_entry = conform_pass_entry;
    }

    public void addRegisterButtonListener(ActionListener listener) {
        signup_button.addActionListener(listener);

    }

    public void setMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
=======
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import voting.system.Database.mysqlConnection;

public class Signin extends JFrame {
    private ButtonGroup group;
    private int selectedButton = -1;
    private boolean hasVoted = false;
    private mysqlConnection dbConnection;

    public Signin() {
        dbConnection = new mysqlConnection();

        setSize(1920, 1080);
        setLayout(null);

        JLabel label1 = new JLabel("Election of House of Representatives");
        label1.setForeground(Color.black);
        label1.setBounds(500, 10, 500, 40);
        label1.setFont(new Font("times new roman", Font.BOLD, 28));
        add(label1);

        JLabel label2 = new JLabel("Election commission of Nepal");
        label2.setForeground(Color.black);
        label2.setBounds(100, 80, 400, 40);
        label2.setFont(new Font("times new roman", Font.BOLD, 22));
        add(label2);

        JLabel label3 = new JLabel("Date: 2081/12/30");
        label3.setForeground(Color.black);
        label3.setBounds(100, 120, 400, 40);
        label3.setFont(new Font("times new roman", Font.BOLD, 22));
        add(label3);

        JButton final_button = new JButton("Vote");
        final_button.setFont(new Font("times new roman", Font.BOLD, 22));
        final_button.setBounds(1200, 600, 150, 40);
        final_button.setBackground(Color.red);
        final_button.setForeground(Color.white);
        final_button.setFocusPainted(false);
        add(final_button);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(400, 200, 610, 550);
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
        panel1.setBorder(lineBorder);
        panel1.setBackground(Color.WHITE); // Ensure background color for visibility
        add(panel1);

        JLabel label4 = new JLabel("Ballot Paper");
        label4.setBounds(250, 3, 200, 20);
        label4.setFont(new Font("times new roman", Font.BOLD, 22));
        panel1.add(label4);

        group = new ButtonGroup();

        createRadioButton(panel1, "Congress", "Congrass.jpg", 30, 50, 0);
        createRadioButton(panel1, "Yemale", "Yemale.jpg", 230, 50, 1);
        createRadioButton(panel1, "Maubadi", "Maubadi.png", 430, 50, 2);
        createRadioButton(panel1, "RSP", "RastriyaSwatantraParty.jpg", 30, 200, 3);
        createRadioButton(panel1, "RPP", "prajatantra party.jpg", 230, 200, 4);
        createRadioButton(panel1, "LSP", "Loktantric samajwadi party.jpg", 430, 200, 5);
        createRadioButton(panel1, "NSP", "nepal samjwadi party.jpg", 30, 350, 6);
        createRadioButton(panel1, "MKP", "Majdoor kishan party.jpg", 230, 350, 7);
        createRadioButton(panel1, "JP", "Janmat party.png", 430, 350, 8);

        final_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hasVoted) {
                    JOptionPane.showMessageDialog(null, "You have already voted.");
                } else if (selectedButton != -1) {
                    hasVoted = true;
                    disableRadioButtons();
                    saveVoteToDatabase(selectedButton);
                    System.out.println("Vote counted for party index: " + selectedButton);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a party before voting.");
                }
            }
        });

        setVisible(true);
    }

    private void createRadioButton(JPanel panel, String label, String imagePath, int x, int y, int index) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("voting/system/View/Images/" + imagePath));
        Image originalImage = icon.getImage();
        Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JRadioButton radioButton = new JRadioButton(label, resizedIcon);
        radioButton.setBounds(x, y, 200, 100);
        radioButton.setHorizontalTextPosition(SwingConstants.RIGHT); // Text to the right of the icon
        radioButton.setVerticalTextPosition(SwingConstants.CENTER); // Center the text vertically
        radioButton.setOpaque(true);
        radioButton.setBackground(Color.WHITE); // Ensure the background is visible

        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedButton = index;
                System.out.println("Button " + index + " selected");
            }
        });

        group.add(radioButton);
        panel.add(radioButton);
    }

    private void disableRadioButtons() {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            button.setEnabled(false);
        }
    }

    private void saveVoteToDatabase(int partyIndex) {
        Connection conn = dbConnection.openConnection();
        if (conn != null) {
            String query = "UPDATE parties SET votes = votes + 1 WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, partyIndex + 1); // Assuming partyIndex is 0-based
                pstmt.executeUpdate();
                System.out.println("Vote saved to database for party index: " + partyIndex);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                dbConnection.closeConnection(conn);
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }

    public static void main(String[] args) {
        Signin Bp = new Signin();
    }
>>>>>>> Stashed changes
}
