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

import data.dataHelper.WebManagerDataHelper;
import po.WebManagerPO;

public class WebManagerDataTxtHelper implements WebManagerDataHelper{

	public WebManagerDataTxtHelper() {
		// TODO Auto-generated constructor stub

	}

	public HashMap<Integer, WebManagerPO> getWebManagerData() {
		// TODO Auto-generated method stub
		File file = new File("src//main//resources//WebManager.txt");
		HashMap<Integer,WebManagerPO> map = new HashMap<Integer, WebManagerPO>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int userID = Integer.valueOf(br.readLine().substring(1));
				String userName = br.readLine().substring(1);
				String phone = br.readLine().substring(1);
				WebManagerPO  webManagerPO = new WebManagerPO(userID,userName,phone);
				map.put(userID, webManagerPO);
				str = br.readLine();
			}
			br.close();
			return map;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void updateWebManagerData(HashMap<Integer, WebManagerPO> webManagerDataMap) {
		// TODO Auto-generated method stub
		File file = new File("src//main//resources//WebManager.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer,WebManagerPO>> iterator = webManagerDataMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer,WebManagerPO> entry = iterator.next();
				WebManagerPO webManagerPO = entry.getValue();
				int userid = webManagerPO.getId();
				String username = webManagerPO.getUserName();
				String phone = webManagerPO.getPhone();
				writer.write("<webManager>\r\n#" + userid + "\r\n#" + username + "\r\n#" + phone);
				writer.write("\r\n");
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

