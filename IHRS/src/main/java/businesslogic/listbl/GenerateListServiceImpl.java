package businesslogic.listbl;


import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.promotionbl.HotelPromotionBlServiceImpl;
import businesslogic.promotionbl.NormalVipPromotionBlServiceImpl;
import businesslogic.promotionbl.WebPromotionBlServiceImpl;
import businesslogicservice.listblservice.GenerateListService;
import businesslogicservice.promotionblservice.HotelPromotionBlService;
import businesslogicservice.promotionblservice.NormalVipPromotionBlService;
import businesslogicservice.promotionblservice.WebPromotionBlService;
import data.dao.CreditChangeDao;
import data.dao.ListDao;
import po.CreditChangePO;
import po.ListStatus;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.ListVO;
import vo.NormalVipVO;

public class GenerateListServiceImpl implements GenerateListService{  //三种用户下单
	
	ListDao listDao;
	
	CreditChangeDao creditChangeDao;
	
	

	public GenerateListServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		listDao=remoteHelper.getListDao();
		creditChangeDao=remoteHelper.getCreditChangeDao();
	}
	
	public boolean generateList(ListVO listVO, CustomerVO customerVO,String timeNow) {
		if(getCreditResult(customerVO.getId())<0){
			return false;
		}
		else{
			listVO.setStatus(ListStatus.NOTEXECUTED);
			boolean isThreeMore=false;
			if(listVO.getRooms().size()>=3){
				isThreeMore=true;
			}
			HotelPromotionBlService hotelPromotionBlService = new HotelPromotionBlServiceImpl();
			WebPromotionBlService webPromotionBlService = new WebPromotionBlServiceImpl();
			double minDiscount=1.0;
			double minDiscountByhotel=hotelPromotionBlService.getMinDiscountForCustomer(listVO.getHotelId(), timeNow, isThreeMore);
			double minDiscountByWeb=webPromotionBlService.getMinDiscountInWeb(timeNow);
			if(minDiscountByhotel<=minDiscountByWeb){
				minDiscount=minDiscountByhotel;
			}
			else{
				minDiscount=minDiscountByWeb;
			}
			listVO.setPrice((int)(listVO.getPrice()*minDiscount));
			listVO.setListid(convertTime(timeNow));
			return true;
		}
	}

	public boolean generateList(ListVO listVO, NormalVipVO normalVipVO, String timeNow) {
		if(getCreditResult(normalVipVO.getId())<0){
			return false;
		}
		else{
			listVO.setStatus(ListStatus.NOTEXECUTED);
			boolean isThreeMore=false;
			if(listVO.getRooms().size()>=3){
				isThreeMore=true;
			}
			boolean isBirthday=false;
			if(timeNow.split(" ")[0].equals(normalVipVO.getBirthday())){
				isBirthday=true;
			}
			HotelPromotionBlService hotelPromotionBlService = new HotelPromotionBlServiceImpl();
			WebPromotionBlService webPromotionBlService = new WebPromotionBlServiceImpl();
			NormalVipPromotionBlService normalVipPromotionBlService = new NormalVipPromotionBlServiceImpl();
			double minDiscount=1.0;
			double minDiscountByhotel=hotelPromotionBlService.getMinDiscountForNormalVip(listVO.getHotelId(), timeNow, isThreeMore, isBirthday);
			double minDiscountByWeb=webPromotionBlService.getMinDiscountInWeb(timeNow);
			double minDiscountBySelf=normalVipPromotionBlService.getMinDiscountForNormalVip(listVO.getHotelId(),normalVipVO.getRank());
			if(minDiscountByhotel<=minDiscountByWeb){
				minDiscount=minDiscountByhotel;
			}
			else{
				minDiscount=minDiscountByWeb;
			}
			if(minDiscount>minDiscountBySelf){
				minDiscount=minDiscountBySelf;
			}
			listVO.setPrice((int)(listVO.getPrice()*minDiscount));
			listVO.setListid(convertTime(timeNow));
			return true;
		}
	}

	public boolean generateList(ListVO listVO, EnterpriseVipVO enterpriseVipVO, String timeNow) {
		if(getCreditResult(enterpriseVipVO.getId())<0){
			return false;
		}
		else{
			listVO.setStatus(ListStatus.NOTEXECUTED);
			boolean isThreeMore=false;
			if(listVO.getRooms().size()>=3){
				isThreeMore=true;
			}
			HotelPromotionBlService hotelPromotionBlService = new HotelPromotionBlServiceImpl();
			WebPromotionBlService webPromotionBlService = new WebPromotionBlServiceImpl();
			double minDiscount=1.0;
			double minDiscountByhotel=hotelPromotionBlService.getMinDiscountForEnterPriseVip(listVO.getHotelId(), timeNow, isThreeMore);
			double minDiscountByWeb=webPromotionBlService.getMinDiscountInWeb(timeNow);
			if(minDiscountByhotel<=minDiscountByWeb){
				minDiscount=minDiscountByhotel;
			}
			else{
				minDiscount=minDiscountByWeb;
			}
			listVO.setPrice((int)(listVO.getPrice()*minDiscount));
			listVO.setListid(convertTime(timeNow));
			return true;
		}
	}
	
	private int getCreditResult(int userId){
		ArrayList<CreditChangePO> creditChanges=new ArrayList<CreditChangePO>();
		try {
			creditChanges=creditChangeDao.getCreditChange(userId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		String time="";
		int resultValue=0;
		for (CreditChangePO creditChangePO : creditChanges) {
			if(creditChangePO.getTime().compareToIgnoreCase(time)==1){
				time=creditChangePO.getTime();
				resultValue=creditChangePO.getResult();
			}
		}
		return resultValue;
	}
	
	private int convertTime(String time) {
		String timeNow = time.substring(0, 4) + time.substring(5, 7) + time.substring(8, 10) + time.substring(11, 13);
		int intTime = Integer.valueOf(timeNow);
		return intTime;
	}
}
