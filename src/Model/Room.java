package Model;

public class Room {
    private String RoomNo;
    private String RoomType;
    private String AcType;
    private String price;

    public Room() {
    }
    public Room(String roomNo, String roomType, String acType,String price) {
        RoomNo = roomNo;
        RoomType = roomType;
        AcType = acType;
        this.price = price;
    }
    public Room(String roomNo, String roomType,String price) {
        this.RoomNo = roomNo;
        this.RoomType = roomType;
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
        return "Room{" +
                "RoomNo='" + RoomNo + '\'' +
                ", RoomType='" + RoomType + '\'' +
                ", AcType='" + AcType + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
