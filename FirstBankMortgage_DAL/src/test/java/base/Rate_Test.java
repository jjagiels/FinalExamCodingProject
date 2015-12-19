package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void testGetRate800() {
		double testedInterestRate = RateDAL.getRate(815);
		
		assertTrue(testedInterestRate == 3.5);

	}
	
	@Test
	public void testGetRate750() {
		double testedInterestRate = RateDAL.getRate(765);
		
		assertTrue(testedInterestRate == 3.75);

	}
	
	@Test
	public void testGetRate700() {
		double testedInterestRate = RateDAL.getRate(725);
		
		assertTrue(testedInterestRate == 4);

	}
	
	@Test
	public void testGetRate650() {
		double testedInterestRate = RateDAL.getRate(685);
		
		assertTrue(testedInterestRate == 4.5);

	}
	
	@Test
	public void testGetRate600() {
		double testedInterestRate = RateDAL.getRate(605);
		
		assertTrue(testedInterestRate == 5);

	}

}
