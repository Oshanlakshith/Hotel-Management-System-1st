package Model;

public class Employee {
    private String EmployeeId;
    private String JobTitleId;
    private String JobTitle;
    private String EmployeeName;
    private String Address;
    private int PhoneNumber;
    private int Password;
    private String Date;

    public Employee() {
    }

    public Employee(String employeId, String jobTitleId, String jobTitle, String employeName, String address, int phoneNumber, int password, String date) {
        EmployeeId = employeId;
        JobTitleId = jobTitleId;
        JobTitle = jobTitle;
        EmployeeName = employeName;
        Address = address;
        PhoneNumber = phoneNumber;
        Password = password;
        Date = date;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
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

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId='" + EmployeeId + '\'' +
                ", JobTitleId='" + JobTitleId + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", Password=" + Password +
                ", Date='" + Date + '\'' +
                '}';
    }
}
