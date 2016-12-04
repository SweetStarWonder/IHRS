package vo;

import po.CreditChangeMove;
import po.CreditChangePO;

public class CreditChangeVO {
	
	private int userId;
	private String time;
	private String listId;
	private int change;  //变化记录，有负有正
	private int result;
	private CreditChangeMove creditChangeMove;
	
	public CreditChangeVO(CreditChangePO creditChangePO){
		this.userId=creditChangePO.getUserId();
		this.time=creditChangePO.getTime();
		this.listId=creditChangePO.getListId();
		this.change=creditChangePO.getChange();
		this.result=creditChangePO.getResult();
		this.creditChangeMove=creditChangePO.getCreditChangeMove();
	}
	
	public CreditChangeVO(int userId,String time,String listId,int change,int result,CreditChangeMove creditChangeMove) {
		this.userId=userId;
		this.setTime(time);
		this.setListId(listId);
		this.setChange(change);
		this.setResult(result);
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
		return result;
	}

	public void setResult(int result) {
		this.result = result;
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
