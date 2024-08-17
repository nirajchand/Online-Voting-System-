package voting.system.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import voting.system.Database.mysqlConnection;

public class UpdatePage extends JFrame {
    private JTextField idField, nameField, fatherField, motherField, provinceField, districtField, constituencyField, partyField;
    private JButton updateButton, deleteButton;

    public UpdatePage() {
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
        name_pro.setBounds(650, 10, 500, 50);
        name_pro.setFont(new Font("Times new roman", Font.BOLD, 34));
        name_pro.setForeground(Color.white);
        titlepan.add(name_pro);

        JLabel label2 = new JLabel("House of Representatives Election");
        label2.setBounds(660, 40, 500, 50);
        label2.setFont(new Font("Times new roman", Font.BOLD, 24));
        label2.setForeground(Color.white);
        titlepan.add(label2);

        // Add components for data input
        JLabel idLabel = new JLabel("Candidate ID:");
        idLabel.setBounds(150, 150, 150, 30);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(300, 150, 300, 30);
        add(idField);

        JLabel nameLabel = new JLabel("Candidate Name:");
        nameLabel.setBounds(150, 200, 150, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(300, 200, 300, 30);
        add(nameField);

        JLabel fatherLabel = new JLabel("Father Name:");
        fatherLabel.setBounds(150, 250, 150, 30);
        add(fatherLabel);

        fatherField = new JTextField();
        fatherField.setBounds(300, 250, 300, 30);
        add(fatherField);

        JLabel motherLabel = new JLabel("Mother Name:");
        motherLabel.setBounds(150, 300, 150, 30);
        add(motherLabel);

        motherField = new JTextField();
        motherField.setBounds(300, 300, 300, 30);
        add(motherField);

        JLabel provinceLabel = new JLabel("Province:");
        provinceLabel.setBounds(150, 350, 150, 30);
        add(provinceLabel);

        provinceField = new JTextField();
        provinceField.setBounds(300, 350, 300, 30);
        add(provinceField);

        JLabel districtLabel = new JLabel("District:");
        districtLabel.setBounds(150, 400, 150, 30);
        add(districtLabel);

        districtField = new JTextField();
        districtField.setBounds(300, 400, 300, 30);
        add(districtField);

        JLabel constituencyLabel = new JLabel("Constituency:");
        constituencyLabel.setBounds(150, 450, 150, 30);
        add(constituencyLabel);

        constituencyField = new JTextField();
        constituencyField.setBounds(300, 450, 300, 30);
        add(constituencyField);

        JLabel partyLabel = new JLabel("Party:");
        partyLabel.setBounds(150, 500, 150, 30);
        add(partyLabel);

        partyField = new JTextField();
        partyField.setBounds(300, 500, 300, 30);
        add(partyField);

        // Update Button
        updateButton = new JButton("Update");
        updateButton.setBounds(300, 600, 100, 30);
        updateButton.setBackground(Color.BLUE);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Times new roman", Font.BOLD, 18));
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCandidateData();
            }
        });
        add(updateButton);

        // Delete Button
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(420, 600, 100, 30);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Times new roman", Font.BOLD, 18));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCandidateData();
            }
        });
        add(deleteButton);

        setVisible(true);
    }

    private void updateCandidateData() {
        String id = idField.getText();
        String name = nameField.getText();
        String father = fatherField.getText();
        String mother = motherField.getText();
        String province = provinceField.getText();
        String district = districtField.getText();
        String constituency = constituencyField.getText();
        String party = partyField.getText();

        mysqlConnection mysql = new mysqlConnection();
        Connection conn = mysql.openConnection();
        String sql = "UPDATE candidate SET candidate_name = ?, father_name = ?, mother_name = ?, province = ?, "
                + "district = ?, con_no = ?, party = ? WHERE national_identity_no = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, father);
            pstmt.setString(3, mother);
            pstmt.setString(4, province);
            pstmt.setString(5, district);
            pstmt.setString(6, constituency);
            pstmt.setString(7, party);
            pstmt.setString(8, id);
            pstmt.executeUpdate();
            pstmt.close();
            JOptionPane.showMessageDialog(null, "Updated successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteCandidateData() {
        String id = idField.getText();

        mysqlConnection mysql = new mysqlConnection();
        Connection conn = mysql.openConnection();
        String sql = "DELETE FROM candidate WHERE national_identity_no = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            JOptionPane.showMessageDialog(null, "Deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
