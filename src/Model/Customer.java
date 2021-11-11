package Model;

import sun.awt.HKSCS;

public class Customer {
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

    public Customer(String CId, String CName, String CAddress, String CPhoneNo, String gender, String CEMail, String CAge, String country, String UId, String UName, String date, String time) {
        this.CId = CId;
        this.CName = CName;
        this.CAddress = CAddress;
        this.CPhoneNo = CPhoneNo;
        this.gender = gender;
        this.CEMail = CEMail;
        this.CAge = CAge;
        Country = country;
        this.UId = UId;
        this.UName = UName;
        Date = date;
        Time = time;
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

    @Override
    public String toString() {
        return "Customer{" +
                "CId='" + CId + '\'' +
                ", CName='" + CName + '\'' +
                ", CAddress='" + CAddress + '\'' +
                ", CPhoneNo='" + CPhoneNo + '\'' +
                ", gender='" + gender + '\'' +
                ", CEMail='" + CEMail + '\'' +
                ", CAge='" + CAge + '\'' +
                ", Country='" + Country + '\'' +
                ", UId='" + UId + '\'' +
                ", UName='" + UName + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}