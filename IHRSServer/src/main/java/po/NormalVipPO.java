package po;

public class NormalVipPO extends CustomerPO{
	
	private int bonus;
	private String birthday;  //YYYY-MM-DD
	
	public NormalVipPO(int id, String customerName, String phone, int creditValue,
			int bonus,String birthday) {
		super(id, customerName, phone, creditValue);
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
