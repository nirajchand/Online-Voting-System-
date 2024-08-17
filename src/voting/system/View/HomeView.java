package voting.system.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;


public class HomeView extends JFrame {
    public HomeView(){
        setTitle("Homepage");
        setSize(1920,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        ImageIcon bg_image = new ImageIcon(ClassLoader.getSystemResource("online/voting/system/View/Images/bg.jpg"));
        Image original_bg = bg_image.getImage();
        Image resized_bg = original_bg.getScaledInstance(1550, 600, Image.SCALE_SMOOTH);
        ImageIcon resized_bgIcon = new ImageIcon(resized_bg);

        JLabel bg_label = new JLabel(resized_bgIcon);
        bg_label.setBounds(0,130,1550,600);
        add(bg_label);

        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("online/voting/system/View/Images/logopro.png"));
        Image original_logo = logo.getImage();
        Image resized_logo = original_logo.getScaledInstance(130,130,Image.SCALE_SMOOTH);
        ImageIcon resized_logo_Icon = new ImageIcon(resized_logo);

        JLabel logo_label = new JLabel(resized_logo_Icon);
        logo_label.setBounds(0,0,130,130);
        add(logo_label);

        JLabel name = new JLabel("Election Commission Nepal");
        name.setBounds(500,10,500,50);
        name.setFont(new Font("Times new roman",Font.BOLD, 34));
        name.setForeground(Color.red);
        add(name);

        JLabel Address = new JLabel("Kantipath, Kathmandu");
        Address.setBounds(570,60,500,30);
        Address.setFont(new Font("Times new roman",Font.BOLD, 24));
        Address.setForeground(Color.gray);
        add(Address);
        

        JPanel top_pan = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
        top_pan.setBackground(Color.red); 
        top_pan.setBounds(130, 90, 1410, 50);
        top_pan.setLayout(null);
        add(top_pan);

        JLabel walkingText = new JLabel("Welcome to Election Commission Nepal");
        walkingText.setFont(new Font("Times New Roman", Font.BOLD, 20));
        walkingText.setForeground(Color.WHITE);
        walkingText.setBounds(0,5, walkingText.getPreferredSize().width, walkingText.getPreferredSize().height);
        top_pan.add(walkingText);


        JButton NoticeBotton = new JButton("Notice");
        NoticeBotton.setBackground(Color.red);
        NoticeBotton.setForeground(Color.white);
        NoticeBotton.setBorderPainted(false);
        NoticeBotton.setFocusPainted(false);
        NoticeBotton.setBounds(1000,30,100,40);
        NoticeBotton.setFont(new Font("Times new Roman",Font.BOLD,22));
        add(NoticeBotton);

        
        JButton SigninButton = new JButton("SignIn");
        SigninButton.setBackground(Color.red);
        SigninButton.setForeground(Color.white);
        SigninButton.setBorderPainted(false);
        SigninButton.setFocusPainted(false);
        SigninButton.setBounds(1200,30,100,40);
        SigninButton.setFont(new Font("Times new Roman",Font.BOLD,22));
        add(SigninButton);
       

        JButton LoginButton = new JButton("LogIn");
        LoginButton.setBackground(Color.red);
        LoginButton.setForeground(Color.white);
        LoginButton.setBorderPainted(false);
        LoginButton.setFocusPainted(false);
        LoginButton.setBounds(1400,30,100,40);
        LoginButton.setFont(new Font("Times new Roman",Font.BOLD,22));
        add(LoginButton);
      
        
        
        
        
        JPanel Buttom_pan = new JPanel();
        Buttom_pan.setBounds(0,730,1700,70);
        Buttom_pan.setBackground(Color.red);
        add(Buttom_pan);

        JLabel Contact = new JLabel("Contact us. electioncommission3.edu.np");
        Contact.setBounds(200,10,300,30);
        Contact.setFont(new Font("Times new roman",Font.BOLD,22));
        Contact.setForeground(Color.white);
        Buttom_pan.add(Contact);
        
        setVisible(true);
        
    }

}
    


