package validation;


import common.TradeStoreConstant;
import storage.Storage;
import tradeException.InvalidVersion;
import tradeStore.TradeStatus;
import tradeStore.TradeVo;

public class VersionValidation implements TradeValidator {

	private Storage storage;

	public VersionValidation(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void validate(TradeVo tradeVo) {
		TradeVo existingTrade = storage.getExistingTrade(tradeVo.getTradeId());
		if (existingTrade != null && existingTrade.getVersion() > tradeVo.getVersion()) {
			tradeVo.setTradeStatus(TradeStatus.InValidTrade);
			tradeVo.setValidationMessage(TradeStoreConstant.INVALID_VERSION);
			
			throw new InvalidVersion(TradeStoreConstant.INVALID_VERSION);
		}

	}

}
