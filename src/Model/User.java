package Model;

public class User {
    private String UId;
    private String TitleId;
    private String jobTitle;
    private String name;


    public User() {
    }

    public User(String UId, String titleId, String jobTitle, String name) {
        this.UId = UId;
        TitleId = titleId;
        this.jobTitle = jobTitle;
        this.name = name;
    }

    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    public String getTitleId() {
        return TitleId;
    }

    public void setTitleId(String titleId) {
        TitleId = titleId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "UId='" + UId + '\'' +
                ", TitleId='" + TitleId + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}