package vo;

import po.CustomerPO;
import po.NormalVipPO;

public class NormalVipVO extends CustomerVO{
	private int bonus;
	private String birthday;  //YYYY-MM-DD
	
	public NormalVipVO(int id, String customerName, String phone,
			int bonus,String birthday) {
		super(id, customerName, phone);
		this.bonus=bonus;
		this.setBirthday(birthday);
	}
	
	public NormalVipVO(NormalVipPO normalVipPO) {
		super(new CustomerPO(normalVipPO.getId(), normalVipPO.getUserName(), normalVipPO.getPhone()));
		this.bonus = normalVipPO.getBonus();
		this.birthday = normalVipPO.getBirthday();
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
