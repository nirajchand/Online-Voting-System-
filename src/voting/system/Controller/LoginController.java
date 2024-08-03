package voting.system.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import voting.system.View.LogIn;
import voting.system.DAO.UserdDAO;
import voting.system.Model.LoginModel;
import voting.system.View.Dashboard;
import voting.system.View.CandidatePage;

public class LoginController {
    private final UserdDAO userdao;
    private final LogIn login;

    public LoginController(UserdDAO userdao, LogIn login) {
        this.userdao = userdao;
        this.login = login;

        this.login.LoginButton(new loginButtonListener());
    }

    class loginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String voter_ID = login.getVoterID_entry().getText().trim();
            String password = login.getPassword_entry().getText().trim();


            String adminVoterID = "10";
            String adminPassword = "admin10";

            if (adminVoterID.equals(voter_ID) && adminPassword.equals(password)) {

                CandidatePage adminDashboard = new CandidatePage();
                adminDashboard.setVisible(true);
            } else {
                LoginModel loginmodel = new LoginModel(voter_ID, password);
                boolean isRegularUser = false;
                try {
                    isRegularUser = userdao.getdata(loginmodel);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (isRegularUser) {
                    Dashboard dashboard = new Dashboard();
                    dashboard.setVisible(true);

                } else {
                    login.setMessage("Login failed.");
                }
            }
        }
    }
}