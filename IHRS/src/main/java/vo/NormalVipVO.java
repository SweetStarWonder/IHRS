package vo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.dao.NormalVipPromotionDao;
import data.dao.RankSystemDao;
import po.CustomerPO;
import po.NormalVipPO;
import po.promotionPO.NormalVipPromotionPO;
import rmi.RemoteHelper;
import vo.promotionVO.NormalVipPromotionVO;

/**
 * id            普通会员编号
 * customerName  普通会员名
 * phone         手机号
 * bonus         积分
 * birthday      生日（YYYY-MM-DD）
 * promotions    普通会员所有促销策略
 */
public class NormalVipVO extends CustomerVO{
	
	private int bonus;
	
	private String birthday;
	
	private int rank;
	
	private ArrayList<NormalVipPromotionVO> promotions;
	
	public NormalVipVO(int id, String customerName, String phone,
			int bonus,String birthday, int rank, ArrayList<NormalVipPromotionVO> promotions) {
		super(id, customerName, phone);
		this.bonus=bonus;
		this.setBirthday(birthday);
		this.setPromotions(promotions);
		this.setRank(rank);
	}
	
	public NormalVipVO(NormalVipPO normalVipPO) {
		super(new CustomerPO(normalVipPO.getId(), normalVipPO.getUserName(), normalVipPO.getPhone()));
		this.bonus = normalVipPO.getBonus();
		this.birthday = normalVipPO.getBirthday();
		RankSystemDao rankSystemDao = RemoteHelper.getInstance().getRankSystemDao();
		NormalVipPromotionDao normalVipPromotionDao = RemoteHelper.getInstance().getNormalVipPromotionDao();
		ArrayList<CreditChangeVO> credits = this.getCredits();
		String time = "";
		int credit = 0;
		if (!credits.isEmpty()) {
			for (CreditChangeVO creditChangeVO : credits) {
				if (creditChangeVO.getTime().compareTo(time) == 1) {
					time = creditChangeVO.getTime();
					credit = creditChangeVO.getResult();
				}
			}
		}
		
		HashMap<Integer, Integer> rankSystem = null;
		try {
			rankSystem = rankSystemDao.getRanks();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator<Integer> iterator = rankSystem.keySet().iterator();
		this.rank = -1;
		int maxRank = 0;
		while (iterator.hasNext()) {
			Integer rank = (Integer) iterator.next();
			maxRank = rank;
			if (rankSystem.get(rank) > credit) {
				this.rank = rank-1;
				break;
			}
		}
		if(this.rank == -1) {
			this.rank = maxRank;
		}
		
		this.promotions = new ArrayList<NormalVipPromotionVO>();
		ArrayList<NormalVipPromotionPO> promotionPOs = null;
		try {
			promotionPOs = normalVipPromotionDao.getNormalVipPromotions(this.rank);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for (NormalVipPromotionPO normalVipPromotionPO : promotionPOs) {
			this.promotions.add(new NormalVipPromotionVO(normalVipPromotionPO));
		}
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public ArrayList<NormalVipPromotionVO> getPromotions() {
		return promotions;
	}

	public void setPromotions(ArrayList<NormalVipPromotionVO> promotions) {
		this.promotions = promotions;
	}

	
}
