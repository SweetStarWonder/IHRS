package po;

import java.io.Serializable;

/**
 * hotelId       酒店编号
 * customerName  用户名
 * rankValue     评分
 * contents      评价内容
 */
public class EvaluatePO implements Serializable {

	private static final long serialVersionUID = -3112769942917761302L;
	
	
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
