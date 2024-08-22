package java;

import java.time.LocalDate;

public class Income {
    private String id;
    private String source;
    private double amount;
    private LocalDate date;
    private boolean isRecurring;
    
    public Income(String id, String source, double amount, LocalDate date, boolean isRecurring) {
        this.id = id;
        this.source = source;
        this.amount = amount;
        this.date = date;
        this.isRecurring = isRecurring;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    
}
