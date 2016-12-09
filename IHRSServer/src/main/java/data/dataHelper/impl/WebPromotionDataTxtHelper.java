package data.dataHelper.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;


import data.dataHelper.WebPromotionDataHelper;
import po.promotionPO.WebPromotionPO;


public class WebPromotionDataTxtHelper implements WebPromotionDataHelper {

	public ArrayList<WebPromotionPO> getWebPromotionData() {
		File file = new File("TxtData//WebPromotion.txt");
		ArrayList<WebPromotionPO> list=new ArrayList<WebPromotionPO>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str!=null;){
				double discount=Double.valueOf(br.readLine().substring(1));
				String discountName=br.readLine().substring(1);
				String startTime=br.readLine().substring(1);
				String endTime=br.readLine().substring(1);
				WebPromotionPO  WebPromotionPO = new WebPromotionPO(discount,discountName,startTime,endTime);
				list.add(WebPromotionPO);
				str = br.readLine();
			}
			br.close();
			return list;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void updateWebPromotionData(ArrayList<WebPromotionPO> webPromotionPOs) {
		// TODO Auto-generated method stub
		File file = new File("TxtData//WebPromotion.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			for(int i = 0; i<webPromotionPOs.size(); i++){
			   
			   
				double discount=webPromotionPOs.get(i).getDiscount();
				String discountName=webPromotionPOs.get(i).getDiscountName();
				String startTime=webPromotionPOs.get(i).getStartTime();
				String endTime=webPromotionPOs.get(i).getEndTime();
				
				writer.write("<WebPromotion>\r\n#" + discount + "\r\n#" + discountName + "\r\n#" + startTime
						+ "\r\n#" +endTime);
	            writer.write("\r\n");
			}

				
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

