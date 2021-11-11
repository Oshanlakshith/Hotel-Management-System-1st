package View.tm;

public class BookingTm {
    private String reservationId;
    private String customerId;
    private String checkIn;
    private String getCheckOut;
    private String roomNo;
    private String roomprice;
    private String mealType;
    private String mealPrice;
    private double total;
    private String date;
    private String time;

    public BookingTm() {
    }

    public BookingTm(String reservationId, String customerId, String checkIn, String getCheckOut, String roomNo, String roomprice, String mealType, String mealPrice, double total, String date, String time) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.checkIn = checkIn;
        this.getCheckOut = getCheckOut;
        this.roomNo = roomNo;
        this.roomprice = roomprice;
        this.mealType = mealType;
        this.mealPrice = mealPrice;
        this.total = total;
        this.date = date;
        this.time = time;
    }

    public BookingTm(String reservationId, String customerId, String checkIn, String getCheckOut, String roomNo, String mealType, double total, String date) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.checkIn = checkIn;
        this.getCheckOut = getCheckOut;
        this.roomNo = roomNo;
        this.mealType = mealType;
        this.total = total;
        this.date = date;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getGetCheckOut() {
        return getCheckOut;
    }

    public void setGetCheckOut(String getCheckOut) {
        this.getCheckOut = getCheckOut;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(String roomprice) {
        this.roomprice = roomprice;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(String mealPrice) {
        this.mealPrice = mealPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BookingTm{" +
                "reservationId='" + reservationId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", checkIn='" + checkIn + '\'' +
                ", getCheckOut='" + getCheckOut + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", roomprice='" + roomprice + '\'' +
                ", mealType='" + mealType + '\'' +
                ", mealPrice='" + mealPrice + '\'' +
                ", total=" + total +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}