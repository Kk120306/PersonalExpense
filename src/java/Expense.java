package java;

import java.time.LocalDate;

public class Expense {
    private String id;
    private String name;
    private double amount;
    private String category;
    private LocalDate date;
    private boolean isRecurring;

    public Expense(String id, String name, double amount, String category, LocalDate date, boolean isRecurring) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.isRecurring = isRecurring;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
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
