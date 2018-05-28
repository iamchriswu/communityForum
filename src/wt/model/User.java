package wt.model;

public class User {
    String uAccount;
    String uPassword;

    public User() {
    }

    public User(String uAccount, String uPassword) {
        this.uAccount = uAccount;
        this.uPassword = uPassword;
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
}
