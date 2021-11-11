package Model;

public class CustomerUpdate {
    private  String CId;
    private  String CName;
    private  String CAddress;
    private  String TNumber;
    private  String Gender;
    private  String Email;
    private  String Age;
    private  String Country;

    public CustomerUpdate() {
    }

    public CustomerUpdate(String CId, String CName, String CAddress, String TNumber, String gender, String email, String age, String country) {
        this.CId = CId;
        this.CName = CName;
        this.CAddress = CAddress;
        this.TNumber = TNumber;
        this.Gender = gender;
        this.Email = email;
        this.Age = age;
        this.Country = country;
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

    public String getTNumber() {
        return TNumber;
    }

    public void setTNumber(String TNumber) {
        this.TNumber = TNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "CustomerUpdate{" +
                "CId='" + CId + '\'' +
                ", CName='" + CName + '\'' +
                ", CAddress='" + CAddress + '\'' +
                ", TNumber='" + TNumber + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Email='" + Email + '\'' +
                ", Age='" + Age + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
