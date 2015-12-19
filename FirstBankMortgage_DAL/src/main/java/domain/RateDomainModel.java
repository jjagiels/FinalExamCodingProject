package domain;


import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

public class RateDomainModel implements Serializable {
	
	private int RateID;
	private int MinCreditScore;
	private double InterestRate;
	
	public RateDomainModel(){}
	
	public RateDomainModel(int RateID, int MinCreditScore,double InterestRate)
	{
		this.RateID = RateID;
		this.MinCreditScore = MinCreditScore;
		this.InterestRate = InterestRate;
	}
	public int getRateID() {
		return RateID;
	}
	public void setRateID(int rateID) {
		RateID = rateID;
	}
	public int getMinCreditScore() {
		return MinCreditScore;
	}
	public void setMinCreditScore(int minCreditScore) {
		MinCreditScore = minCreditScore;
	}
	public double getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
	
	
}