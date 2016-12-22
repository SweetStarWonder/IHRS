package po;

import java.io.Serializable;

/**
 * listId                订单编号
 * hotelId               酒店编号
 * userId                用户编号
 * status                订单状态
 * entryTime             入住时间（yyyy/MM/dd HH:mm:ss）
 * lastTime              离店时间
 * lastListExecutedTime  最晚订单执行时间
 * price                 价格
 * ifHaveChild           是否携带小孩
 */
public class ListPO implements Serializable {
	
	private static final long serialVersionUID = 4502870063553836090L;

	
	private int listId;
	
	private int hotelId;
	
	private int userId;
	
	private ListStatus status;
	
	private String entryTime;
	
	private String lastTime;
	
	private String lastListExecutedTime;
	
	private int price;
	
	private boolean ifHaveChild;
	
	public ListPO(int listId, int hotelId, int userId, ListStatus status,
			String entryTime, String lastTime,String lastListExecutedTime,int price,boolean ifHaveChild) {
		this.setListId(listId);
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

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}
	
	@Override
	public boolean equals(Object o) {
		ListPO listPO = (ListPO) o;
		return (listPO.getListId()==listId && listPO.getHotelId()==hotelId && listPO.getUserId()==userId);
    }
}
