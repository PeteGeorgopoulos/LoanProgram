import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

//Input Class ==================================================================
class InputPanel extends JPanel implements ActionListener{
    //class fields
    Loan newLoan;
    JPanel panelOne, panelTwo, panelThree, panelFour, panelFive;
    private JTextField nameField;
    private JTextField amountField;
    private String termOption;
    private int typeOption;
    JLabel nameLabel, amountLabel, typeLabel, termLabel;
    
    private JRadioButton typeRButtonOne;
    private JRadioButton typeRButtonTwo;
    private JRadioButton typeRButtonThree;
    private JRadioButton termRButtonOne;
    private JRadioButton termRButtonTwo;
    private JRadioButton termRButtonThree;
    ButtonGroup typeGroup, termGroup;
    
    
    //constructor
    public InputPanel(){
        
        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(3,3,3,3),
                new EtchedBorder()));
        setLayout(new GridLayout(6,1));
        
        //this panel class is broken into 4 panels
        panelOne = new JPanel();
        panelTwo = new JPanel();
        panelThree = new JPanel();
        panelFour = new JPanel();
        add(panelOne);
        add(panelTwo);
        add(panelThree);
        add(panelFour);
        
        //first panel
        nameLabel = new JLabel("Enter your full name: ");
        nameField = new JTextField(10);
        panelOne.add(nameLabel);
        panelOne.add(nameField);
        
        //second panel
        amountLabel = new JLabel("Enter loan amount: ");
        amountField = new JTextField(10);
        panelTwo.add(amountLabel);
        panelTwo.add(amountField);
        
        //third panel
        typeLabel = new JLabel("Loan type:");
        panelThree.add(typeLabel);
        
        
        typeRButtonOne = new JRadioButton("Commercial");
        typeRButtonOne.addActionListener(this);
        panelThree.add(typeRButtonOne);
        
        typeRButtonTwo = new JRadioButton("Home");
        typeRButtonTwo.addActionListener(this);
        panelThree.add(typeRButtonTwo);
        
        typeRButtonThree = new JRadioButton("Car");
        typeRButtonThree.addActionListener(this);
        panelThree.add(typeRButtonThree);
        
        typeGroup = new ButtonGroup();
        typeGroup.add(typeRButtonOne);
        typeGroup.add(typeRButtonTwo);
        typeGroup.add(typeRButtonThree);
        
        
        
        //forth panel
        termLabel = new JLabel("Loan term (years):");
        panelFour.add(termLabel);
        
        
        termRButtonOne = new JRadioButton();
        termRButtonOne.setEnabled(false);
        panelFour.add(termRButtonOne);
        
        termRButtonTwo = new JRadioButton();
        termRButtonTwo.setEnabled(false);
        panelFour.add(termRButtonTwo);
        
        termRButtonThree = new JRadioButton();
        termRButtonThree.setEnabled(false);
        panelFour.add(termRButtonThree);
        
        termGroup = new ButtonGroup();
        termGroup.add(termRButtonOne);
        termGroup.add(termRButtonTwo);
        termGroup.add(termRButtonThree);
        
        setVisible(true);
    }
    
    //action listener
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == typeRButtonOne ||
                e.getSource() == typeRButtonTwo ||
                e.getSource() == typeRButtonThree ){
            enableButtons();
            
            if(e.getSource() == typeRButtonOne){
                termRButtonOne.setText("10");
                termRButtonTwo.setText("20");
                termRButtonThree.setText("30");
            }
            else if(e.getSource() == typeRButtonTwo){
                termRButtonOne.setText("15");
                termRButtonTwo.setText("20");
                termRButtonThree.setText("30");
            }
            else if(e.getSource() == typeRButtonThree){
                termRButtonOne.setText("4");
                termRButtonTwo.setText("5");
                termRButtonThree.setText("6");
            }
    
        }
       
    }
    public void enableButtons(){
        termRButtonOne.setEnabled(true);
        termRButtonTwo.setEnabled(true);
        termRButtonThree.setEnabled(true);
    }
    public int getType(){
        if(typeRButtonOne.isSelected()){
            return 1;
            
        }
        else if(typeRButtonTwo.isSelected()){
            return 2;
            
        }
        else if(typeRButtonThree.isSelected()){
            return 3;
        }
        else
            return 0;
    }

    public Loan getObject() {
        
        if(termRButtonOne.isSelected()){
            termOption = termRButtonOne.getText();
            
        }
        else if(termRButtonTwo.isSelected()){
            termOption = termRButtonTwo.getText();
            
        }
        else if(termRButtonThree.isSelected()){
            termOption = termRButtonThree.getText();
            
        }
        else
            termOption  = null;
        
        if(typeRButtonOne.isSelected()){
            
            newLoan = new CommercialLoan(Double.parseDouble(amountField.getText()),
            Integer.parseInt(termOption));
            return newLoan;
            
        }
        else if(typeRButtonTwo.isSelected()){
            newLoan = new HomeLoan(Double.parseDouble(amountField.getText()),
            Integer.parseInt(termOption));
            return newLoan;
            
        }
        else if(typeRButtonThree.isSelected()){
            newLoan = new CarLoan(Double.parseDouble(amountField.getText()),
            Integer.parseInt(termOption));
            return newLoan;
        }
        else
            return null;
    }  
}
