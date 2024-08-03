package voting.system.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import voting.system.Database.mysqlConnection;

public class CandidatePage extends JFrame {

    private JTextField field1, field2, field3, field4, field5, field6, field7, field8;
    private JLabel photoLabel;
    private JPanel photo_panel;

    public CandidatePage() {
        setSize(1920, 1080);
        setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 1920, 100);
        panel1.setLayout(null);
        panel1.setBackground(new Color(0, 51, 153));
        add(panel1);

        JLabel pan_label = new JLabel("Election Commission Nepal");
        pan_label.setFont(new Font("Times new roman", Font.BOLD, 26));
        pan_label.setForeground(Color.WHITE);
        pan_label.setBounds(500, 10, 400, 40);
        panel1.add(pan_label);

        JLabel pan_label2 = new JLabel("House of Representatives Election");
        pan_label2.setBounds(505, 40, 500, 50);
        pan_label2.setFont(new Font("Times new roman", Font.BOLD, 22));
        pan_label2.setForeground(Color.white);
        panel1.add(pan_label2);

        JLabel label1 = new JLabel("National Identitiy Number");
        label1.setFont(new Font("Times new roman", Font.BOLD, 18));
        label1.setBounds(100, 150, 250, 40);
        add(label1);

        field1 = new JTextField();
        field1.setBounds(100, 200, 300, 40);
        field1.setBorder(null);
        field1.setFont(new Font("times new roman", Font.PLAIN, 18));
        add(field1);

        JLabel label2 = new JLabel("Candidate Name");
        label2.setFont(new Font("Times new roman", Font.BOLD, 18));
        label2.setBounds(100, 300, 200, 40);
        add(label2);

        field2 = new JTextField();
        field2.setBounds(100, 350, 300, 40);
        field2.setBorder(null);
        field2.setFont(new Font("times new roman", Font.PLAIN, 18));
        add(field2);

        JLabel label3 = new JLabel("Father Name");
        label3.setFont(new Font("Times new roman", Font.BOLD, 18));
        label3.setBounds(100, 450, 200, 40);
        add(label3);

        field3 = new JTextField();
        field3.setBounds(100, 500, 300, 40);
        field3.setBorder(null);
        field3.setFont(new Font("times new roman", Font.PLAIN, 18));
        add(field3);

        JLabel label4 = new JLabel("Mother Name");
        label4.setFont(new Font("Times new roman", Font.BOLD, 18));
        label4.setBounds(100, 600, 200, 40);
        add(label4);

        field4 = new JTextField();
        field4.setBounds(100, 650, 300, 40);
        field4.setBorder(null);
        field4.setFont(new Font("times new roman", Font.PLAIN, 18));
        add(field4);

        JLabel label5 = new JLabel("Province");
        label5.setFont(new Font("Times new roman", Font.BOLD, 18));
        label5.setBounds(500, 150, 200, 40);
        add(label5);

        field5 = new JTextField();
        field5.setBounds(500, 200, 300, 40);
        field5.setBorder(null);
        field5.setFont(new Font("times new roman", Font.PLAIN, 18));
        add(field5);

        JLabel label6 = new JLabel("District");
        label6.setFont(new Font("Times new roman", Font.BOLD, 18));
        label6.setBounds(500, 300, 200, 40);
        add(label6);

        field6 = new JTextField();
        field6.setBounds(500, 350, 300, 40);
        field6.setBorder(null);
        field6.setFont(new Font("times new roman", Font.PLAIN, 18));
        add(field6);

        JLabel label7 = new JLabel("Constitiuency");
        label7.setFont(new Font("Times new roman", Font.BOLD, 18));
        label7.setBounds(500, 450, 200, 40);
        add(label7);

        field7 = new JTextField();
        field7.setBounds(500, 500, 300, 40);
        field7.setBorder(null);
        field7.setFont(new Font("times new roman", Font.PLAIN, 18));
        add(field7);

        JLabel label8 = new JLabel("Party");
        label8.setFont(new Font("Times new roman", Font.BOLD, 18));
        label8.setBounds(500, 600, 200, 40);
        add(label8);

        field8 = new JTextField();
        field8.setBounds(500, 650, 300, 40);
        field8.setBorder(null);
        field8.setFont(new Font("times new roman", Font.PLAIN, 18));
        add(field8);

        JLabel label9 = new JLabel("Photo");
        label9.setFont(new Font("Times new roman", Font.BOLD, 18));
        label9.setBounds(1100, 150, 200, 40);
        add(label9);

        photo_panel = new JPanel();
        photo_panel.setBounds(1100, 200, 300, 300);
        photo_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(photo_panel);

        photoLabel = new JLabel();
        photo_panel.setLayout(new BorderLayout());
        photo_panel.add(photoLabel, BorderLayout.CENTER);

        JButton upload_button = new JButton("Upload");
        upload_button.setBounds(1120, 520, 100, 40);
        upload_button.setBackground(Color.BLUE);
        upload_button.setForeground(Color.WHITE);
        upload_button.setBorderPainted(false);
        upload_button.setFocusPainted(false);
        upload_button.setFont(new Font("times new roman", Font.BOLD, 18));
        upload_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uploadPhoto();
            }
        });
        add(upload_button);

        JButton submit_button = new JButton("Submit");
        submit_button.setBounds(1120, 600, 100, 40);
        submit_button.setBackground(Color.BLUE);
        submit_button.setForeground(Color.WHITE);
        submit_button.setBorderPainted(false);
        submit_button.setFocusPainted(false);
        submit_button.setFont(new Font("times new roman", Font.BOLD, 18));
        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveCandidateData();
            }
        });
        add(submit_button);
        
        JButton result_button = new JButton("Result");
        result_button.setBounds(1180,40,100,40);
        result_button.setBackground(Color.red);
        result_button.setForeground(Color.white);
        result_button.setBorderPainted(false);
        result_button.setFocusPainted(false);
        result_button.setFont(new Font("times new roman", Font.BOLD, 18));       
        result_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Result r = new Result();
            }
        });
        panel1.add(result_button);
        
        JButton update_button = new JButton("Update");
        update_button.setBounds(1300,40,100,40);
        update_button.setBackground(Color.red);
        update_button.setForeground(Color.white);
        update_button.setBorderPainted(false);
        update_button.setFocusPainted(false);
        update_button.setFont(new Font("times new roman", Font.BOLD, 18));       
        update_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdatePage r = new UpdatePage();
            }
        });
        panel1.add(update_button);
        
        setVisible(true);

    }

    private void uploadPhoto() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            ImageIcon icon = new ImageIcon(selectedFile.getPath());
            Image img = icon.getImage().getScaledInstance(photo_panel.getWidth(), photo_panel.getHeight(), Image.SCALE_SMOOTH);
            photoLabel.setIcon(new ImageIcon(img));
            photoLabel.putClientProperty("photoPath", path);
        }
    }

    

}

