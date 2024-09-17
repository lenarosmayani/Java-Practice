package Interface;

import Entity.BookForLoan;
import Entity.LoanBookOrder;
import Entity.Member;

import java.util.List;

	public interface IDisplay {
	    void displayBookList(List<BookForLoan> books);
	    void displayLoanOrders(List<LoanBookOrder> loanOrders);
	    void displayMemberList(List<Member> members);
	}
