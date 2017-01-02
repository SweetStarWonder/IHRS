package vo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.EvaluateDao;
import data.dao.HotelPromotionDao;
import data.dao.RoomDao;
import po.EvaluatePO;
import po.HotelPO;
import po.RoomPO;
import po.promotionPO.HotelPromotionPO;
import rmi.RemoteHelper;
import vo.promotionVO.HotelPromotionVO;

/**
 * id                酒店编号
 * partners          合作企业名
 * hotelName         酒店名
 * position          地址
 * businessDistrict  商圈
 * starRating        酒店星级
 * introduction      简介
 * facility          设施服务
 * rooms             酒店所有房间信息
 * hotelPromotions   酒店所有促销策略
 * evaluates         酒店所有评价信息
 * averageRank       总评
 */
public class HotelVO {

	private int id;
	
	private ArrayList<RoomVO> rooms;
	
	private ArrayList<HotelPromotionVO> hotelPromotions;
	
	private ArrayList<String> partners;
	
	private ArrayList<EvaluateVO> evaluates;
	
	private String hotelName;
	
	private String position;
	
	private String businessDistrict;
	
	private int starRating;
	
	private String introduction;
	
	private String facility;
	
	private double averageRank;
	
	public HotelVO(int id,ArrayList<RoomVO> rooms,ArrayList<HotelPromotionVO> hotelPromotions,ArrayList<String> partners,ArrayList<EvaluateVO> evaluates,
			String hotelName,String position,String businessDistrict,int starRating,String introduction,String facility,double averageRank){
		this.id=id;
		this.hotelName=hotelName;
		this.rooms=rooms;
		this.setHotelPromotions(hotelPromotions);
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
		this.introduction = hotelPO.getIntroduction();
		
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
		
		HotelPromotionDao hotelPromotionDao=RemoteHelper.getInstance().getHotelPromotionDao();
		ArrayList<HotelPromotionPO> hotelPromotionPOs;
		try {
			hotelPromotionPOs = hotelPromotionDao.getHotelPromotions(hotelPO.getId());
			hotelPromotions=new ArrayList<HotelPromotionVO>();
			for (HotelPromotionPO hotelPromotionPO : hotelPromotionPOs) {
				hotelPromotions.add(new HotelPromotionVO(hotelPromotionPO));
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

	public ArrayList<HotelPromotionVO> getHotelPromotions() {
		return hotelPromotions;
	}

	public void setHotelPromotions(ArrayList<HotelPromotionVO> hotelPromotions) {
		this.hotelPromotions = hotelPromotions;
	}
	
	private double calculateRank(ArrayList<EvaluatePO> evaluates){
		double total = 0.0;
		int num = 0;
		if (evaluates.isEmpty()) {
			return total;
		} else {
			for (EvaluatePO evaluatePO : evaluates) {
				total += evaluatePO.getRankValue();
				num++;
			}
			return total / (double)num;
		}
	}

	
}
