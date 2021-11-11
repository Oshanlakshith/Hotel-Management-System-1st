package Model;


import java.util.ArrayList;

public class roomDeatail {
    private String RoomNo;
    private String CId;
    private String ReservationId;
    private double Roomprice;
    private  String Date;
    ArrayList<MealDeatail> meals;

    public roomDeatail() {
    }

    public roomDeatail(String roomNo, String CId, String reservationId, double roomprice, String date, ArrayList<MealDeatail> meals) {
        RoomNo = roomNo;
        this.CId = CId;
        ReservationId = reservationId;
        Roomprice = roomprice;
        Date = date;
        this.meals = meals;
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

    public double getRoomprice() {
        return Roomprice;
    }

    public void setRoomprice(double roomprice) {
        Roomprice = roomprice;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public ArrayList<MealDeatail> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<MealDeatail> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "roomDeatail{" +
                "RoomNo='" + RoomNo + '\'' +
                ", CId='" + CId + '\'' +
                ", ReservationId='" + ReservationId + '\'' +
                ", Roomprice=" + Roomprice +
                ", Date='" + Date + '\'' +
                ", meals=" + meals +
                '}';
    }
}