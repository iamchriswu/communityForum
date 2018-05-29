package wt.model;

public class Command {
    String uAccount;
    String uCommandTime;
    String uCommandID;
    String uCommandContent;

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    public String getuCommandTime() {
        return uCommandTime;
    }

    public void setuCommandTime(String uCommandTime) {
        this.uCommandTime = uCommandTime;
    }

    public String getuCommandID() {
        return uCommandID;
    }

    public void setuCommandID(String uCommandID) {
        this.uCommandID = uCommandID;
    }

    public String getuCommandContent() {
        return uCommandContent;
    }

    public void setuCommandContent(String uCommandContent) {
        this.uCommandContent = uCommandContent;
    }
}
