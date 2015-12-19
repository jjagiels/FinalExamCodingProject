package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.UUID;

import base.RateDAL;
import ch.makery.address.MainApp;
import ch.makery.address.model.Rate;


public class MortgageController {


    // Reference to the main application.
    private MainApp mainApp;

	double GivenIncome = 0;
	double GivenExpenses = 0;
	int GivenCreditScore = 0;
	double GivenHouseCost = 0;
	int SelectedRate = 0;
	double MonthlyPayment = 0;
	ArrayList<String> GivenValues = new ArrayList<String>();
    
    @FXML
    public TextField IncomeEntry;
    
    @FXML
    public TextField ExpensesEntry;
    
    @FXML
    public TextField CreditScoreEntry;
    
    @FXML
    public TextField HouseCostEntry;
    
    @FXML
    public RadioButton ThirtyYear;
    
    @FXML
    public RadioButton FifteenYear;
    
    @FXML
    public Button CalcMortgage;
    
    @FXML
    public Label MortgageResult;
    
    @FXML
    public Label InterestRateResult;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MortgageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    this.setRadioGroup();	
    
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
	final ToggleGroup RateGroup = new ToggleGroup();
    
    @FXML
    protected void setRadioGroup(){
    	
    	ThirtyYear.setToggleGroup(RateGroup);
    	
    	FifteenYear.setToggleGroup(RateGroup);
    	FifteenYear.setSelected(true);
    }
    
   
    @FXML
    private void CalcMortgage(){
    	
    	GivenValues.add(IncomeEntry.getText());
    	GivenValues.add(ExpensesEntry.getText());
    	GivenValues.add(CreditScoreEntry.getText());
    	GivenValues.add(HouseCostEntry.getText());
    	if(RateGroup.getSelectedToggle() == FifteenYear){GivenValues.add("FifteenYear");}
    	else if(RateGroup.getSelectedToggle() == ThirtyYear){GivenValues.add("ThirtyYear");}
    	
    	//Check Values here
    	
    	MonthlyPayment = Rate.getPayment(getNumberOfPayments(), getGivenCreditScore(), getGivenHouseCost());
    	
    	if(MonthlyPayment*getNumberOfPayments() <= (getGivenIncome()*getNumberOfPayments())*36 && MonthlyPayment*getNumberOfPayments() <= (getGivenIncome()*getNumberOfPayments())+(getGivenExpenses()*getNumberOfPayments())*28){
    		MortgageResult.setText(Double.toString(Math.round(Math.abs(MonthlyPayment)*100.0)/100.0));
    		InterestRateResult.setText(Double.toString(RateDAL.getRate(getGivenCreditScore())));
    		System.out.println(getNumberOfPayments());
    	}
    	else{
    		MortgageResult.setText("Cannot Afford");
    	}
    	
    	
    	
    }
    
    private double getGivenIncome(){
    	this.GivenIncome = Double.parseDouble(GivenValues.get(0));
    	return GivenIncome;
    }
    
    private double getGivenExpenses(){
    	this.GivenExpenses = Double.parseDouble(GivenValues.get(1));
    	return GivenExpenses;
    }
    
    private int getGivenCreditScore(){
    	this.GivenCreditScore = Integer.parseInt(GivenValues.get(2));
    	return GivenCreditScore;
    }
    
    private double getGivenHouseCost(){
    	this.GivenHouseCost = Double.parseDouble(GivenValues.get(3));
    	return GivenHouseCost;
    }
    
    private int getNumberOfPayments(){
    	String RateString = "";
    	RateString = GivenValues.get(4);
    	
    	if(RateString == "FifteenYear"){SelectedRate = 180;}
    	else if(RateString == "ThirtyYear"){SelectedRate = 360;}
    	
    	return SelectedRate;
    }
    
    
}