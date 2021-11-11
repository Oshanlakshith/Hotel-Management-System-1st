package Model;

public class Employe {
    private String EmployeId;
    private String JobTitleId;
    private String JobTitle;
    private String EmployeName;
    private String Address;
    private int PhoneNumber;
    private int Password;

    public Employe() {
    }

    public Employe(String employeId, String jobTitleId, String jobTitle, String employeName, String address, int phoneNumber, int password) {
        EmployeId = employeId;
        JobTitleId = jobTitleId;
        JobTitle = jobTitle;
        EmployeName = employeName;
        Address = address;
        PhoneNumber = phoneNumber;
        Password = password;
    }

    public String getEmployeId() {
        return EmployeId;
    }

    public void setEmployeId(String employeId) {
        EmployeId = employeId;
    }

    public String getJobTitleId() {
        return JobTitleId;
    }

    public void setJobTitleId(String jobTitleId) {
        JobTitleId = jobTitleId;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getEmployeName() {
        return EmployeName;
    }

    public void setEmployeName(String employeName) {
        EmployeName = employeName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "EmployeId='" + EmployeId + '\'' +
                ", JobTitleId='" + JobTitleId + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                ", EmployeName='" + EmployeName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", Password=" + Password +
                '}';
    }
}