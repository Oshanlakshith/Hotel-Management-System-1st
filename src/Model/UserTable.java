package Model;

public class UserTable {
    private String UserId;
    private String jobTitleId;
    private String JobTitle;
    private String name;

    public UserTable() {
    }

    public UserTable(String userId, String jobTitleId, String jobTitle, String name) {
        UserId = userId;
        this.jobTitleId = jobTitleId;
        JobTitle = jobTitle;
        this.name = name;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getJobTitleId() {
        return jobTitleId;
    }

    public void setJobTitleId(String jobTitleId) {
        this.jobTitleId = jobTitleId;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserTable{" +
                "UserId='" + UserId + '\'' +
                ", jobTitleId='" + jobTitleId + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
