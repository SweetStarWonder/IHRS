package vo;

public class CreditChangeVO {
	
	private String time;
	private String listId;
	private int change;  //变化记录，有负有正
	private int result;
	
	public CreditChangeVO(String time,String listId,int change,int result) {
		this.setTime(time);
		this.setListId(listId);
		this.setChange(change);
		this.setResult(result);
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
	
	

}
