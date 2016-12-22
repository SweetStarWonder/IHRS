package po;

import java.io.Serializable;

/**
 * hotelId  酒店编号
 * listId   订单编号
 * roomNum  房间编号
 * price    房间价格
 * status   房间类型
 */
public class RoomPO implements Serializable {

	private static final long serialVersionUID = 5323857431834293997L;
	
	
	private int hotelId;
	
	private int listId;
	
	private int roomNum;
	
	private int price;
	
	private RoomStatus status;
	
	public RoomPO(int hotelId,int listId,int roomNum,int price,RoomStatus status){
		this.hotelId=hotelId;
		this.setListId(listId);
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

	@Override
	public boolean equals(Object o) {
		RoomPO roomPO = (RoomPO) o;
        return (roomPO.getHotelId()==hotelId && roomPO.getRoomNum()==roomNum);
    }
}
