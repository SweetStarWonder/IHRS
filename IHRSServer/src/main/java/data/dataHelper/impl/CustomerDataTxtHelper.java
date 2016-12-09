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

import data.dataHelper.CustomerDataHelper;
import po.CustomerPO;

public class CustomerDataTxtHelper implements CustomerDataHelper{

	public HashMap<Integer, CustomerPO> getCustomerDataById() {
		File file = new File("TxtData//Customer.txt");
		HashMap<Integer,  CustomerPO> Map = new HashMap<Integer, CustomerPO>();
		
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int id = Integer.valueOf(br.readLine().substring(1));
				String customerName = br.readLine().substring(1);
				String phone = br.readLine().substring(1);
				CustomerPO customerPO= new CustomerPO(id,customerName,phone);
				Map.put(id, customerPO);
				str = br.readLine();
			}
			br.close();
			return Map;
		}catch (Exception e){
			e.printStackTrace();
		
		}
		return null;
	}

	public HashMap<String, CustomerPO> getCustomerDataByName() {
		File file = new File("TxtData/Customer.txt");
		HashMap<String,  CustomerPO> Map = new HashMap<String, CustomerPO>();
		
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int id = Integer.valueOf(br.readLine().substring(1));
				String customerName = br.readLine().substring(1);
				String phone = br.readLine().substring(1);
				CustomerPO customerPO= new CustomerPO(id,customerName,phone);
				Map.put(customerName, customerPO);
				str = br.readLine();
			}
			br.close();
			return Map;
		}catch (Exception e){
			e.printStackTrace();
		
		}
		return null;
	}

	public void updateCustomerDataById(HashMap<Integer, CustomerPO> customerMap) {
		File file = new File("TxtData/Customer.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer, CustomerPO>> iterator = customerMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, CustomerPO> entry = iterator.next();
				CustomerPO customerPO = entry.getValue();
				int id = customerPO.getId();
				String customerName = customerPO.getUserName();
				String phone = customerPO.getPhone();
				
				writer.write("<Customer>\r\n#" + id + "\r\n#" +customerName + "\r\n#" + phone);
				writer.write("\r\n");
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateCustomerDataByName(HashMap<Integer, CustomerPO> customerMap) {
		File file = new File("TxtData/Customer.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer, CustomerPO>> iterator = customerMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, CustomerPO> entry = iterator.next();
				CustomerPO customerPO = entry.getValue();
				int id = customerPO.getId();
				String customerName = customerPO.getUserName();
				String phone = customerPO.getPhone();
				
				writer.write("<Customer>\r\n#" + id + "\r\n#" +customerName + "\r\n#" + phone);
				writer.write("\r\n");
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
