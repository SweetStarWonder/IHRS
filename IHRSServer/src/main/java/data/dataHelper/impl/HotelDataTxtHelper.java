package data.dataHelper.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

import data.dataHelper.HotelDataHelper;
import po.HotelPO;

public class HotelDataTxtHelper implements HotelDataHelper{

	public HotelDataTxtHelper() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<Integer, HotelPO> getHotelData() {
		File file = new File("src//main//resources//Hotel.txt");
		HashMap<Integer,  HotelPO> Map = new HashMap<Integer, HotelPO>();
		
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
			
			    int id= Integer.valueOf(br.readLine().substring(1));
				
				ArrayList<String> partners=new ArrayList<String>();
				String partnerstr = br.readLine().substring(1);
				String partner[] = partnerstr.split(";");
				for(int i = 0; i < partner.length;i++){
					partners.add(partner[i]);
				}
				String hotelName= br.readLine().substring(1);
				
				String position= br.readLine().substring(1);
				
				String businessDistrict= br.readLine().substring(1);
				
				int starRating= Integer.valueOf(br.readLine().substring(1));
				
				String introduction= br.readLine().substring(1);
				
				String facility= br.readLine().substring(1);
				
				HotelPO hotelPO= new HotelPO(id,partners,hotelName,position,businessDistrict,starRating,introduction,facility);
				
				
				
				Map.put(id, hotelPO);
				str = br.readLine();
			}
			br.close();
			return Map;
		}catch (Exception e){
			e.printStackTrace();
		
		}
		return null;
	}

	public void updateHotelData(HashMap<Integer, HotelPO> hotelDataMap) {
		File file = new File("src//main//resources//Hotel.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Entry<Integer, HotelPO>> iterator = hotelDataMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, HotelPO> entry = iterator.next();
				HotelPO hotelPO = entry.getValue();
			
				
				int id= hotelPO.getId();
				ArrayList<String> temp = hotelPO.getPartners();
				@SuppressWarnings("unchecked")
				ArrayList<String> partners = (ArrayList<String>)temp.clone();
				String partner = "";
				while(!partners.isEmpty()){
					String tmp = partners.get(0) + ";";
					partners.remove(0);
					partner = partner + tmp;
				}
				String hotelName= hotelPO.getHotelName();
				String position= hotelPO.getPosition();
				String businessDistrict= hotelPO.getBusinessDistrict();
				int starRating = hotelPO.getStarRating();
				String introduction = hotelPO.getIntroduction();
				String facility= hotelPO.getFacility();
				
				writer.write("<Hotel>\r\n#" + id + "\r\n#" + partner+ "\r\n#" + hotelName+ "\r\n#" + position+ "\r\n#" +businessDistrict+ "\r\n#" +starRating+ "\r\n#" +introduction+ "\r\n#" +facility);
				writer.write("\r\n");
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

