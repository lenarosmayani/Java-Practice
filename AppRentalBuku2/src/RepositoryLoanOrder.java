import java.util.ArrayList;
import java.util.List;

public class RepositoryLoanOrder {
    private List<LoanBookOrder> loanOrders;

    public RepositoryLoanOrder() {
        this.loanOrders = new ArrayList<>();
    }

    public void addLoanOrder(LoanBookOrder loanOrder) {
        this.loanOrders.add(loanOrder);
    }

    public void removeLoanOrder(LoanBookOrder returnedBookOrder) {
        this.loanOrders.remove(returnedBookOrder);
    }
    
    public LoanBookOrder findLoanOrder(String loanID) {
        for (LoanBookOrder loanOrder : loanOrders) {
            if (loanOrder.getLoanID().equals(loanID)) {
                return loanOrder;
            }
        }
        return null;
    }

    public List<LoanBookOrder> getAllLoanOrders() {
        return new ArrayList<>(this.loanOrders);
    }

    public void displayLoanOrders() {
        if (loanOrders.isEmpty()) {
            System.out.println("No loan orders available.");
            return;
        }

        System.out.println("+--------------+----------------------------------------+----------------------+----------+------------+");
        System.out.printf("| %-12s | %-40s | %-20s | %-8s | %-8s |\n", "Order ID", "Member", "Book", "Duration", "Fee");
        System.out.println("+--------------+----------------------------------------+----------------------+----------+------------+");

        for (LoanBookOrder loanOrder : this.loanOrders) {
            System.out.printf("| %-12s | %-40s | %-20s | %-8d | %-8s |\n",
                    loanOrder.getLoanID(), loanOrder.getMember().getMemberName(),
                    loanOrder.getLoanBook().getTitle(), loanOrder.getLoanDuration(),
                    loanOrder.getLoanFee());
        }

        System.out.println("+--------------+----------------------------------------+----------------------+----------+------------+");
    }

}
