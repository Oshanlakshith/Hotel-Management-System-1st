package Model;

public class UserDatabase {
    private String UId;
    private String EId;
    private String Name;
    private String JobTitle;
    private String Password;

    public UserDatabase() {
    }

    public UserDatabase(String UId, String EId, String name, String jobTitle, String password) {
        this.UId = UId;
        this.EId = EId;
        Name = name;
        JobTitle = jobTitle;
        Password = password;
    }

    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    public String getEId() {
        return EId;
    }

    public void setEId(String EId) {
        this.EId = EId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "UserDatabase{" +
                "UId='" + UId + '\'' +
                ", EId='" + EId + '\'' +
                ", Name='" + Name + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}