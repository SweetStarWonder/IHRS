package businesslogic.promotionbl;


import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.promotionblservice.HotelPromotionBlService;
import data.dao.HotelPromotionDao;
import po.promotionPO.HotelPromotionPO;
import po.promotionPO.HotelPromotionType;
import rmi.RemoteHelper;
import vo.promotionVO.HotelPromotionVO;

public class HotelPromotionBlServiceImpl implements HotelPromotionBlService{
	
	private HotelPromotionDao hotelPromotionDao;
	
	public HotelPromotionBlServiceImpl(){
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		this.hotelPromotionDao=remoteHelper.getHotelPromotionDao();
	}
	
	public ArrayList<HotelPromotionVO> getHotelPromotions(int hotelId) {
		ArrayList<HotelPromotionPO> hotelPromotionPOs;
		ArrayList<HotelPromotionVO> hotelPromotionVOs=new ArrayList<HotelPromotionVO>();
		try {
			hotelPromotionPOs = hotelPromotionDao.getHotelPromotions(hotelId);
			for (HotelPromotionPO hotelPromotionPO : hotelPromotionPOs) {
				hotelPromotionVOs.add(new HotelPromotionVO(hotelPromotionPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelPromotionVOs;
	}
	
	public boolean addHotelPromotion(HotelPromotionVO hotelPromotionVO){
		boolean add=false;
		try {
			add=hotelPromotionDao.addHotelPromotion(new HotelPromotionPO(hotelPromotionVO.getDiscount(),hotelPromotionVO.getDiscountName(),
					hotelPromotionVO.getHotelId(),hotelPromotionVO.getHotelPromotionType(),hotelPromotionVO.getStartTime(),hotelPromotionVO.getEndTime()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return add;
	}

	public boolean deleteHotelPromotion(HotelPromotionVO hotelPromotionVO) {
		boolean delete=false;
		try {
			delete=hotelPromotionDao.deleteHotelPromotion(new HotelPromotionPO(hotelPromotionVO.getDiscount(),hotelPromotionVO.getDiscountName(),
						hotelPromotionVO.getHotelId(),hotelPromotionVO.getHotelPromotionType(),hotelPromotionVO.getStartTime(),hotelPromotionVO.getEndTime()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return delete;
	}

	public double getMinDiscountForCustomer(int hotelId,String timeNow,boolean isThreeMore) {
		ArrayList<HotelPromotionVO> hotelPromotionVOs=getHotelPromotions(hotelId);
		ArrayList<HotelPromotionVO> hotelPromotions=new ArrayList<HotelPromotionVO>();
		double minDiscount=1.0;
		
		for (HotelPromotionVO hotelPromotionVO : hotelPromotionVOs) {

			if(hotelPromotionVO.getHotelPromotionType().equals(HotelPromotionType.DOUBLE11)){  //双十一
				int nowTime=convertTime(timeNow);
				int startTime=convertTime(hotelPromotionVO.getStartTime());
				int endTime=convertTime(hotelPromotionVO.getEndTime());
				if(nowTime>=startTime && nowTime<=endTime){
					hotelPromotions.add(hotelPromotionVO);
				}
			}
			if(hotelPromotionVO.getHotelPromotionType().equals(HotelPromotionType.THREEMORE)){  //三间以上
				if(isThreeMore)
					hotelPromotions.add(hotelPromotionVO);
			}
		}
		
		for(HotelPromotionVO hotelPromotionVO : hotelPromotions){
			double tmpDiscount=hotelPromotionVO.getDiscount();
			if(tmpDiscount<=minDiscount){
				minDiscount=tmpDiscount;
			}
		}
		return minDiscount;
	}

	public double getMinDiscountForEnterPriseVip(int hotelId,String timeNow,boolean isThreeMore) {
		ArrayList<HotelPromotionVO> hotelPromotionVOs=getHotelPromotions(hotelId);
		ArrayList<HotelPromotionVO> hotelPromotions=new ArrayList<HotelPromotionVO>();
		double minDiscount=1.0;
		
		for (HotelPromotionVO hotelPromotionVO : hotelPromotionVOs) {
			
			if(hotelPromotionVO.getHotelPromotionType().equals(HotelPromotionType.ENTERPRISE)){  //企业会员
				hotelPromotions.add(hotelPromotionVO);
			}
			
			if(hotelPromotionVO.getHotelPromotionType().equals(HotelPromotionType.DOUBLE11)){  //双十一
				int nowTime=convertTime(timeNow);
				int startTime=convertTime(hotelPromotionVO.getStartTime());
				int endTime=convertTime(hotelPromotionVO.getEndTime());
				if(nowTime>=startTime && nowTime<=endTime){
					hotelPromotions.add(hotelPromotionVO);
				}
			}
			if(hotelPromotionVO.getHotelPromotionType().equals(HotelPromotionType.THREEMORE)){  //三间以上
				if(isThreeMore)
					hotelPromotions.add(hotelPromotionVO);
			}
		}
		
		for(HotelPromotionVO hotelPromotionVO : hotelPromotions){
			double tmpDiscount=hotelPromotionVO.getDiscount();
			if(tmpDiscount<=minDiscount){
				minDiscount=tmpDiscount;
			}
		}
		return minDiscount;
	}
	
	public double getMinDiscountForNormalVip(int hotelId,String timeNow,boolean isThreeMore,boolean isBirthday){
		ArrayList<HotelPromotionVO> hotelPromotionVOs=getHotelPromotions(hotelId);
		ArrayList<HotelPromotionVO> hotelPromotions=new ArrayList<HotelPromotionVO>();
		double minDiscount=1.0;
		
		for (HotelPromotionVO hotelPromotionVO : hotelPromotionVOs) {
			
			if(hotelPromotionVO.getHotelPromotionType().equals(HotelPromotionType.DOUBLE11)){  //双十一
				int nowTime=convertTime(timeNow);
				int startTime=convertTime(hotelPromotionVO.getStartTime());
				int endTime=convertTime(hotelPromotionVO.getEndTime());
				if(nowTime>=startTime && nowTime<=endTime){
					hotelPromotions.add(hotelPromotionVO);
				}
			}
			if(hotelPromotionVO.getHotelPromotionType().equals(HotelPromotionType.THREEMORE)){  //三间以上
				if(isThreeMore)
					hotelPromotions.add(hotelPromotionVO);
			}
			if(hotelPromotionVO.getHotelPromotionType().equals(HotelPromotionType.BIRTHDAY)){  //生日情形
				if(isBirthday)
					hotelPromotions.add(hotelPromotionVO);
			}
		}
		
		for(HotelPromotionVO hotelPromotionVO : hotelPromotions){
			double tmpDiscount=hotelPromotionVO.getDiscount();
			if(tmpDiscount<=minDiscount){
				minDiscount=tmpDiscount;
			}
		}
		return minDiscount;
	}
	
	private int convertTime(String time) {
		String timeNow = time.substring(0, 4) + time.substring(5, 7) + time.substring(8, 10);
		int intTime = Integer.valueOf(timeNow);
		return intTime;
	}

}
