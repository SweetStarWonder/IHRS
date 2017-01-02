package data.dataHelper.data_stub;

import java.util.ArrayList;

import data.dataHelper.WebPromotionDataHelper;
import po.promotionPO.WebPromotionPO;

public class WebPromotionDataHelper_stub implements WebPromotionDataHelper{

	@Override
	public ArrayList<WebPromotionPO> getWebPromotionData() {
		// TODO Auto-generated method stub
		ArrayList<WebPromotionPO> arrayList = new ArrayList<>();
		WebPromotionPO webPromotionPO = new WebPromotionPO(0.5, "discountName", "2016/10/01 00:00:00", "2016/10/01 23:59:59");
		arrayList.add(webPromotionPO);
		return arrayList;
	}

	@Override
	public void updateWebPromotionData(ArrayList<WebPromotionPO> webPromotionPOs) {
		// TODO Auto-generated method stub
		
	}

}
