package vo;

import java.util.ArrayList;

import po.ListStatus;

/**
 * id			订单编号
 * hotelId		酒店编号
 * userId		用户编号
 * status		订单状态（0：未执行订单；1：已执行订单；2：异常订单）
 * entryTime	用户入住时间
 * lastTime		订单最晚执行时间
 * orderInfo	订单详情
 * price		订单价值
 */

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
	
	public ListVO(){
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
