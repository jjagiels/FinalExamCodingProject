package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import domain.StudentDomainModel;
import util.HibernateUtil;

public class RateDAL {


	public static double getRate(int GivenCreditScore) {
		//FinalExam - please implement		
		// Figure out which row makes sense- return back the 
		// right interest rate from the table based on the given credit score
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;		
		ArrayList<RateDomainModel> rates = new ArrayList<RateDomainModel>();
		
		try {
			tx = session.beginTransaction();	
			
			List rateList = session.createQuery("FROM RateDomainModel").list();
			for (Iterator iterator = rateList.iterator(); iterator.hasNext();) {
				RateDomainModel rate = (RateDomainModel) iterator.next();
				rates.add(rate);

			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		ArrayList<Integer> creditScores = new ArrayList<Integer>();
		int creditScoreIteration = 0;
		
		for(RateDomainModel y : rates){
			creditScoreIteration = y.getMinCreditScore();
			creditScores.add(creditScoreIteration);
		}
		Collections.sort(creditScores);
		Collections.reverse(creditScores);
		
		int matchedCreditScore = 0;
		
		for(int i : creditScores){
			if(GivenCreditScore >= i){
				matchedCreditScore = i;
				break;
			}
			else{
				continue;
			}
		}
		
		double foundRate = 0;
		
		for(RateDomainModel y2 : rates){
			if(matchedCreditScore == y2.getMinCreditScore()){
				foundRate = y2.getInterestRate();
				break;
			}
			else{
				continue;
			}
		}
		
		
		//FinalExam - obviously change the return value
		return foundRate;
	}

}