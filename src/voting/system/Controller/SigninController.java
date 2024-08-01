package voting.system.Controller;

import voting.system.Model.SigninModel;
import voting.system.DAO.UserdDAO;
import voting.system.View.Signin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SigninController {
    private final Signin signin;
    private final UserdDAO userdao;

    public SigninController(Signin signinin, UserdDAO userdao) {
        this.signin = signinin;
        this.userdao = userdao;


        this.signin.addRegisterButtonListener(new RegisterButtonListener());
    }

    class RegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fullName = signin.getFullname_entry().getText();
            String address = signin.getAddress_entry().getText();
            String voterId = signin.getVoter_ID_entry().getText();
            String email = signin.getEmail_entry().getText();
            String contact = signin.getPhone_no_entry().getText();
            String password = signin.getPassword_entry().getText();
            String confirmPassword = signin.getConform_pass_entry().getText();

            if (!password.equals(confirmPassword)) {
                signin.setMessage("Passwords do not match!");
                return;
            }

            SigninModel signinmodel = new SigninModel( fullName, address, voterId, email, contact, password, confirmPassword);
            boolean isRegistered = true;
            try{
                isRegistered = userdao.insertSignin(signinmodel);
            }catch(SQLException ex){
                System.out.println(ex);
            }

            if (isRegistered){
                signin.setMessage("Registration successful!");
            } else {
                signin.setMessage("Registration failed. Please try again.");
            }
        }
    }

}