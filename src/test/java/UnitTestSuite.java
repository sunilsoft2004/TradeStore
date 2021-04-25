

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tradeStore.TradeStoreServiceTest;
import utils.TradeStoreDateUtilTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TradeStoreServiceTest.class,
	TradeStoreDateUtilTest.class
})

public class UnitTestSuite {

}
