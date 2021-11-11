package Model;

public class RoomRD {
    private String RoomNo;
    private String CId;
    private String ReservationId;
    private String RoomType;
    private double price;


    public RoomRD() {
    }

    public RoomRD(String roomNo, String CId, String reservationId, String roomType, double price) {
        RoomNo = roomNo;
        this.CId = CId;
        ReservationId = reservationId;
        RoomType = roomType;
        this.price = price;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getReservationId() {
        return ReservationId;
    }

    public void setReservationId(String reservationId) {
        ReservationId = reservationId;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomRD{" +
                "RoomNo='" + RoomNo + '\'' +
                ", CId='" + CId + '\'' +
                ", ReservationId='" + ReservationId + '\'' +
                ", RoomType='" + RoomType + '\'' +
                ", price=" + price +
                '}';
    }
}