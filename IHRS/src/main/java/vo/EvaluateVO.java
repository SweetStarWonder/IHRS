package vo;

public class EvaluateVO {
	
	private String customerName;
	private int starRating;
	private String contents;
	
	public EvaluateVO(String customerName,int starRating,String contents) {
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

}
