package validation;



import common.TradeStoreConstant;
import tradeStore.TradeStatus;
import tradeStore.TradeVo;
import utils.TradeStoreDateUtil;

public class MaturityDateValidation implements TradeValidator {

	public MaturityDateValidation() {
	}

	@Override
	public void validate(TradeVo tradeVo) {
		
		if (!TradeStoreDateUtil.isValidDate(tradeVo.getMaturityDate())) {
			tradeVo.setTradeStatus(TradeStatus.InValidTrade);
			tradeVo.setValidationMessage(TradeStoreConstant.INVALID_MATURITY_DATE);
		}
	}


}
