package data.dataHelper.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import data.dataHelper.HotelPromotionDataHelper;
import po.promotionPO.HotelPromotionPO;
import po.promotionPO.HotelPromotionType;


public class HotelPromotionDataTxtHelper implements HotelPromotionDataHelper{

	public HashMap<Integer, ArrayList<HotelPromotionPO>> getHotelPromotionData() {
	
		File file = new File("TxtData//HotelPromotion.txt");
		HashMap<Integer, ArrayList<HotelPromotionPO>> Map = new HashMap<Integer, ArrayList<HotelPromotionPO>>();
		
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str!=null;){
				
				double discount = Double.valueOf(br.readLine().substring(1));
				String discountName = br.readLine().substring(1);
				int HotelId= Integer.valueOf(br.readLine().substring(1));
				String str1= br.readLine().substring(1);
				HotelPromotionType hotelPromotionType;
				if(str1.equals("BIRTHDAY")){
					hotelPromotionType=HotelPromotionType.BIRTHDAY;
				}else if(str1.equals("THREEMORE")){
					hotelPromotionType=HotelPromotionType.THREEMORE;
				}else if(str1.equals("ENTERPRISE")){
					hotelPromotionType=HotelPromotionType.ENTERPRISE;
				}else{
					hotelPromotionType=HotelPromotionType.DOUBLE11;
				}
				
				HotelPromotionPO HotelPromotionPO= new HotelPromotionPO(discount,discountName,HotelId,hotelPromotionType);
						
				if(Map.containsKey(HotelId)){
					Map.get(HotelId).add(HotelPromotionPO);
				}else{
					ArrayList<HotelPromotionPO> list=new ArrayList<HotelPromotionPO>(); 
					list.add(HotelPromotionPO);
					Map.put(HotelId, list);
				}
				str = br.readLine();
			}
			br.close();
			return Map;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void updateHotelPromotionData(HashMap<Integer, ArrayList<HotelPromotionPO>> hotelPromotions) {
		File file = new File("TxtData//HotelPromotion.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer, ArrayList<HotelPromotionPO>>> iterator = hotelPromotions.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, ArrayList<HotelPromotionPO>> entry = iterator.next();
				ArrayList<HotelPromotionPO> creditarray = entry.getValue();
				while(!creditarray.isEmpty()){
					HotelPromotionPO HotelPromotionPO = creditarray.get(0);
					double discount = HotelPromotionPO.getDiscount();
					String discountName = HotelPromotionPO.getDiscountName();
					int HotelId = HotelPromotionPO.getHotelId();
					HotelPromotionType str2=HotelPromotionPO.getHotelPromotionType();
					String hotelPromotionType;
					
					if(str2.equals(HotelPromotionType.BIRTHDAY)){
						hotelPromotionType="BIRTHDAY";
					}else if(str2.equals(HotelPromotionType.DOUBLE11)){
						hotelPromotionType="DOUBLE11";
					}else if(str2.equals(HotelPromotionType.ENTERPRISE)){
						hotelPromotionType="ENTERPRISE";
					}else{
						hotelPromotionType="THREEMORE";
					}
					
					writer.write("<CreditChange>\r\n#" + discount + "\r\n#" +discountName + "\r\n#" + HotelId+ "\r\n#" + hotelPromotionType);
					writer.write("\r\n");
					creditarray.remove(0);
				}
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}


