package utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tradeException.InvalidMaturityDate;

public class TradeStoreDateUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsInValidDate() {		
		assertFalse("should not be be valid date as less then current data", TradeStoreDateUtil.isValidDate("21-04-2021 06:07:10 AM"));
		assertFalse("should not be be valid date as less then current data", TradeStoreDateUtil.isValidDate("25-04-2021 06:07:10 AM"));
		assertTrue("should be valid date", TradeStoreDateUtil.isValidDate("26-04-2021 06:07:10 AM"));
		assertTrue("should be valid date", TradeStoreDateUtil.isValidDate("21-01-2022 06:07:10 AM"));
	}
	
	@Test(expected = InvalidMaturityDate.class)
	public void testIsInValidDate_Exception() {	
		TradeStoreDateUtil.isValidDate("25-25-2021 06:07:10 AM");
	}
	
	@Test(expected = InvalidMaturityDate.class)
	public void testIsInValidDate_ExceptionCase2() {	
		TradeStoreDateUtil.isValidDate("25/01/2021 06:07:10 AM");
	}

}
