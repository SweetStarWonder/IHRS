package data.dataHelper.impl;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import data.dataHelper.WebSaleDataHelper;
import po.WebSalePO;

public class WebSaleDataTxtHelper implements WebSaleDataHelper{

	
	public WebSaleDataTxtHelper() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<Integer, WebSalePO> getWebSaleDataById() {
		// TODO Auto-generated method stub
		File file = new File("src//main//resources//WebSale.txt");
		HashMap<Integer,WebSalePO> map = new HashMap<Integer, WebSalePO>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int userID = Integer.valueOf(br.readLine().substring(1));
				String userName = br.readLine().substring(1);
				String phone = br.readLine().substring(1);
				WebSalePO  webSalePO = new WebSalePO(userID,userName,phone);
				map.put(userID, webSalePO);
				str = br.readLine();
			}
			br.close();
			return map;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public HashMap<String, WebSalePO> getWebSaleDataByName() {
		// TODO Auto-generated method stub
		File file = new File("src//main//resources//WebSale.txt");
		HashMap<String,WebSalePO> map = new HashMap<String, WebSalePO>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int userID = Integer.valueOf(br.readLine().substring(1));
				String userName = br.readLine().substring(1);
				String phone = br.readLine().substring(1);
				WebSalePO  webSalePO = new WebSalePO(userID,userName,phone);
				map.put(userName, webSalePO);
				str = br.readLine();
			}
			br.close();
			return map;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void updateWebSaleDataById(HashMap<Integer, WebSalePO> webSaleDataMap) {
		// TODO Auto-generated method stub
		File file = new File("src//main//resources//WebSale.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer,WebSalePO>> iterator = webSaleDataMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer,WebSalePO> entry = iterator.next();
				WebSalePO webSalePO = entry.getValue();
				int userid = webSalePO.getId();
				String username = webSalePO.getUserName();
				String phone = webSalePO.getPhone();
				writer.write("<WebSale>\r\n#" + userid + "\r\n#" + username + "\r\n#" + phone);
				writer.write("\r\n");
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateWebSaleDataByName(HashMap<String, WebSalePO> webSaleDataMap) {
		// TODO Auto-generated method stub
		File file = new File("src//main//resources//WebSale.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Entry<String, WebSalePO>> iterator = webSaleDataMap.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String, WebSalePO> entry = iterator.next();
				WebSalePO webSalePO = entry.getValue();
				int userid = webSalePO.getId();
				String username = webSalePO.getUserName();
				String phone = webSalePO.getPhone();
				writer.write("<WebSale>\r\n#" + userid + "\r\n#" + username + "\r\n#" + phone);
				writer.write("\r\n");
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
