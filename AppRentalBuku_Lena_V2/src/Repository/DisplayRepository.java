package Repository;

import Entity.BookForLoan;
import Entity.LoanBookOrder;
import Entity.Member;
import Interface.IDisplay;

import java.util.List;

public class DisplayRepository implements IDisplay {
    @Override
    public void displayBookList(List<BookForLoan> books) {
    	System.out.println(" ---------------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-40s | %-20s | %-10s |\n", "Book ID", "Title", "Author", "Stock");
        System.out.println("|--------------|------------------------------------------|----------------------|------------|");

        for (BookForLoan book : books) {
            System.out.printf("| %-12s | %-40s | %-20s | %-10d |\n",
                    book.getBookID(), book.getTitle(), book.getAuthor(), book.getStock());
        }

        System.out.println("|--------------|------------------------------------------|----------------------|------------|");
    }

    @Override
    public void displayLoanOrders(List<LoanBookOrder> loanOrders) {
        if (loanOrders.isEmpty()) {
            System.out.println("No loan orders available.");
            return;
        }

        System.out.println("+--------------+--------------------------------+--------------+------------------------------------------+----------+-----------------+----------------+");
        System.out.printf("| %-12s | %-30s | %-12s | %-40s | %-8s | %-15s | %-15s |\n",
                "Loan ID", "Name", "BookID", "Book Title", "Duration", "Book Loan Price", "Loan Fee");
        System.out.println("+--------------+--------------------------------+--------------+------------------------------------------+----------+-----------------+----------------+");

        for (LoanBookOrder loanOrder : loanOrders) {
            double bookLoanPrice = loanOrder.getLoanFee()/loanOrder.getLoanDuration();
            System.out.printf("| %-12s | %-30s | %-12s | %-40s | %-8s | %-15.1f | %-15.1f |\n",
                    loanOrder.getLoanID(), loanOrder.getMember().getMemberName(),
                    loanOrder.getLoanBook().getBookID(), loanOrder.getLoanBook().getTitle(),
                    loanOrder.getLoanDuration(), bookLoanPrice,
                    loanOrder.getLoanFee());
        }

        System.out.println("+--------------+--------------------------------+--------------+------------------------------------------+----------+-----------------+----------------+");
    }


    @Override
    public void displayMemberList(List<Member> members) {
    	System.out.println("|--------------------------------------------------------------------------------|");
        System.out.println("                                Daftar Member                                     ");
        System.out.println("|--------------------------------------------------------------------------------|");
        System.out.printf("| %-12s | %-40s | %-20s |\n", "Member ID", "Name", "Address");
        System.out.println("|--------------|------------------------------------------|----------------------|");

        for (Member member : members) {
            System.out.printf("| %-12s | %-40s | %-20s |\n",
                    member.getMemberID(), member.getMemberName(), member.getAddress());
        }

        System.out.println("|--------------|------------------------------------------|----------------------|");
    }
}
