package voting.system.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import voting.system.Database.mysqlConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TotalCandidate extends JFrame {
    private JPanel candidatePanel;
    private Set<String> displayedCandidates = new HashSet<>(); // To track displayed candidates

    public TotalCandidate(String con_no) {
        setTitle("Total Candidates");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JLabel label2 = new JLabel("House of Representatives Election");
        label2.setBounds(505, 40, 500, 50);
        label2.setFont(new Font("Times new roman", Font.BOLD, 22));
        label2.setForeground(Color.white);
        panel1.add(label2);

        candidatePanel = new JPanel();
        candidatePanel.setLayout(new BoxLayout(candidatePanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(candidatePanel);
        scrollPane.setBounds(0, 100, 1920, 880);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        JButton vote_button = new JButton("Vote");
        vote_button.setBounds(1250, 30, 100, 40);
        vote_button.setBackground(Color.red);
        vote_button.setForeground(Color.white);
        vote_button.setBorderPainted(false);
        vote_button.setFocusPainted(false);
        vote_button.setFont(new Font("Times new roman", Font.BOLD, 18));
        panel1.add(vote_button);
        vote_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BallotPage();
                dispose();
            }
        });

        fetchAndUpdateCandidates(con_no);

        setVisible(true);
    }

    public ArrayList<String[]> fetchCandidateData(String con_no) {
        ArrayList<String[]> candidateDataList = new ArrayList<>();
        String sql = "SELECT DISTINCT national_identity_no, candidate_name, province, district, party, photo FROM candidate WHERE con_no = ?";
        mysqlConnection mysql = new mysqlConnection();
        Connection conn = mysql.openConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, con_no);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] data = new String[6];
                data[0] = rs.getString("national_identity_no");
                data[1] = rs.getString("candidate_name");
                data[2] = rs.getString("province");
                data[3] = rs.getString("district");
                data[4] = rs.getString("party");
                data[5] = rs.getString("photo");
                candidateDataList.add(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return candidateDataList;
    }

    public void fetchAndUpdateCandidates(String con_no) {
        ArrayList<String[]> candidateDataList = fetchCandidateData(con_no);
        for (String[] data : candidateDataList) {
            if (displayedCandidates.add(data[0])) { 
                updateCandidatePanel(candidatePanel, data);
            }
        }
    }
    
    public void updateCandidatePanel(JPanel panel, String[] data) {
        JPanel candidateInfoPanel = new JPanel();
        candidateInfoPanel.setLayout(null);
        candidateInfoPanel.setPreferredSize(new Dimension(1920, 300));
        candidateInfoPanel.setBorder(new LineBorder(Color.BLACK, 1));

        JLabel photoLabel = new JLabel();
        photoLabel.setBounds(5, 10, 250, 250);
        candidateInfoPanel.add(photoLabel);

        JLabel can_label = new JLabel("Name: " + data[1]);
        can_label.setBounds(270, 10, 200, 30);
        can_label.setFont(new Font("times new roman", Font.BOLD, 18));
        candidateInfoPanel.add(can_label);

        JLabel label1 = new JLabel("National ID: " + data[0]);
        label1.setBounds(270, 50, 200, 30);
        label1.setFont(new Font("times new roman", Font.BOLD, 18));
        candidateInfoPanel.add(label1);

        JLabel label3 = new JLabel("Address: " + data[2] + ", " + data[3]);
        label3.setBounds(270, 90, 400, 30);
        label3.setFont(new Font("times new roman", Font.BOLD, 18));
        candidateInfoPanel.add(label3);

        JLabel label4 = new JLabel("Party: " + data[4]);
        label4.setBounds(270, 130, 200, 30);
        label4.setFont(new Font("times new roman", Font.BOLD, 18));
        candidateInfoPanel.add(label4);

        try {
            BufferedImage img = ImageIO.read(new File(data[5]));
            ImageIcon icon = new ImageIcon(img.getScaledInstance(250, 250, Image.SCALE_SMOOTH));
            photoLabel.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        panel.add(candidateInfoPanel);
        panel.revalidate();
        panel.repaint();
    }
}
