package vo;

import po.RoomPO;
import po.RoomStatus;

public class RoomVO {
	private int hotelId;
	private int listId;
	private int roomNum;
	private int price;
	private RoomStatus status;
	
	public RoomVO(RoomPO roomPO){
		this.hotelId=roomPO.getHotelId();
		this.listId=roomPO.getListId();
		this.roomNum=roomPO.getRoomNum();
		this.price=roomPO.getPrice();
		this.status=roomPO.getStatus();
	}
	
	public RoomVO(int hotelId,int listId,int roomNum,int price,RoomStatus status){
		this.hotelId=hotelId;
		this.listId=listId;
		this.roomNum=roomNum;
		this.price=price;
		this.status=status;
	}
	
	public int getRoomNum() {
		return roomNum;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	
}
