package vo;

import java.util.ArrayList;

public class NormalVipVO extends CustomerVO{
	private int bonus;
	private String birthday;  //YYYY-MM-DD
	
	public NormalVipVO(int id, String customerName, String phone, int creditValue,ArrayList<ListVO> myLists,
			int bonus,String birthday) {
		super(id, customerName, phone, creditValue, myLists);
		this.bonus=bonus;
		this.setBirthday(birthday);
	}
	
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
