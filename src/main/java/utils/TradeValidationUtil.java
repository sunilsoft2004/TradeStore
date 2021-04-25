package utils;

import java.util.List;

import tradeStore.TradeVo;
import validation.TradeValidator;

public class TradeValidationUtil {
	
	private TradeValidationUtil() {
		
	}
	
	private static List<TradeValidator> lists;
	
	static void validateTrade(TradeVo tradeVo) {
		
		for (TradeValidator validation : lists) {
			validation.validate(tradeVo);			
		}
		
	}

}
