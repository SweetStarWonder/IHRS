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
		File file = new File("src//main//resources//Address.txt");
		HashMap<String, ArrayList<String>> Map = new HashMap<String, ArrayList<String>>();
	
		
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine(); str != null;){
				ArrayList<String> list=new ArrayList<String>();
				String business= br.readLine().substring(1);
				
					String nextAddress = br.readLine().substring(1);
					while(!nextAddress.equals("+")){
						list.add(nextAddress);
						nextAddress = br.readLine().substring(1);
						
					}
					Map.put(business, list);
				
				str = br.readLine();
			}
			br.close();
			return Map;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	    
	}

}

