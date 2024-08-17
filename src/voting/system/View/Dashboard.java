

package voting.system.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import voting.system.Database.mysqlConnection;

public class Dashboard extends JFrame {
    private JComboBox<String> districtBox;
    private JComboBox<String> constituencyBox;

    public Dashboard() {
        setTitle("Dashboard");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel buttonpan = new JPanel();
        buttonpan.setBounds(0, 102, 145, 1080);
        buttonpan.setLayout(null);
        buttonpan.setBackground(new Color(0, 51, 153));
        add(buttonpan);

        JPanel titlepan = new JPanel();
        titlepan.setBounds(0, 0, 1770, 100);
        titlepan.setLayout(null);
        titlepan.setBackground(new Color(0, 51, 153));
        add(titlepan);

        ImageIcon logo_img = new ImageIcon(ClassLoader.getSystemResource("online/voting/system/View/Images/logopro.png"));
        Image original_logo_img = logo_img.getImage();
        Image resized_logo_img = original_logo_img.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
        ImageIcon resized_logo_Icon_img = new ImageIcon(resized_logo_img);

        JLabel logo_label_img = new JLabel(resized_logo_Icon_img);
        logo_label_img.setBounds(0, 0, 145, 120);
        titlepan.add(logo_label_img);

        JLabel name_pro = new JLabel("Election Commission Nepal");
        name_pro.setBounds(600, 10, 500, 50);
        name_pro.setFont(new Font("Times new roman", Font.BOLD, 34));
        name_pro.setForeground(Color.white);
        titlepan.add(name_pro);

        JLabel label2 = new JLabel("House of Representatives Election");
        label2.setBounds(610, 40, 500, 50);
        label2.setFont(new Font("Times new roman", Font.BOLD, 24));
        label2.setForeground(Color.white);
        titlepan.add(label2);

        JLabel label1 = new JLabel("Choose your Constituency");
        label1.setBounds(150, 120, 400, 50);
        label1.setFont(new Font("Times new roman", Font.BOLD, 32));
        add(label1);

        JLabel province_label = new JLabel("Province");
        province_label.setBounds(250, 200, 200, 50);
        province_label.setFont(new Font("Times new roman", Font.BOLD, 24));
        add(province_label);

        String[] items = {"Koshi", "Madhesh", "Bagmati", "Gandaki", "Lumbini", "Karnali", "Sudurpaschim"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(250, 250, 300, 40);
        comboBox.setBackground(Color.white);
        comboBox.setFont(new Font("times new roman", Font.BOLD, 16));
        add(comboBox);

        JLabel District_label = new JLabel("District");
        District_label.setBounds(1000, 200, 200, 50);
        District_label.setFont(new Font("Times new roman", Font.BOLD, 24));
        add(District_label);
        
        String[] district = {};
        districtBox = new JComboBox<>(district);
        districtBox.setBounds(1000, 250, 300, 40);
        districtBox.setBackground(Color.white);
        districtBox.setFont(new Font("times new roman", Font.BOLD, 16));
        add(districtBox);

        JLabel Con_label = new JLabel("Constituency");
        Con_label.setBounds(250, 440, 200, 50);
        Con_label.setFont(new Font("Times new roman", Font.BOLD, 24));
        add(Con_label);

        String[] constituency = {};
        constituencyBox = new JComboBox<>(constituency);
        constituencyBox.setBounds(250, 490, 300, 40);
        constituencyBox.setBackground(Color.white);
        constituencyBox.setFont(new Font("times new roman", Font.BOLD, 16));
        add(constituencyBox);

        JButton open_button = new JButton("Open");
        open_button.setBounds(750, 660, 100, 40);
        open_button.setBackground(Color.red);
        open_button.setForeground(Color.white);
        open_button.setBorderPainted(false);
        open_button.setFocusPainted(false);
        open_button.setFont(new Font("Times new roman", Font.BOLD, 16));

        open_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedcon = (String) constituencyBox.getSelectedItem();
                TotalCandidate totalCandidate = new TotalCandidate(selectedcon);
                totalCandidate.fetchAndUpdateCandidates(selectedcon);
            }
        });
        add(open_button);
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProvince = (String) comboBox.getSelectedItem();
                try {
                    updateDistrictComboBox(selectedProvince);
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        districtBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selecteddistrict = (String) districtBox.getSelectedItem();
                try {
                    updateconComboBox(selecteddistrict);
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        setVisible(true);
    }

    private void updateDistrictComboBox(String province) throws SQLException {
        districtBox.removeAllItems();
        mysqlConnection mysql = new mysqlConnection();
        Connection conn = mysql.openConnection();

        String query = "SELECT district_name FROM districts WHERE province_name = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, province);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String district = resultSet.getString("district_name");
                    districtBox.addItem(district);
                }
            }
        }
    }

    private void updateconComboBox(String district) throws SQLException {
        constituencyBox.removeAllItems();
        mysqlConnection mysql = new mysqlConnection();
        Connection conn = mysql.openConnection();

        String query = "SELECT con_no FROM constituency WHERE district_name = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, district);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String con = resultSet.getString("con_no");
                    constituencyBox.addItem(con);
                }
            }
        }
    }

}

    

