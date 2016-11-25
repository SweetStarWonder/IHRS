package vo;

import java.util.ArrayList;

public class EnterpriseVipVO extends CustomerVO{
	
	private String enterpriseName;
	
	private int bonus;
	
	
	public EnterpriseVipVO(int id, String customerName, String phone, int creditValue,ArrayList<ListVO> myLists,
			String enterpriseName,int bonus) {
		super(id, customerName, phone, creditValue, myLists);
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
