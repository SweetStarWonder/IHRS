package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.hotelblservice.HotelOperationService;
import data.dao.EvaluateDao;
import data.dao.HotelDao;
import data.dao.ListDao;
import data.dao.RoomDao;
import po.EvaluatePO;
import po.HotelPO;
import po.ListPO;
import po.RoomPO;
import rmi.RemoteHelper;
import vo.EvaluateVO;
import vo.HotelVO;
import vo.RoomVO;

public class HotelOperationServiceImpl implements HotelOperationService{
	
	private EvaluateDao evaluateDao;
	
	private HotelDao hotelDao;
	
	private RoomDao roomDao;
	
	private ListDao listDao;
	
	public HotelOperationServiceImpl(){
		this.evaluateDao=RemoteHelper.getInstance().getEvaluateDao();
		this.hotelDao=RemoteHelper.getInstance().getHotelDao();
		this.roomDao=RemoteHelper.getInstance().getRoomDao();
	}

	public boolean addHotel(HotelVO hotelVO) {
		boolean add = false;
		try {
			add = hotelDao.addHotel(new HotelPO(hotelVO.getId(), hotelVO.getPartners(), hotelVO.getHotelName(), hotelVO.getPosition(), hotelVO.getBusinessDistrict(), hotelVO.getStarRating(), hotelVO.getIntroduction(), hotelVO.getFacility()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return add;
	}
	
	public HotelVO evaluateHotel(EvaluatePO evaluatePO, HotelVO hotelVO) {
		try {
			evaluateDao.addEvaluate(evaluatePO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<EvaluateVO> evaluateVOs=hotelVO.getEvaluates();
		evaluateVOs.add(new EvaluateVO(evaluatePO));
		hotelVO.setEvaluates(evaluateVOs);
		return hotelVO;
	}

	public boolean modifyHotelInformation(HotelVO hotelVO) {
		boolean modify = false;
		try {
			modify = hotelDao.update(new HotelPO(hotelVO.getId(),hotelVO.getPartners(), hotelVO.getHotelName(), hotelVO.getPosition(), 
					hotelVO.getBusinessDistrict(), hotelVO.getStarRating(),hotelVO.getIntroduction(), hotelVO.getFacility()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return modify;
	}

	public boolean addRooms(ArrayList<RoomVO> roomVOs) {
		boolean add = true;
		for (RoomVO roomVO : roomVOs) {
			try {
				boolean room = roomDao.addRoom(new RoomPO(roomVO.getHotelId(),roomVO.getListId(),roomVO.getRoomNum(),roomVO.getPrice(),roomVO.getStatus()));
				add = add && room;
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		}
		return add;
	}


	public boolean updateCheckOut(ArrayList<RoomVO> roomVOs) {
		boolean update = true;
		for (RoomVO roomVO : roomVOs) {
			try {
				roomVO.setListId(0);
				boolean room = false;
				room = roomDao.updateRoom(new RoomPO(roomVO.getHotelId(), roomVO.getListId(), roomVO.getRoomNum(), roomVO.getPrice(), roomVO.getStatus()));
				update = update && room;
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return update;
	}
	
	
}