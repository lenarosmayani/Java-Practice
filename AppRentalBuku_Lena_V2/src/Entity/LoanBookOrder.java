package Entity;

public class LoanBookOrder {
    private String loanID;
    private Member member;
    private BookForLoan loanBook;
    private int loanDuration;
    private double loanFee;

    
    public LoanBookOrder(String loanID, Member member, BookForLoan loanBook, int loanDuration) {
        this.loanID = loanID;
        this.member = member;
        this.loanBook = loanBook;
        this.loanDuration = loanDuration;
        this.loanFee = calculateLoanFee();
    }
    
    public LoanBookOrder(Member member, BookForLoan loanBook, int loanDuration) {
        this.member = member;
        this.loanBook = loanBook;
        this.loanDuration = loanDuration;
        this.loanFee = calculateLoanFee();
    }

	public double calculateLoanFee() {
        return loanBook.calculateBookLoanPrice() * loanDuration;
    }

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public BookForLoan getLoanBook() {
        return loanBook;
    }

    public void setLoanBook(BookForLoan loanBook) {
        this.loanBook = loanBook;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
        this.loanFee = calculateLoanFee();
    }

    public double getLoanFee() {
        return loanFee;
    }

    public void setLoanFee(double loanFee) {
        this.loanFee = loanFee;
    }

    @Override
    public String toString() {
        return "LoanBookOrder{" +
                "loanID='" + loanID + '\'' +
                ", member=" + member +
                ", loanBook=" + loanBook +
                ", loanDuration=" + loanDuration +
                ", loanFee=" + loanFee +
                '}';
    }
}

