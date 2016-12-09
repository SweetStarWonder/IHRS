package vo;

import java.util.ArrayList;

import po.CustomerPO;
import po.NormalVipPO;
import vo.promotionVO.NormalVipPromotionVO;

public class NormalVipVO extends CustomerVO{
	private int bonus;
	private String birthday;  //YYYY-MM-DD
	private ArrayList<NormalVipPromotionVO> promotions;
	
	public NormalVipVO(int id, String customerName, String phone,
			int bonus,String birthday, ArrayList<NormalVipPromotionVO> promotions) {
		super(id, customerName, phone);
		this.bonus=bonus;
		this.setBirthday(birthday);
		this.setPromotions(promotions);
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

	public ArrayList<NormalVipPromotionVO> getPromotions() {
		return promotions;
	}

	public void setPromotions(ArrayList<NormalVipPromotionVO> promotions) {
		this.promotions = promotions;
	}

}
