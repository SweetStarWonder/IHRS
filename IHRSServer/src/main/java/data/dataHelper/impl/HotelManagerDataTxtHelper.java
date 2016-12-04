package data.dataHelper.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import data.dataHelper.HotelManagerDataHelper;
import po.HotelManagerPO;

public class HotelManagerDataTxtHelper implements HotelManagerDataHelper{

	public HotelManagerDataTxtHelper() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<Integer, HotelManagerPO> getHotelManagerData() {
		// TODO Auto-generated method stub
		File file = new File("TxtData//HotelManager.txt");
		HashMap<Integer,HotelManagerPO> map = new HashMap<Integer, HotelManagerPO>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int userID = Integer.valueOf(br.readLine().substring(1));
				String userName = br.readLine().substring(1);
				String phone = br.readLine().substring(1);
				int hotelid = Integer.valueOf(br.readLine().substring(1));
				HotelManagerPO  HotelManagerPO = new HotelManagerPO(userID,userName,phone,hotelid);
				map.put(userID, HotelManagerPO);
				str = br.readLine();
			}
			br.close();
			return map;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void updateHotelManagerData(HashMap<Integer, HotelManagerPO> hotelManagerDataMap) {
		// TODO Auto-generated method stub
		File file = new File("TxtData//HotelManager.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer,HotelManagerPO>> iterator = hotelManagerDataMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer,HotelManagerPO> entry = iterator.next();
				HotelManagerPO HotelManagerPO = entry.getValue();
				int userid = HotelManagerPO.getId();
				String username = HotelManagerPO.getUserName();
				String phone = HotelManagerPO.getPhone();
				int hotelid = HotelManagerPO.getHotelId();
				writer.write("<HotelManager>\r\n#" + userid + "\r\n#" + username + "\r\n#" + phone + "\r\n#" + hotelid);
				writer.write("\r\n");
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
