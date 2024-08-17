package voting.system.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import voting.system.Database.mysqlConnection;

public class BallotPage extends JFrame {
    private ButtonGroup group;
    private int selectedButton = -1;
    private boolean hasVoted = false;
    private mysqlConnection dbConnection;

    public BallotPage() {
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
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("online/voting/system/View/Images/" + imagePath));
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
        BallotPage Bp = new BallotPage();
    }
}
