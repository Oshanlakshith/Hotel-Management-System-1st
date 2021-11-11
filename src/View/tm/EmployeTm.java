package View.tm;

public class EmployeTm {
    private String Id;
    private String Name;
    private String Title;
    private String TitleId;
    private String Address;
    private String PhoneNumber;
    private String Password;
    private String Date;

    public EmployeTm() {
    }

    public EmployeTm(String id, String name, String title, String titleId, String address, String phoneNumber, String password, String date) {
        Id = id;
        Name = name;
        Title = title;
        TitleId = titleId;
        Address = address;
        PhoneNumber = phoneNumber;
        Password = password;
        Date = date;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitleId() {
        return TitleId;
    }

    public void setTitleId(String titleId) {
        TitleId = titleId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
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
        return "EmployeTm{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Title='" + Title + '\'' +
                ", TitleId='" + TitleId + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Password='" + Password + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}