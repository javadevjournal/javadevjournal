import java.util.Arrays;
import java.util.List;
class Expense {
   String category;
   private double expense;
   Expense(String _category, double _expense) {
       this.category = _category;
       this.expense = _expense;
   }
   double getExpense() {
       return expense;
   }
   String getCategory() {
       return category;
   }
}

public class ExpenseTracker {
   public static void main(String[] args) {
       List<Expense> expenseList = Arrays.asList(new Expense("fuel", 200), new Expense("grocery", 1000), new Expense("rent", 500), new Expense("outdoor", 560.5));
       double totalExpense = expenseList.stream().reduce(0.0, (result, current) -> result + current.getExpense(), Double::sum);
       Expense highestExpense = expenseList.stream().reduce((result, current) -> result.getExpense() > current.getExpense() ? result : current).orElse(null);
       double lowestExpenseAmount = expenseList.stream().map(Expense::getExpense).reduce(Double.MAX_VALUE, (result, current) -> result < current ? result : current);

       System.out.println("Total expense : " + totalExpense);
       System.out.println("Highest expense category : " + highestExpense.getCategory() + " expense : " + highestExpense.getExpense());
       System.out.println("Lowest expense : " + lowestExpenseAmount);
   }
}
