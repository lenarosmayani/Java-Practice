package Repository;

import java.util.ArrayList;
import java.util.List;

import Entity.LoanBookOrder;

public class RepositoryLoanOrder {
    private List<LoanBookOrder> loanOrders;
    private static int orderCounter = 0;

    public RepositoryLoanOrder() {
        this.loanOrders = new ArrayList<>();
    }

    public void addLoanOrder(LoanBookOrder loanOrder) {
        loanOrder.setLoanID(generateUniqueOrderID());
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

    private String generateUniqueOrderID() {
        orderCounter++;
        return "ORDER-" + String.format("%03d", orderCounter);
    }
}
