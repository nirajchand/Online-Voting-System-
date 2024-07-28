package voting.system.View;

import java.awt.*;
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

    public static void main(String[] args) {
        Signin Bp = new Signin();
    }
}
