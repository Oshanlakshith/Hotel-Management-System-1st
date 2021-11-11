package Model;

public class BookingRoom {
    private String RoomNo;
    private String Cid;
    private String Reservation;
    private String RoomPrice;
    private String Date;

    public BookingRoom() {
    }

    public BookingRoom(String roomNo, String cid, String reservation, String roomPrice, String date) {
        RoomNo = roomNo;
        Cid = cid;
        Reservation = reservation;
        RoomPrice = roomPrice;
        Date = date;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getReservation() {
        return Reservation;
    }

    public void setReservation(String reservation) {
        Reservation = reservation;
    }

    public String getRoomPrice() {
        return RoomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        RoomPrice = roomPrice;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "BookingRoom{" +
                "RoomNo='" + RoomNo + '\'' +
                ", Cid='" + Cid + '\'' +
                ", Reservation='" + Reservation + '\'' +
                ", RoomPrice='" + RoomPrice + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
