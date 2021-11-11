package View.tm;

public class RoomTm {
    public String RoomNo;
    private String RoomType;
    private String AcType;
    private String price;

    public RoomTm() {
    }

    public RoomTm(String roomNo, String roomType, String acType,String price) {
        this.RoomNo = roomNo;
        this.RoomType = roomType;
        this.AcType = acType;
        this.price = price;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public String getAcType() {
        return AcType;
    }

    public void setAcType(String acType) {
        AcType = acType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomTm{" +
                "RoomNo='" + RoomNo + '\'' +
                ", RoomType='" + RoomType + '\'' +
                ", AcType='" + AcType + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}