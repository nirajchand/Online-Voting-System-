package voting.system.View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import voting.system.Database.mysqlConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Result extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public Result() {
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

        // Table setup
        String[] columnNames = {"Party Name", "Total Votes"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setRowHeight(40); // Increase row height

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 150, 1000, 800);
        add(scrollPane);

        // Fetch data and populate the table
        fetchDataAndPopulateTable();

        setVisible(true);
    }

    private void fetchDataAndPopulateTable() {
        String sql = "SELECT name, votes FROM parties"; 
        mysqlConnection mysql = new mysqlConnection();
        Connection conn = mysql.openConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        List<Object[]> data = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String partyName = rs.getString("name");
                int totalVotes = rs.getInt("votes");
                data.add(new Object[]{partyName, totalVotes});
            }

            // Sort data by total votes in decreasing order
            Collections.sort(data, new Comparator<Object[]>() {
                @Override
                public int compare(Object[] o1, Object[] o2) {
                    return Integer.compare((int) o2[1], (int) o1[1]);
                }
            });

            // Add sorted data to the table model
            for (Object[] row : data) {
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
