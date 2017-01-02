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

import data.dataHelper.NormalVipDataHelper;
import po.NormalVipPO;

public class NormalVipDataTxtHelper implements NormalVipDataHelper{

	public NormalVipDataTxtHelper() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<Integer, NormalVipPO> getNormalVipData() {
		// TODO Auto-generated method stub
		File file = new File("src//main//resources//NormalVip.txt");
		HashMap<Integer,NormalVipPO> map = new HashMap<Integer, NormalVipPO>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int userID = Integer.valueOf(br.readLine().substring(1));
				String userName = br.readLine().substring(1);
				String phone = br.readLine().substring(1);
				int bonus = Integer.valueOf(br.readLine().substring(1));
				String birthday = br.readLine().substring(1);
				NormalVipPO  NormalVipPO = new NormalVipPO(userID,userName,phone,bonus,birthday);
				map.put(userID, NormalVipPO);
				str = br.readLine();
			}
			br.close();
			return map;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void updateNormalVipData(HashMap<Integer, NormalVipPO> normalVipDataMap) {
		// TODO Auto-generated method stub
		File file = new File("src//main//resources//NormalVip.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer,NormalVipPO>> iterator = normalVipDataMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer,NormalVipPO> entry = iterator.next();
				NormalVipPO normalVipPO = entry.getValue();
				int userid = normalVipPO.getId();
				String username = normalVipPO.getUserName();
				String phone = normalVipPO.getPhone();
				int bonus = Integer.valueOf(normalVipPO.getBonus());
				String birthday = normalVipPO.getBirthday();
				writer.write("<NormalVip>\r\n#" + userid + "\r\n#" + username + "\r\n#" + phone
									+ "\r\n#" + bonus + "\r\n#" + birthday);
				writer.write("\r\n");
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}