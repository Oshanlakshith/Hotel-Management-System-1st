package View.tm;

public class DeatailTm {
    private String reservationId;
    private String CustomerId;
    private String RoomNo;
    private String mealId;
    private String MealType;
    private String MealPrice;
    private String checkIn;
    private String getCheckOut;
    private String RoomType;
    private String RPrice;
    private String Adult;
    private String child;
    private String Date;
    private String time;
    private String total;

    public DeatailTm() {
    }

    public DeatailTm(String reservationId, String customerId, String roomNo, String mealId, String mealType, String mealPrice, String checkIn, String getCheckOut, String roomType, String RPrice, String adult, String child, String date, String time, String total) {
        this.reservationId = reservationId;
        this.CustomerId = customerId;
        this.RoomNo = roomNo;
        this.mealId = mealId;
        this.MealType = mealType;
        this.MealPrice = mealPrice;
        this.checkIn = checkIn;
        this.getCheckOut = getCheckOut;
        this.RoomType = roomType;
        this.RPrice = RPrice;
        this.Adult = adult;
        this.child = child;
        this.Date = date;
        this.time = time;
        this.total = total;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getMealType() {
        return MealType;
    }

    public void setMealType(String mealType) {
        MealType = mealType;
    }

    public String getMealPrice() {
        return MealPrice;
    }

    public void setMealPrice(String mealPrice) {
        MealPrice = mealPrice;
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

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public String getRPrice() {
        return RPrice;
    }

    public void setRPrice(String RPrice) {
        this.RPrice = RPrice;
    }

    public String getAdult() {
        return Adult;
    }

    public void setAdult(String adult) {
        Adult = adult;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DeatailTm{" +
                "reservationId='" + reservationId + '\'' +
                ", CustomerId='" + CustomerId + '\'' +
                ", RoomNo='" + RoomNo + '\'' +
                ", mealId='" + mealId + '\'' +
                ", MealType='" + MealType + '\'' +
                ", MealPrice='" + MealPrice + '\'' +
                ", checkIn='" + checkIn + '\'' +
                ", getCheckOut='" + getCheckOut + '\'' +
                ", RoomType='" + RoomType + '\'' +
                ", RPrice='" + RPrice + '\'' +
                ", Adult='" + Adult + '\'' +
                ", child='" + child + '\'' +
                ", Date='" + Date + '\'' +
                ", time='" + time + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
