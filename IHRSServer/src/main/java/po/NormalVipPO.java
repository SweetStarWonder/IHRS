
package po;

/**
 * id            普通会员编号
 * customerName  普通会员名
 * phone         手机号
 * bonus         积分
 * birthday      生日（YYYY-MM-DD）
 */
public class NormalVipPO extends CustomerPO{

	private static final long serialVersionUID = -7522414642053386616L;
	
	
	private int bonus;
	
	private String birthday;
	
	public NormalVipPO(int id, String customerName, String phone,
			int bonus,String birthday) {
		super(id, customerName, phone);
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

	@Override
	public boolean equals(Object o) {
		NormalVipPO normalVipPO = (NormalVipPO) o;
		return (normalVipPO.getId()==getId() && normalVipPO.getBirthday().equals(birthday));
    }
}
