package po;


public class EnterpriseVipPO extends CustomerPO{
	
	private String enterpriseName;
	
	private int bonus;  //积分
	
	
	public EnterpriseVipPO(int id, String customerName, String phone,
			String enterpriseName,int bonus) {
		super(id, customerName, phone);
		this.enterpriseName=enterpriseName;
		this.bonus=bonus;
	}


	public String getEnterpriseName() {
		return enterpriseName;
	}


	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	

}
