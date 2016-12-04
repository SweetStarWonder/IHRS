package vo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.RoomDao;
import po.ListPO;
import po.ListStatus;
import po.RoomPO;
import rmi.RemoteHelper;

public class ListVO {

	private int listId;
	
	private int hotelId;
	
	private int userId;
	
	private ListStatus status;
	
	private String entryTime;
	
	private String lastTime;
	
	private String lastListExecutedTime;
	
	private int price;
	
	private boolean ifHaveChild;
	
	private ArrayList<RoomVO> rooms;
	
	public ListVO(ListPO listPO){
		this.listId=listPO.getListId();
		this.hotelId=listPO.getHotelId();
		this.userId=listPO.getUserId();
		this.status=listPO.getStatus();
		this.entryTime=listPO.getEntryTime();
		this.lastTime=listPO.getLastTime();
		this.lastListExecutedTime=listPO.getLastListExecutedTime();
		this.price=listPO.getPrice();
		this.ifHaveChild=listPO.isIfHaveChild();
		RoomDao roomDao=RemoteHelper.getInstance().getRoomDao();
		try {
			ArrayList<RoomPO> roomPOs=roomDao.getRoomByList(listPO.getListId());
			this.rooms=new ArrayList<RoomVO>();
			for (RoomPO roomPO : roomPOs) {
				this.rooms.add(new RoomVO(roomPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public ListVO(int listId, int hotelId, int userId, ListStatus status,
			String entryTime, String lastTime,String lastListExecutedTime,int price,boolean ifHaveChild) {
		this.listId=listId;
		this.hotelId = hotelId;
		this.userId = userId;
		this.status = status;
		this.entryTime = entryTime;
		this.lastTime = lastTime;
		this.lastListExecutedTime=lastListExecutedTime;
		this.price = price;
		this.ifHaveChild=ifHaveChild;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ListStatus getStatus() {
		return status;
	}

	public void setStatus(ListStatus status) {
		this.status = status;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ArrayList<RoomVO> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<RoomVO> rooms) {
		this.rooms = rooms;
	}

	public int getListId() {
		return listId;
	}

	public void setListid(int listId) {
		this.listId = listId;
	}

	public String getLastListExecutedTime() {
		return lastListExecutedTime;
	}

	public void setLastListExecutedTime(String lastListExecutedTime) {
		this.lastListExecutedTime = lastListExecutedTime;
	}

	public boolean isIfHaveChild() {
		return ifHaveChild;
	}

	public void setIfHaveChild(boolean ifHaveChild) {
		this.ifHaveChild = ifHaveChild;
	}
	
}
