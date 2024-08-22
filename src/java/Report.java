package java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Report {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Expense> expenses;
    private List<Income> incomes;

    // Constructor
    public Report(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.expenses = new ArrayList<>();
        this.incomes = new ArrayList<>();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

}
