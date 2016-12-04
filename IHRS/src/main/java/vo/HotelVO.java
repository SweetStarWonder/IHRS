package vo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.EvaluateDao;
import data.dao.RoomDao;
import po.EvaluatePO;
import po.HotelPO;
import po.RoomPO;
import rmi.RemoteHelper;

public class HotelVO {

	private int id;
	
	private ArrayList<RoomVO> rooms;
	
	private ArrayList<PromotionVO> promotions;
	
	private ArrayList<String> partners;
	
	private ArrayList<EvaluateVO> evaluates;
	
	private String hotelName;
	
	private String position;  //地址
	
	private String businessDistrict;  //商圈
	
	private int starRating;  //星级
	
	private String introduction;  //简介
	
	private String facility;  //设施服务
	
	private double averageRank;  //总评
	
	public HotelVO(int id,ArrayList<RoomVO> rooms,ArrayList<PromotionVO> promotions,ArrayList<String> partners,ArrayList<EvaluateVO> evaluates,
			String hotelName,String position,String businessDistrict,int starRating,String introduction,String facility,double averageRank){
		this.id=id;
		this.hotelName=hotelName;
		
		this.rooms=rooms;
		this.promotions=promotions;
		this.partners=partners;
		this.evaluates=evaluates;
		
		this.position=position;
		this.businessDistrict=businessDistrict;
		this.starRating=starRating;
		this.introduction=introduction;
		this.facility=facility;
		this.averageRank=averageRank;
		
	}
	
	public HotelVO(HotelPO hotelPO) {
		this.id = hotelPO.getId();
		this.hotelName = hotelPO.getHotelName();
		this.position = hotelPO.getPosition();
		this.businessDistrict = hotelPO.getBusinessDistrict();
		this.starRating = hotelPO.getStarRating();
		this.facility = hotelPO.getFacility();
		this.partners = hotelPO.getPartners();
		
		RoomDao roomDao = RemoteHelper.getInstance().getRoomDao();
		try {
			ArrayList<RoomPO> roomPOs = roomDao.getRoomsByHotel(hotelPO.getId());
			rooms = new ArrayList<RoomVO>();
			for (RoomPO roomPO : roomPOs) {
				rooms.add(new RoomVO(roomPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		EvaluateDao evaluateDao = RemoteHelper.getInstance().getEvaluateDao();
		try {
			ArrayList<EvaluatePO> evaluatePOs = evaluateDao.getEvaluates(hotelPO.getId());
			this.averageRank = calculateRank(evaluatePOs);
			
			evaluates = new ArrayList<EvaluateVO>();
			for (EvaluatePO evaluatePO : evaluatePOs) {
				evaluates.add(new EvaluateVO(evaluatePO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
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

	public ArrayList<RoomVO> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<RoomVO> rooms) {
		this.rooms = rooms;
	}

	public ArrayList<PromotionVO> getPromotions() {
		return promotions;
	}

	public void setPromotions(ArrayList<PromotionVO> promotions) {
		this.promotions = promotions;
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

	public ArrayList<EvaluateVO> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(ArrayList<EvaluateVO> evaluates) {
		this.evaluates = evaluates;
	}

	public double getAverageRank() {
		return averageRank;
	}

	public void setAverageRank(double averageRank) {
		this.averageRank = averageRank;
	}
	
	
	private double calculateRank(ArrayList<EvaluatePO> evaluates){
		double total = 0.0;
		int num = 0;
		for (EvaluatePO evaluatePO : evaluates) {
			total += evaluatePO.getRankValue();
			num++;
		}
		return total / (double)num;
	}
	
}
