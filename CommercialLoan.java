 
public class CommercialLoan extends Loan{
    
    
    private final String loanType = "Commercial";
    private final double loanRate = 4.5;

    public CommercialLoan(double loanAmount, int termInt) {
        super(loanAmount, termInt);
    }
    
    public String getType(){
        return loanType;
    }
    
    public double getRate(){
        return loanRate;
    }

    
}
