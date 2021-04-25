package storage;

import tradeStore.TradeVo;

public interface Storage {
	
	public TradeVo addTrade(TradeVo tradeVo);

	public TradeVo getExistingTrade(String tradeId);
}