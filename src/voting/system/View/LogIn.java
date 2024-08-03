package voting.system.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Login extends JFrame {
public class LogIn extends JFrame {
    
    private JTextField voterID_entry;
    private JTextField password_entry;
    private JButton logButton; 

    public Login(){
    public LogIn(){
        setSize(1920,1080);
        setTitle("Login page");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon login_bg = new ImageIcon(ClassLoader.getSystemResource("online/voting/system/View/Images/login_bg.jpg"));
        Image Original_login_bg = login_bg.getImage();
        Image resized_login_bg = Original_login_bg.getScaledInstance(1000, 1080, Image.SCALE_SMOOTH);
        ImageIcon resized_login_bg_Icon = new ImageIcon(resized_login_bg);
        JLabel login_bg_label = new JLabel(resized_login_bg_Icon);
        login_bg_label.setBounds(0,0,1000,1080);
        add(login_bg_label);

        JPanel Login_pan = new JPanel();
        Login_pan.setBounds(1000,0,920,1080);
        Login_pan.setBackground(new Color(150,200,250));
        Login_pan.setLayout(null);
        add(Login_pan);

        JLabel login = new JLabel("LogIn");
        login.setBounds(250,10,100,35);
        login.setForeground(Color.BLACK);
        login.setFont(new Font("Times new roman",Font.BOLD,30));
        Login_pan.add(login);

        
        JLabel VoterID = new JLabel("Voter ID");
        VoterID.setBounds(80,150,100,35);
        VoterID.setForeground(Color.BLACK);
        VoterID.setFont(new Font("Times new roman",Font.BOLD,22));
        Login_pan.add(VoterID);

        voterID_entry = new JTextField();
        voterID_entry.setBounds(80,200,300,30);
        voterID_entry.setFont(new Font("Times new roman",Font.PLAIN,18));
        voterID_entry.setForeground(Color.BLACK);
        voterID_entry.setBackground(new Color(204, 204, 255));
        voterID_entry.setBorder(null);
        Login_pan.add(voterID_entry);

        JLabel Password = new JLabel("Password");
        Password.setBounds(80,270,100,35);
        Password.setForeground(Color.BLACK);
        Password.setFont(new Font("Times new roman",Font.BOLD,22));
        Login_pan.add(Password);

        password_entry = new JPasswordField();
        password_entry.setBounds(80,320,300,30);
        password_entry.setFont(new Font("Times new roman",Font.PLAIN,18));
        password_entry.setForeground(Color.black);
        password_entry.setBackground(new Color(204, 204, 255));
        password_entry.setBorder(null);
        Login_pan.add(password_entry);

        logButton = new JButton();
        logButton.setText("LogIn");
        logButton.setForeground(Color.white);
        logButton.setBackground(Color.BLUE);
        logButton.setBounds(250,400,100,40);
        logButton.setFont(new Font("Times new roman",Font.BOLD,22));
        logButton.setBorderPainted(false);
        logButton.setFocusPainted(false);
        Login_pan.add(logButton);

        JButton create_account = new JButton("Create new account?");
        create_account.setBounds(30,500,300,20);
        create_account.setBackground(new Color(150,200,250));
        create_account.setBorderPainted(false);
        create_account.setFocusPainted(false);
        

        JButton forgot_Password = new JButton("Forgot Password");
        forgot_Password.setBounds(20,530,300,20);
        forgot_Password.setBackground(new Color(150,200,250));
        forgot_Password.setBorderPainted(false);
        forgot_Password.setFocusPainted(false);
        Login_pan.add(forgot_Password);
        
        setVisible(true);
    }

    public JTextField getVoterID_entry() {
        return voterID_entry;
    }

    public void setVoterID_entry(JTextField voterID_entry) {
        this.voterID_entry = voterID_entry;
    }

    public JTextField getPassword_entry() {
        return password_entry;
    }

    public void setPassword_entry(JTextField password_entry) {
        this.password_entry = password_entry;
    }

    public void LoginButton(ActionListener listener) {
        logButton.addActionListener(listener);
    }

    public void setMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
