package tradeStore;

public enum TradeStatus {
	Expired("N"), Not_Expired("Y"), InValidTrade("InValidTrade"); 
	
	private final String status;

	TradeStatus(String status) {
		this.status = status;
	}
	
	public String status() {
		return status;
	}

}
