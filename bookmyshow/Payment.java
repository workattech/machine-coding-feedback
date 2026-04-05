package bookmyshow;


import java.util.Date;


class Payment {
    private String paymentId;
    private PaymentType type;
    private double amount;
    private PaymentStatus status;
    private Date paymentDate;

    // Constructors, getters, and setters

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public PaymentType getType() {
        return type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }
}
