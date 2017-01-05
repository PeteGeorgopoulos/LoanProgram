
public class Loan {
    private String loanType;
    private int loanTerm;
    private double loanAmount;
    private double loanRate;
    private final double escrowAmount = 1500;
    private final double closingCost = 3050;
    private double totalLoan;
    private double monthlyPayment;
    private int termInt;
    
    
    public Loan(double loanAmount, int termInt) {
        this.loanAmount = loanAmount;
        this.termInt = termInt;
    }
    
    /**
     * @return the loanType
     */
    public String getLoanType() {
        return loanType;
    }
    
    /**
     * @return the loanTerm
     */
    public int getLoanTerm() {
        return loanTerm;
    }

    

    /**
     * @return the loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    
    

    /**
     * @return the loanRate
     */
    public double getLoanRate() {
        return loanRate;
    }

    /**
     * @return the escrowAmount
     */
    public double getEscrowAmount() {
        return escrowAmount;
    }

    /**
     * @return the closingCost
     */
    public double getClosingCost() {
        return closingCost;
    }

    /**
     * @return the totalLoan
     */
    public double getTotalLoan() {
        totalLoan = loanAmount*loanRate + escrowAmount + closingCost;
        monthlyPayment = totalLoan / (loanTerm*12);
        return totalLoan;
    }

    /**
     * @return the monthlyPayment
     */
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public int getTermInt(){
        return termInt;
    }
    
}
