package po;

import java.util.ArrayList;

public class HotelPO {

	private int id;
	
	private ArrayList<String> partners;
	
	private String hotelName;
	
	private String position;  //地址
	
	private String businessDistrict;  //商圈
	
	private int starRating;  //星级
	
	private String introduction;  //简介
	
	private String facility;  //设施服务
	
	
	
	public HotelPO(int id,ArrayList<String> partners,String hotelName,
			String position,String businessDistrict,int starRating,String introduction,String facility){
		this.id=id;
		this.hotelName=hotelName;
		
		this.partners=partners;
		
		this.position=position;
		this.businessDistrict=businessDistrict;
		this.starRating=starRating;
		this.introduction=introduction;
		this.facility=facility;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public ArrayList<String> getPartners() {
		return partners;
	}

	public void setPartners(ArrayList<String> partners) {
		this.partners = partners;
	}

	public String getBusinessDistrict() {
		return businessDistrict;
	}

	public void setBusinessDistrict(String businessDistrict) {
		this.businessDistrict = businessDistrict;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}
	
}
