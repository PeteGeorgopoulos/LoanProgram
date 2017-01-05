 
public class HomeLoan extends Loan{
    
    
    private final String loanType = "Commercial";
    private final double loanRate = 4.5;

    public HomeLoan(double loanAmount, int termInt) {
        super(loanAmount, termInt);
    }
    
}
