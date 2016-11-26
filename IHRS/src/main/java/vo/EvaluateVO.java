package vo;

public class EvaluateVO {
	
	private String customerName;
	private int rankValue;
	private String contents;
	
	public EvaluateVO(String customerName,int rankValue,String contents) {
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

	public int getRankValue() {
		return rankValue;
	}

	public void setRankValue(int rankValue) {
		this.rankValue = rankValue;
	}

}
