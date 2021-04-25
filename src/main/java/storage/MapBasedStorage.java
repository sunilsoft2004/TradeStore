package storage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import tradeStore.TradeStatus;
import tradeStore.TradeVo;

public class MapBasedStorage implements Storage {
	
	Map<String, TradeVo> storage;

	public MapBasedStorage() {
		storage = new HashMap<>();
	}

	@Override
	public TradeVo addTrade(TradeVo tradeVo) {
		tradeVo.setCreatedDate(new Date());
		tradeVo.setTradeStatus(TradeStatus.Not_Expired);
		storage.put(tradeVo.getTradeId(), tradeVo);
		return tradeVo;
	}

	@Override
	public TradeVo getExistingTrade(String tradeId) {
		return storage.get(tradeId);
	}

}
