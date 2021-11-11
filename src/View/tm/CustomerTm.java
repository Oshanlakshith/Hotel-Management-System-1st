package View.tm;

public class CustomerTm {
    private String CId;
    private String CName;
    private String CAddress;
    private String CPhoneNo;
    private String gender;
    private String CEMail;
    private String CAge;
    private String Country;
    private String Date;
    private String Time;
    private String UId;
    private String UName;

    public CustomerTm() {
    }

    public CustomerTm(String CId, String CName, String CAddress, String CPhoneNo, String gender, String CEMail, String CAge, String country, String date, String time, String UId, String UName) {
        this.CId = CId;
        this.CName = CName;
        this.CAddress = CAddress;
        this.CPhoneNo = CPhoneNo;
        this.gender = gender;
        this.CEMail = CEMail;
        this.CAge = CAge;
        Country = country;
        Date = date;
        Time = time;
        this.UId = UId;
        this.UName = UName;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCAddress() {
        return CAddress;
    }

    public void setCAddress(String CAddress) {
        this.CAddress = CAddress;
    }

    public String getCPhoneNo() {
        return CPhoneNo;
    }

    public void setCPhoneNo(String CPhoneNo) {
        this.CPhoneNo = CPhoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCEMail() {
        return CEMail;
    }

    public void setCEMail(String CEMail) {
        this.CEMail = CEMail;
    }

    public String getCAge() {
        return CAge;
    }

    public void setCAge(String CAge) {
        this.CAge = CAge;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    @Override
    public String toString() {
        return "CustomerTm{" +
                "CId='" + CId + '\'' +
                ", CName='" + CName + '\'' +
                ", CAddress='" + CAddress + '\'' +
                ", CPhoneNo='" + CPhoneNo + '\'' +
                ", gender='" + gender + '\'' +
                ", CEMail='" + CEMail + '\'' +
                ", CAge='" + CAge + '\'' +
                ", Country='" + Country + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", UId='" + UId + '\'' +
                ", UName='" + UName + '\'' +
                '}';
    }
}