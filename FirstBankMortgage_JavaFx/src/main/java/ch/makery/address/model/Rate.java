package ch.makery.address.model;

import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;
import domain.RateDomainModel;

public class Rate extends RateDomainModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static double getPayment(int NumberOfPayments, int GivenCreditScore, double mortgageLoan)
	{
		//FinalExam
		//	Normally this kind of method would be in a BLL, but alas...
		
		//	Figure out payment based on:
		//	Interest rate
		//	PV
		//	FV (make FV = 0, unless you want a balloon payment
		//	Compounding = True
		//	Number of Payments (passed in)
		
		double MonthlyRate = 0;
		
		MonthlyRate = FinanceLib.pmt((RateDAL.getRate(GivenCreditScore)/100)/12, (double)NumberOfPayments, mortgageLoan, 0, true);
		
		return MonthlyRate;
	}
}
