/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package voting.system.Model;

/**
 *
 * @author User
 */
public class LoginModel {
    private String Voter_Id;
    private String Password; 

    public LoginModel(String Voter_id, String Password){
        this.Voter_Id = Voter_id;
        this.Password = Password;
    }

    public String getVoter_Id() {
        return Voter_Id;
    }

    public void setVoter_Id(String Voter_Id) {
        this.Voter_Id = Voter_Id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}