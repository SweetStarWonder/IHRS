package po;

public class EvaluatePO {
	
	private int hotelId;
	private String customerName;
	private int starRating;
	private String contents;
	
	public EvaluatePO(int hotelId,String customerName,int starRating,String contents) {
		this.setHotelId(hotelId);
		this.setCustomerName(customerName);
		this.setStarRating(starRating);
		this.setContents(contents);
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
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

}
