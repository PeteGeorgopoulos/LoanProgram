 
public class CarLoan extends Loan{
    
    
    private final String loanType = "Car";
    private final double loanRate = 6;

    public CarLoan(double loanAmount, int termInt) {
        super(loanAmount, termInt);
    }
    
}
