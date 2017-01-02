package data.dataHelper.data_stub;

import java.util.ArrayList;

import data.dataHelper.NormalVipPromotionDataHelper;
import po.promotionPO.NormalVipPromotionPO;

public class NormalVipPromotionDataHelper_stub implements NormalVipPromotionDataHelper{

	@Override
	public ArrayList<NormalVipPromotionPO> getNormalVipPromotionData() {
		// TODO Auto-generated method stub
		ArrayList<NormalVipPromotionPO> arrayList = new ArrayList<>();
		NormalVipPromotionPO normalVipPromotionPO = new NormalVipPromotionPO(0.5, "discountName", 5, "businessDistrict");
		arrayList.add(normalVipPromotionPO);
		return arrayList;
	}

	@Override
	public void updateNormalVipPromotionData(ArrayList<NormalVipPromotionPO> normalVipPOs) {
		// TODO Auto-generated method stub
		
	}
}
