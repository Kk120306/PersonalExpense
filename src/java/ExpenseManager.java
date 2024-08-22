package java;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;
    private List<Income> incomes;
    private double budget;

    
    public ExpenseManager() {
        this.expenses = new ArrayList<>();
        this.incomes = new ArrayList<>();
        this.budget =0;

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

    public void setBudget(double ammount){
        this.budget = ammount;
    }

    public double getBudget(){
        return this.budget;
    }


    public void addExpense(String id, String name, double amount, String category, LocalDate date, boolean isRecurring){
        Expense expense = new Expense(id, name, amount, category, date, isRecurring);
        if (expense.isRecurring()){
            addRecurringExpenses(expense);
        }
        else expenses.add(expense);

        if (sumExpensesByMonth(date.getMonth(), date.getYear()) > Double.valueOf(budget)){
            System.out.println("Warning! Your expenses are exceeding your monthly budget");
        }
    }

    public void modifyExpense(String id, String newName, double newAmount, String newCategory, LocalDate newDate, boolean newIsRecurring){
        Expense expense = findExpenseById(id);
        if (expense != null) {
            expense.setName(newName);
            expense.setAmount(newAmount);
            expense.setCategory(newCategory);
            expense.setDate(newDate);
            expense.setRecurring(newIsRecurring); // Return true if modification was successful
        }
    }

    public Expense findExpenseById(String id) {
        for (Expense expense : expenses) {
            if (expense.getId().equals(id)) {
                return expense;
            }
        }
        return null;  // Return null if not found
    }

    public double sumExpensesByMonth(Month month, int year) {
        return expenses.stream()
                .filter(expense -> expense.getDate().getMonth() == month && expense.getDate().getYear() == year)
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public double sumExpensesByYear(int year) {
        return expenses.stream()
                .filter(expense -> expense.getDate().getYear() == year)
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public void addIncome(String id, String source, double amount, LocalDate date, boolean isRecurring){
        Income income = new Income(id, source, amount, date, isRecurring);
        if (income.isRecurring())incomes.add(income);
        else addRecurringIncomes(income);
    }

    public Income findIncomeById(String id) {
        for (Income income : incomes) {
            if (income.getId().equals(id)) {
                return income;
            }
        }
        return null;  // Return null if not found
    }

    public void modifyIncome(String id, String source, double amount, LocalDate date, boolean isRecurring){
        Income income = findIncomeById(id);
        if (income != null){
            income.setSource(source);
            income.setAmount(amount);
            income.setDate(date);
            income.setRecurring(isRecurring);
        }
    }

    private void addRecurringExpenses(Expense originalExpense) {
        LocalDate startDate = originalExpense.getDate().plusMonths(1);
        LocalDate endDate = startDate.plusYears(1);  

        while (!startDate.isAfter(endDate)) {
            Expense recurringExpense = new Expense(
                    originalExpense.getId() + "_" + startDate.getMonthValue() + startDate.getYear(), 
                    originalExpense.getName(),
                    originalExpense.getAmount(),
                    originalExpense.getCategory(),
                    startDate,
                    true
            );
            expenses.add(recurringExpense);
            startDate = startDate.plusMonths(1);
        }
    }

    private void addRecurringIncomes(Income originalIncome) {
        LocalDate startDate = originalIncome.getDate().plusMonths(1);
        LocalDate endDate = startDate.plusYears(1);
    
        while (!startDate.isAfter(endDate)) {
            Income recurringIncome = new Income(
                originalIncome.getId() + "_" + startDate.getMonthValue() + startDate.getYear(),
                originalIncome.getSource(),
                originalIncome.getAmount(),
                startDate,  // This should be the new date for the recurring income
                true
            );
            incomes.add(recurringIncome);
            startDate = startDate.plusMonths(1);
        }
    }


}