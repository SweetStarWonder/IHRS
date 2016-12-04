package vo;

import po.CustomerPO;
import po.EnterpriseVipPO;

public class EnterpriseVipVO extends CustomerVO{
	
	private String enterpriseName;
	
	private int bonus;
	
	
	public EnterpriseVipVO(int id, String customerName, String phone,
			String enterpriseName,int bonus) {
		super(id, customerName, phone);
		this.enterpriseName=enterpriseName;
		this.bonus=bonus;
	}
	
	public EnterpriseVipVO(EnterpriseVipPO enterpriseVipPO) {
		super(new CustomerPO(enterpriseVipPO.getId(), enterpriseVipPO.getUserName(), enterpriseVipPO.getPhone()));
		this.enterpriseName = enterpriseVipPO.getEnterpriseName();
		this.bonus = enterpriseVipPO.getBonus();
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
