package edu.neumont.csc180.rosado.jose;

public class StockTrade {
	private String type;
	private String stockSymbol;
	private Long countShares;
	private String pricePerShare;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public Long getCountShares() {
		return countShares;
	}
	public void setCountShares(Long countShares) {
		this.countShares = countShares;
	}
	public String getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(String pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	
	@Override
	public String toString() {
		return "[Type: " + type + ", Stock Symbol: " + stockSymbol + ", Count Shares: " + countShares +
			   ", Price per Share: " + pricePerShare + "]";
	}
}
