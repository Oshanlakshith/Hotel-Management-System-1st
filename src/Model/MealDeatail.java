package Model;

public class MealDeatail {
    private String roomNo;
    private String mealType;
    private String mealPrice;
    private String date;
    private String time;

    public MealDeatail() {
    }

    public MealDeatail(String roomNo, String mealType, String mealPrice, String date, String time) {
        this.roomNo = roomNo;
        this.mealType = mealType;
        this.mealPrice = mealPrice;
        this.date = date;
        this.time = time;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
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
        return "MealDeatail{" +
                "roomNo='" + roomNo + '\'' +
                ", mealType='" + mealType + '\'' +
                ", mealPrice='" + mealPrice + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}