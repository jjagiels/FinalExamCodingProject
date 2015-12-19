package UnitTests;

import static org.junit.Assert.*;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import base.RateDAL;
import ch.makery.address.model.Rate;

public class Rate_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMonthlyPayment() {
		double testedMortgagePayment = Rate.getPayment(360, 715, 300000);
		double hardCodedPaymentTest = FinanceLib.pmt(0.04/12, 360.0, 300000.0, 0, true);
		
		
//		System.out.println(testedMortgagePayment);
//		System.out.println(hardCodedPaymentTest);
		assertTrue(testedMortgagePayment == hardCodedPaymentTest);

//	}
//	
//	@Test
//	public void testGetRate750() {
//		double testedInterestRate = RateDAL.getRate(765);
//		
//		assertTrue(testedInterestRate == 3.75);
//
//	}
//	
//	@Test
//	public void testGetRate700() {
//		double testedInterestRate = RateDAL.getRate(725);
//		
//		assertTrue(testedInterestRate == 4);
//
//	}
//	
//	@Test
//	public void testGetRate650() {
//		double testedInterestRate = RateDAL.getRate(685);
//		
//		assertTrue(testedInterestRate == 4.5);
//
//	}
//	
//	@Test
//	public void testGetRate600() {
//		double testedInterestRate = RateDAL.getRate(605);
//		
//		assertTrue(testedInterestRate == 5);
//
//	}

}
}
