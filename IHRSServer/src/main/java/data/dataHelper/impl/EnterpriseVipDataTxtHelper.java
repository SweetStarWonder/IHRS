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

import data.dataHelper.EnterpriseVipDataHelper;
import po.EnterpriseVipPO;

public class EnterpriseVipDataTxtHelper implements EnterpriseVipDataHelper{

	public EnterpriseVipDataTxtHelper() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<Integer, EnterpriseVipPO> getEnterpriseVipData() {
		File file = new File("src//main//resources//EnterpriseVip.txt");
		HashMap<Integer, EnterpriseVipPO> Map = new HashMap<Integer, EnterpriseVipPO>();
		
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine(); str != null;){
				int userId = Integer.valueOf(br.readLine().substring(1));
				String customerName = br.readLine().substring(1);
				String phone = br.readLine().substring(1);
				String enterpriseName = br.readLine().substring(1);
				int bonus = Integer.valueOf(br.readLine().substring(1));
				EnterpriseVipPO enterpriseVipPO= new EnterpriseVipPO(userId,customerName,phone,enterpriseName,bonus);
				
				Map.put(userId, enterpriseVipPO);
				str = br.readLine();
			}
			br.close();
			return Map;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	    
	}

	public void updateEnterpriseVipData(HashMap<Integer, EnterpriseVipPO> enterpriseVipMap) {
		File file = new File("src//main//resources//EnterpriseVip.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer, EnterpriseVipPO>> iterator = enterpriseVipMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, EnterpriseVipPO> entry = iterator.next();
				EnterpriseVipPO enterpriseVipPO = entry.getValue();
				int userId = enterpriseVipPO.getId();
				String customerName =enterpriseVipPO.getUserName();
				String phone =enterpriseVipPO.getPhone();
				String enterpriseName = enterpriseVipPO.getEnterpriseName();
				int bonus = enterpriseVipPO.getBonus();
				writer.write("<EnterpriseVip>\r\n#" + userId + "\r\n#" +customerName + "\r\n#" + phone + "\r\n#" +enterpriseName + "\r\n#" +bonus);
				writer.write("\r\n");
			}
			writer.close();	
		 } catch (Exception e) {
			e.printStackTrace();
		 }
    }
}
