package tradeStore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import storage.MapBasedStorage;
import storage.Storage;
import tradeException.InvalidVersion;
import validation.MaturityDateValidation;
import validation.TradeValidator;
import validation.VersionValidation;

public class TradeStoreServiceTest {
	
	TradeStoreService underTest;
	Storage storage ;

	@Before
	public void setUp() throws Exception {
		storage = new MapBasedStorage();
		List<TradeValidator> tradeValidators = new ArrayList<TradeValidator>();
		tradeValidators.add(new VersionValidation(storage));
		tradeValidators.add(new MaturityDateValidation());
		
		underTest = new TradeStoreService(storage, tradeValidators);
	}
	

	@Test
	public void testStoreTrade() {

		TradeVo tradeVo = new TradeVo("T1", 1, "CP-1", "B1", "20-05-2022", null, null);		
		underTest.storeTrade(tradeVo);
		
		TradeVo storedTradeVo = storage.getExistingTrade("T1");
		
		assertTrue("should return non null object", storedTradeVo != null);
		assertTrue("should have non null createdate", storedTradeVo.getCreatedDate() != null);
		assertTrue("should have Not_Expired tradestatus", storedTradeVo.getTradeStatus() == TradeStatus.Not_Expired);
		
		System.out.println(storedTradeVo);
	}
	
	@Test
	public void testStoreTrade_update() {

		TradeVo tradeVo1 = new TradeVo("T1", 1, "CP-1", "B1", "22-04-2022", null, null);		
		underTest.storeTrade(tradeVo1);

		TradeVo tradeVo2 = new TradeVo("T1", 2, "CP-2", "B2", "22-04-2023", null, null);		
		underTest.storeTrade(tradeVo2);
		
		TradeVo savedTradeVo = storage.getExistingTrade("T1");		
		assertTrue("should return non null object", savedTradeVo != null);
		assertTrue("should have updated version", savedTradeVo.getVersion() == tradeVo2.getVersion());
		assertTrue("should have updated counter party id", "CP-2".equals(savedTradeVo.getCounterPartyId()));
	}
	

	@Test
	public void testStoreTrade_validationMaturityDate() {

		TradeVo tradeVo = new TradeVo("T1", 1, "CP-1", "B1", "22-04-2021", null, null);		
		underTest.storeTrade(tradeVo);
		
		TradeVo savedTradeVo = storage.getExistingTrade("T1");		
		assertTrue("should not get saved into storage as having invalid maturity date", savedTradeVo == null);
	}
	
	@Test(expected = InvalidVersion.class)
	public void testStoreTrade_validationVersion() {

		TradeVo tradeVo1 = new TradeVo("T1", 100, "CP-1", "B1", "22-04-2024", null, null);		
		underTest.storeTrade(tradeVo1);

		TradeVo tradeVo2 = new TradeVo("T1", 200, "CP-2", "B2", "22-04-2024", null, null);		
		underTest.storeTrade(tradeVo2);

		TradeVo tradeVo3 = new TradeVo("T1", 50, "CP-2", "B2", "22-04-2024", null, null);		
		underTest.storeTrade(tradeVo3);
	}
	


	@After
	public void tearDown() throws Exception {
		underTest = null;
	}

}
