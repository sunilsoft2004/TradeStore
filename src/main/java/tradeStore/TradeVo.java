package tradeStore;

import java.util.Date;

public class TradeVo {
	
	private String tradeId;
	private int version;
	private String counterPartyId;
	private String bookId;
	private String maturityDate;
	private Date createdDate;

	private TradeStatus tradeStatus;
	private String validationMessage;
	
	public TradeVo(String tradeId, int version, String counterPartyId, String bookId, String maturityDate,
			Date createdDate, TradeStatus tradeStatus) {
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.tradeStatus = tradeStatus;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public TradeStatus getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(TradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}

	@Override
	public String toString() {
		return "TradeVo [tradeId=" + tradeId + ", version=" + version + ", counterPartyId=" + counterPartyId
				+ ", bookId=" + bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate
				+ ", tradeStatus=" + tradeStatus + ", validationMessage=" + validationMessage + "]";
	}
	
	

}
