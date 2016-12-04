package po;

public class CreditChangePO {
	
	private int userId;
	private String time;
	private String listId;
	private int change;  //变化记录，有负有正
	private int resultValue;
	private CreditChangeMove creditChangeMove;
	
	public CreditChangePO(int userId,String time,String listId,int change,int resultValue,CreditChangeMove creditChangeMove) {
		this.setUserId(userId);
		this.setTime(time);
		this.setListId(listId);
		this.setChange(change);
		this.setResult(resultValue);
		this.setCreditChangeMove(creditChangeMove);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	public int getResult() {
		return resultValue;
	}

	public void setResult(int result) {
		this.resultValue = result;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public CreditChangeMove getCreditChangeMove() {
		return creditChangeMove;
	}

	public void setCreditChangeMove(CreditChangeMove creditChangeMove) {
		this.creditChangeMove = creditChangeMove;
	}
	
	

}
