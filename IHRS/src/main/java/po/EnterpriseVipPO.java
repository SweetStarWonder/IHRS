package po;

/**
 * id              企业会员编号
 * customerName    企业会员名
 * phone           手机号
 * enterpriseName  企业名
 * bonus           积分
 */
public class EnterpriseVipPO extends CustomerPO{

	private static final long serialVersionUID = -4844005545557868497L;

	
	private String enterpriseName;
	
	private int bonus;
	
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

	@Override
	public boolean equals(Object o) {
        EnterpriseVipPO enterpriseVipPO = (EnterpriseVipPO) o;
		return (enterpriseVipPO.getId()==getId() && enterpriseVipPO.getEnterpriseName().equals(enterpriseName));
    }
}
