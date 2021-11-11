package Model;

public class Payment {
    private String CustomerId;
    private String recervationId;
    private String PaymentDate;
    private String PaymentTime;
    private String payment;

    public Payment() {
    }

    public Payment(String customerId, String recervationId, String paymentDate, String paymentTime, String payment) {
        CustomerId = customerId;
        this.recervationId = recervationId;
        PaymentDate = paymentDate;
        PaymentTime = paymentTime;
        this.payment = payment;
    }


    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getRecervationId() {
        return recervationId;
    }

    public void setRecervationId(String recervationId) {
        this.recervationId = recervationId;
    }

    public String getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        PaymentDate = paymentDate;
    }

    public String getPaymentTime() {
        return PaymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        PaymentTime = paymentTime;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                ", CustomerId='" + CustomerId + '\'' +
                ", recervationId='" + recervationId + '\'' +
                ", PaymentDate='" + PaymentDate + '\'' +
                ", PaymentTime='" + PaymentTime + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}