package Model;

public class roomco {
    private String RoomNo;
    private String RoomType;
    private String price;

    public roomco() {
    }

    public roomco(String roomNo, String roomType, String price) {
        RoomNo = roomNo;
        RoomType = roomType;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "roomco{" +
                "RoomNo='" + RoomNo + '\'' +
                ", RoomType='" + RoomType + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
