package Model;

public class UserPassword {
    private String EId;
    private String Password;

    public UserPassword() {
    }

    public UserPassword(String EId, String password) {
        this.EId = EId;
        Password = password;
    }

    public String getEId() {
        return EId;
    }

    public void setEId(String EId) {
        this.EId = EId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "UserPassword{" +
                "EId='" + EId + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
