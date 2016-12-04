package po;

public class EvaluatePO {
	
	private int hotelId;
	private String customerName;
	private int rankValue;
	private String contents;
	
	public EvaluatePO(int hotelId,String customerName,int rankValue,String contents) {
		this.setHotelId(hotelId);
		this.setCustomerName(customerName);
		this.setRankValue(rankValue);
		this.setContents(contents);
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRankValue() {
		return rankValue;
	}

	public void setRankValue(int rankValue) {
		this.rankValue = rankValue;
	}

}
