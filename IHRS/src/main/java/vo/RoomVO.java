package vo;

public class RoomVO {
	private int roomNum;
	private int price;
	private RoomStatus status;
	
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

	
}
