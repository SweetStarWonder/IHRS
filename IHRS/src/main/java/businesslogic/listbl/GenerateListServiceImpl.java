package businesslogic.listbl;


import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.hotelbl.HotelOperationServiceImpl;
import businesslogic.promotionbl.HotelPromotionBlServiceImpl;
import businesslogic.promotionbl.NormalVipPromotionBlServiceImpl;
import businesslogic.promotionbl.WebPromotionBlServiceImpl;
import businesslogicservice.hotelblservice.HotelOperationService;
import businesslogicservice.listblservice.GenerateListService;
import businesslogicservice.promotionblservice.HotelPromotionBlService;
import businesslogicservice.promotionblservice.NormalVipPromotionBlService;
import businesslogicservice.promotionblservice.WebPromotionBlService;
import data.dao.CreditChangeDao;
import data.dao.ListDao;
import data.dao.RoomDao;
import po.CreditChangePO;
import po.ListPO;
import po.ListStatus;
import po.RoomPO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.ListVO;
import vo.NormalVipVO;
import vo.RoomVO;

public class GenerateListServiceImpl implements GenerateListService{
	
	private ListDao listDao;
	
	private CreditChangeDao creditChangeDao;
	
	private RoomDao roomDao;
	
	private HotelOperationService hotelOperationService;
	
	public GenerateListServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		listDao=remoteHelper.getListDao();
		creditChangeDao=remoteHelper.getCreditChangeDao();
		roomDao = remoteHelper.getRoomDao();
	}
	
	public int generateList(ListVO listVO, CustomerVO customerVO,String timeNow) {
		if(getCreditResult(customerVO.getId())<0){
			return -1;
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
			listVO.setListid(convertTime(timeNow)+(int)(Math.random()*900)+100);
			hotelOperationService = new HotelOperationServiceImpl();
			hotelOperationService.updateCheckIn(listVO.getRooms(), listVO.getListId());
			ListPO listPO = new ListPO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), listVO.getStatus(), listVO.getEntryTime(), listVO.getLastTime(), listVO.getLastListExecutedTime(), listVO.getPrice(), listVO.isIfHaveChild());
			try {
				listDao.addList(listPO);
				ArrayList<RoomPO> roomPOs = new ArrayList<RoomPO>();
				ArrayList<RoomVO> roomVOs = listVO.getRooms();
				for (RoomVO roomVO : roomVOs) {
					roomPOs.add(new RoomPO(roomVO.getHotelId(), roomVO.getListId(), roomVO.getRoomNum(), roomVO.getPrice(), roomVO.getStatus()));
				}
				roomDao.updateRoom(listPO,roomPOs);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return listVO.getPrice();
		}
	}

	public int generateList(ListVO listVO, NormalVipVO normalVipVO, String timeNow) {
		if(getCreditResult(normalVipVO.getId())<0){
			return -1;
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
			listVO.setListid(convertTime(timeNow)+(int)(Math.random()*900)+100);
			hotelOperationService = new HotelOperationServiceImpl();
			hotelOperationService.updateCheckIn(listVO.getRooms(), listVO.getListId());
			ListPO listPO = new ListPO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), listVO.getStatus(), listVO.getEntryTime(), listVO.getLastTime(), listVO.getLastListExecutedTime(), listVO.getPrice(), listVO.isIfHaveChild());
			try {
				listDao.addList(listPO);
				ArrayList<RoomPO> roomPOs = new ArrayList<RoomPO>();
				ArrayList<RoomVO> roomVOs = listVO.getRooms();
				for (RoomVO roomVO : roomVOs) {
					roomPOs.add(new RoomPO(roomVO.getHotelId(), roomVO.getListId(), roomVO.getRoomNum(), roomVO.getPrice(), roomVO.getStatus()));
				}
				roomDao.updateRoom(listPO,roomPOs);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return listVO.getPrice();
		}
	}

	public int generateList(ListVO listVO, EnterpriseVipVO enterpriseVipVO, String timeNow) {
		if(getCreditResult(enterpriseVipVO.getId())<0){
			return -1;
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
			listVO.setListid(convertTime(timeNow)+(int)(Math.random()*900)+100);
			hotelOperationService = new HotelOperationServiceImpl();
			hotelOperationService.updateCheckIn(listVO.getRooms(), listVO.getListId());
			ListPO listPO = new ListPO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), listVO.getStatus(), listVO.getEntryTime(), listVO.getLastTime(), listVO.getLastListExecutedTime(), listVO.getPrice(), listVO.isIfHaveChild());
			try {
				listDao.addList(listPO);
				ArrayList<RoomPO> roomPOs = new ArrayList<RoomPO>();
				ArrayList<RoomVO> roomVOs = listVO.getRooms();
				for (RoomVO roomVO : roomVOs) {
					roomPOs.add(new RoomPO(roomVO.getHotelId(), roomVO.getListId(), roomVO.getRoomNum(), roomVO.getPrice(), roomVO.getStatus()));
				}
				roomDao.updateRoom(listPO,roomPOs);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return listVO.getPrice();
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
			if(creditChangePO.getTime().compareToIgnoreCase(time) > 0){
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
