package tradeStore;

import java.util.List;

import storage.Storage;
import validation.TradeValidator;

public class TradeStoreService {

	private final Storage storage;
	private final List<TradeValidator> tradeValidators;
	
	public TradeStoreService(Storage storage, List<TradeValidator> tradeValidators) {
		this.storage = storage;
		this.tradeValidators = tradeValidators;
	}
	
	public TradeVo storeTrade(TradeVo tradeVo) {	
		
		for (TradeValidator tradeValidator : tradeValidators) {
			tradeValidator.validate(tradeVo);
		}
		
		if(tradeVo.getTradeStatus() == TradeStatus.InValidTrade) {
			return tradeVo;
		} else {
			return storage.addTrade(tradeVo);
		} 		
	}

}
