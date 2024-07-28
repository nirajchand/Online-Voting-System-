package voting.system.Model;

public class SigninModel {
    private String full_name;
    private String Address;
    private String Voter_id;
    private String email;
    private String Contact;
    private String Password;
    private String Confrom_password;

    public SigninModel(String full_name, String Address, String Voter_id, String email, String contact,String Password, String Conform_password){
        this.full_name = full_name;
        this.Voter_id = Voter_id;
        this.Address = Address;
        this.Contact = contact;
        this.email = email;
        this.Password = Password;
        this.Confrom_password = Conform_password;

    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getVoter_id() {
        return Voter_id;
    }

    public void setVoter_id(String Voter_id) {
        this.Voter_id = Voter_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getConfrom_password() {
        return Confrom_password;
    }

    public void setConfrom_password(String Confrom_password) {
        this.Confrom_password = Confrom_password;
    }

}