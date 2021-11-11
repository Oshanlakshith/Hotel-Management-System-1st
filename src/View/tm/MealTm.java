package View.tm;

public class MealTm {
    private String mealId;
    private String mealType;
    private String mealPrice;

    public MealTm() {
    }

    public MealTm(String mealId, String mealType, String mealPrice) {
        this.mealId = mealId;
        this.mealType = mealType;
        this.mealPrice = mealPrice;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
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

    @Override
    public String toString() {
        return "MealTm{" +
                "mealId='" + mealId + '\'' +
                ", mealType='" + mealType + '\'' +
                ", mealPrice='" + mealPrice + '\'' +
                '}';
    }
}
