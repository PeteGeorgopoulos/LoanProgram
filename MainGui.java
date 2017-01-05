//imports ======================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

//Main Class ===================================================================
public class MainGui extends JFrame implements ActionListener{
    Loan newLoan;
    JPanel topPanel, infoPanel, bottomPanel;
    JLabel topTitleLabel;
    JButton enterButton, exitButton;
    InputPanel inputPanel;
    JTextArea topInfoArea;
    String topInfoText = "To fill out this form, please enter the amount "
            + "of which you would like to take out in a loan. "
            + "Also, please provide a name that we will attach to the loan. "
            + "Once that has been entered you will be given available choices "
            + "as to which type of loan you would like to take out, as well "
            + "as the terms available for that loan.";
    
    JTextArea infoArea;
    String[] infoArray = {"","","","","","",""};
    
    String infoMessage = "Name: " + infoArray[0] +"\n" +
            "Loan Type: " + infoArray[1] + "\n" +
            "Loan Term: " + infoArray[2] + " years\n" +
            "Loan Rate: " + infoArray[3] + "\n" +
            "Held in Escrow: " + infoArray[4] + "\n" +
            "Loan Total: " + infoArray[5] + "\n" +
            "Monthly Payment: " + infoArray[6] + "\n";
    //constructor
    public MainGui(){
        
        buildGui();
    }
    //Builds GUI 
    public void buildGui(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        setTitle("Loan Information System");
        
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,1));
        topPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5,5,5,5),
                new EtchedBorder()));
        topTitleLabel = new JLabel("  Loan Information System ");
        topTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
        topPanel.add(topTitleLabel);
        
        topInfoArea = new JTextArea(topInfoText);
        topInfoArea.setLineWrap(true);
        topInfoArea.setOpaque(false);
        topInfoArea.setEditable(false);
        topPanel.add(topInfoArea);
        
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());
        infoArea = new JTextArea(10,20);
        infoArea.setLineWrap(true);
        infoArea.setText(infoMessage);
        infoArea.setVisible(false);
        infoPanel.add(infoArea);
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(bottomPanel, BorderLayout.SOUTH);
        
        enterButton = new JButton("ENTER");
        enterButton.addActionListener(this);
        bottomPanel.add(enterButton);
        
        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);
        bottomPanel.add(exitButton);
        
        
        inputPanel = new InputPanel();
        
        add(topPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.WEST);
        add(infoPanel, BorderLayout.EAST);
        
        pack();
        setVisible(true);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exitButton){
            System.exit(0);
        }
        if(e.getSource() == enterButton){
            int loanType = inputPanel.getType();
            newLoan = inputPanel.getObject();
            
            
            infoArray[0] = inputPanel.getName();
            infoArray[1] = newLoan.getLoanType();
            infoArray[2] = String.valueOf(newLoan.getLoanTerm());
            infoArray[3] = String.valueOf(newLoan.getLoanRate());
            infoArray[4] = String.valueOf(newLoan.getEscrowAmount());
            infoArray[5] = String.valueOf(newLoan.getTotalLoan());
            infoArray[6] = String.valueOf(newLoan.getMonthlyPayment());
            infoMessage = "Name: " + infoArray[0] +"\n" +
            "Loan Type: " + infoArray[1] + "\n" +
            "Loan Term: " + infoArray[2] + " years\n" +
            "Loan Rate: " + infoArray[3] + "\n" +
            "Held in Escrow: " + infoArray[4] + "\n" +
            "Loan Total: " + infoArray[5] + "\n" +
            "Monthly Payment: " + infoArray[6] + "\n";
            infoArea.setText(infoMessage);
            infoArea.setVisible(true);
            
        }
    }
    
    
    
}




