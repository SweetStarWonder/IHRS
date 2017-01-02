package businesslogic.listbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.creditbl.CreditBlServiceImpl;
import businesslogic.hotelbl.HotelOperationServiceImpl;
import businesslogic.userbl.FindUserServiceImpl;
import businesslogicservice.creditblservice.CreditBlService;
import businesslogicservice.hotelblservice.HotelOperationService;
import businesslogicservice.listblservice.ListOperationService;
import businesslogicservice.userblservice.FindUserService;
import data.dao.ListDao;
import po.ListPO;
import po.ListStatus;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.ListVO;
import vo.RoomVO;

public class ListOperationServiceImpl implements ListOperationService{

	private ListDao listDao;
	
	public ListOperationServiceImpl() {
		this.listDao = RemoteHelper.getInstance().getListDao();
	}

	public ListVO revokeList(ListVO listVO, String timeNow) {
		listVO.setStatus(ListStatus.REVOKED);
		if (Math.abs(convertTime(timeNow)-convertTime(listVO.getLastListExecutedTime())) < 6) {
			FindUserService findUserService = new FindUserServiceImpl();
			CustomerVO customerVO = findUserService.getCustomer(listVO.getUserId());
			CreditBlService creditBlService = new CreditBlServiceImpl(customerVO, timeNow);
			creditBlService.deductRevokeCredit(listVO);
		}
		listVO.setLastListExecutedTime(timeNow);
		updateList(listVO);
		return listVO;
	}

	public ListVO updateCheckIn(ListVO listVO, String timeNow) {
		listVO.setEntryTime(timeNow);
		listVO.setStatus(ListStatus.EXECUTED);
		updateList(listVO);
		return listVO;
	}
	
	public ListVO updateCheckOut(ListVO listVO, String timeNow) {
		listVO.setLastTime(timeNow);
		updateList(listVO);
		ArrayList<RoomVO> roomVOs = listVO.getRooms();
		HotelOperationService hotelOperationService = new HotelOperationServiceImpl();
		hotelOperationService.updateCheckOut(roomVOs);
		return listVO;
	}

	public ListVO executeList(ListVO listVO, String timeNow) {
		listVO = updateCheckIn(listVO, timeNow);
		updateList(listVO);
		FindUserService findUserService = new FindUserServiceImpl();
		CustomerVO customerVO = findUserService.getCustomer(listVO.getUserId());
		CreditBlService creditBlService = new CreditBlServiceImpl(customerVO, timeNow);
		listVO.setPrice(listVO.getPrice()*2);
		creditBlService.recoverCredit(listVO);
		listVO.setPrice(listVO.getPrice()/2);
		return listVO;
	}

	public ListVO setAbnormal(ListVO listVO, String timeNow) {
		listVO.setStatus(ListStatus.ABNORMAL);
		updateList(listVO);
		FindUserService findUserService = new FindUserServiceImpl();
		CustomerVO customerVO = findUserService.getCustomer(listVO.getUserId());
		CreditBlService creditBlService = new CreditBlServiceImpl(customerVO, timeNow);
		creditBlService.deductAbnormalCredit(listVO);
		return listVO;
	}

	public ListVO lateCheckIn(ListVO listVO, String timeNow) {
		return executeList(listVO, timeNow);
	}

	public ListVO revokeAbnormalList(ListVO listVO, String revokeTime, boolean isHalf) {
		listVO.setStatus(ListStatus.REVOKED);
		listVO.setLastListExecutedTime(revokeTime);
		updateList(listVO);
		FindUserService findUserService = new FindUserServiceImpl();
		CustomerVO customerVO = findUserService.getCustomer(listVO.getUserId());
		CreditBlService creditBlService = new CreditBlServiceImpl(customerVO, revokeTime);
		if (isHalf) {
			creditBlService.recoverCredit(listVO);
		} else {
			listVO.setPrice(listVO.getPrice()*2);
			creditBlService.recoverCredit(listVO);
			listVO.setPrice(listVO.getPrice()/2);
		}
		return listVO;
	}
	
	
	private boolean updateList(ListVO listVO) {
		boolean update = false;
		try {
			update = listDao.updateList(new ListPO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), listVO.getStatus(),
					listVO.getEntryTime(), listVO.getLastTime(), listVO.getLastListExecutedTime(), listVO.getPrice(), listVO.isIfHaveChild()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return update;
	}
	
	private int convertTime(String time) {
		String timeNow = time.substring(0, 4) + time.substring(5, 7) + time.substring(8, 10) + time.substring(11, 13);
		int intTime = Integer.valueOf(timeNow);
		return intTime;
	}

	
}
