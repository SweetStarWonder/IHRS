package data.dataHelper.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import data.dataHelper.AddressDataHelper;

public class AddressDataTxtHelper implements AddressDataHelper{

	public HashMap<String, ArrayList<String>> getAddresses() {
		File file = new File("TxtData//Address.txt");
		HashMap<String, ArrayList<String>> Map = new HashMap<String, ArrayList<String>>();
		
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String str = br.readLine();
			while(str != null){
				String bussiness = br.readLine().substring(1);
				String address = br.readLine();
				for(;(address != null)&&!address.equals("<Address>")&&(!address.equals(""));
						address = br.readLine()){
					address = address.substring(1);
					if(Map.containsKey(bussiness)){
						Map.get(bussiness).add(address);
					}else{
						ArrayList<String> ad=new ArrayList<String>(); 
						ad.add(address);
						Map.put(bussiness, ad);
					}
				}
				str = address;
			}
			br.close();
			return Map;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}

