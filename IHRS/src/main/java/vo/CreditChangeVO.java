package vo;

import po.CreditChangeMove;
import po.CreditChangePO;

/**
 * userId            用户编号
 * time              发生时间（yyyy/MM/dd HH:mm:ss）
 * listId            订单编号
 * change            变化记录（有正有负）
 * resultValue       变化后的结果值
 * creditChangeMove  变化类型
 */
public class CreditChangeVO {
	
	private int userId;
	
	private String time;
	
	private String listId;
	
	private int change;
	
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
