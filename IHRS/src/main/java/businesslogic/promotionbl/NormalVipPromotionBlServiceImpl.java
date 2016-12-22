package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.promotionblservice.NormalVipPromotionBlService;
import data.dao.HotelDao;
import data.dao.NormalVipPromotionDao;
import po.HotelPO;
import po.promotionPO.NormalVipPromotionPO;
import rmi.RemoteHelper;
import vo.promotionVO.NormalVipPromotionVO;

public class NormalVipPromotionBlServiceImpl implements NormalVipPromotionBlService{
	
	private NormalVipPromotionDao normalVipPromotionDao;
	
	private HotelDao hotelDao;
	
	public NormalVipPromotionBlServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		this.normalVipPromotionDao=remoteHelper.getNormalVipPromotionDao();
		this.hotelDao=remoteHelper.getHotelDao();
	}
	
	public ArrayList<NormalVipPromotionVO> getNormalVipPromotions(int rankValue) {
		ArrayList<NormalVipPromotionPO> normalVipPromotionPOs;
		ArrayList<NormalVipPromotionVO> normalVipPromotionVOs=new ArrayList<NormalVipPromotionVO>();
		try {
			normalVipPromotionPOs = normalVipPromotionDao.getNormalVipPromotions(rankValue);
			for (NormalVipPromotionPO normalVipPromotionPO : normalVipPromotionPOs) {
				normalVipPromotionVOs.add(new NormalVipPromotionVO(normalVipPromotionPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return normalVipPromotionVOs;
	}

	public boolean updateNormalVipPromotion(NormalVipPromotionVO normalVipPromotionVO) {
		boolean update=false;
		try {
			update=normalVipPromotionDao.updateNormalVipPromotion(new NormalVipPromotionPO(normalVipPromotionVO.getDiscount(), normalVipPromotionVO.getDiscountName(), 
					normalVipPromotionVO.getRankValue(), normalVipPromotionVO.getBusinessDistrict()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return update;
	}

	public boolean addNormalVipPromotion(NormalVipPromotionVO normalVipPromotionVO) {
		boolean add=false;
		try {
			add=normalVipPromotionDao.addNormalVipPromotion(new NormalVipPromotionPO(normalVipPromotionVO.getDiscount(), normalVipPromotionVO.getDiscountName(), 
					normalVipPromotionVO.getRankValue(), normalVipPromotionVO.getBusinessDistrict()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return add;
	}

	public boolean deleteNormalVipPromotion(NormalVipPromotionVO normalVipPromotionVO) {
		boolean delete=false;
		try {
			delete=normalVipPromotionDao.deleteNormalVipPromotion(new NormalVipPromotionPO(normalVipPromotionVO.getDiscount(), normalVipPromotionVO.getDiscountName(), 
					normalVipPromotionVO.getRankValue(), normalVipPromotionVO.getBusinessDistrict()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return delete;
	}

	public double getMinDiscountForNormalVip(int hotelId,int rankValue) {
		double minDiscount=1.0;
		ArrayList<NormalVipPromotionVO> normalVipPromotionVOs=getNormalVipPromotions(rankValue);
		ArrayList<NormalVipPromotionVO> normalVipPromotions=new ArrayList<NormalVipPromotionVO>();
		try {
			HotelPO hotelPO=hotelDao.getHotel(hotelId);
			String businessDistrict=hotelPO.getBusinessDistrict();
			for (NormalVipPromotionVO normalVipPromotionVO : normalVipPromotionVOs) {
				if(businessDistrict.equals(normalVipPromotionVO.getBusinessDistrict())){
					normalVipPromotions.add(normalVipPromotionVO);
				}
				if(rankValue>normalVipPromotionVO.getRankValue()){
					normalVipPromotions.add(normalVipPromotionVO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (NormalVipPromotionVO normalVipPromotionVO : normalVipPromotions) {
			double tmpDiscount=normalVipPromotionVO.getDiscount();
			if(tmpDiscount<=minDiscount){
				minDiscount=tmpDiscount;
			}
		}
		return minDiscount;
	}
	
}
