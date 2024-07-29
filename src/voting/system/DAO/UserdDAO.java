package voting.system.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import voting.system.Model.SigninModel;
import voting.system.Model.LoginModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import voting.system.Database.mysqlConnection;

public class UserdDAO {
    private static final Logger LOGGER = Logger.getLogger(UserdDAO.class.getName());
    mysqlConnection mysql = new mysqlConnection();
    Connection conn = mysql.openConnection();
    public boolean insertSignin(SigninModel signinModel) throws SQLException {
        String query = "INSERT INTO users (Voter_id, fullname, Address, Contact, email, Password) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, signinModel.getVoter_id());
            pstmt.setString(2, signinModel.getFull_name());
            pstmt.setString(3, signinModel.getAddress());
            pstmt.setString(4, signinModel.getContact());
            pstmt.setString(5, signinModel.getEmail());
            pstmt.setString(6, signinModel.getPassword());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException occurred while inserting signin data: ", e);
            return false;
        }
    }
}
