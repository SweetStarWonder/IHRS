package data.dataHelper.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

import data.dataHelper.NormalVipPromotionDataHelper;
import po.promotionPO.NormalVipPromotionPO;


public class NormalVipPromotionDataTxtHelper implements NormalVipPromotionDataHelper{

	public ArrayList<NormalVipPromotionPO> getNormalVipPromotionData() {
		
		File file = new File("TxtData//NormalVipPromotion.txt");
		ArrayList<NormalVipPromotionPO> list=new ArrayList<NormalVipPromotionPO>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				double discount=Double.valueOf(br.readLine().substring(1));
				String discountName=br.readLine().substring(1);
				int rankValue=Integer.valueOf(br.readLine().substring(1));
				String businessDistrict=br.readLine().substring(1);
				
				NormalVipPromotionPO  NormalVipPromotionPO = new NormalVipPromotionPO(discount,discountName,rankValue,businessDistrict);
				list.add(NormalVipPromotionPO);
				str = br.readLine();
			}
			br.close();
			return list;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	public void updateNormalVipPromotionData(ArrayList<NormalVipPromotionPO> normalVipPOs) {
		File file = new File("TxtData//NormalVipPromotion.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			for(int i = 0; i<normalVipPOs.size(); i++){
			   
				double discount=normalVipPOs.get(i).getDiscount();
				String discountName=normalVipPOs.get(i).getDiscountName();
				int rankValue=normalVipPOs.get(i).getRankValue();
				String businessDistrict=normalVipPOs.get(i).getBusinessDistrict();
				
				
				writer.write("<NormalVipPromotion>\r\n#" + discount + "\r\n#" + discountName + "\r\n#" + rankValue
						+ "\r\n#" +businessDistrict);
	            writer.write("\r\n");
			}

				
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
