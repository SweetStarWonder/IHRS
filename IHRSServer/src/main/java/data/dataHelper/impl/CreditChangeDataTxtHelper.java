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

import data.dataHelper.CreditChangeDataHelper;
import po.CreditChangeMove;
import po.CreditChangePO;

public class CreditChangeDataTxtHelper implements CreditChangeDataHelper{
	public HashMap<Integer, ArrayList<CreditChangePO>> getCreditChangeData(){
		File file = new File("src//main//resources//CreditChange.txt");
		HashMap<Integer, ArrayList<CreditChangePO>> Map = new HashMap<Integer, ArrayList<CreditChangePO>>();
		
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine(); str != null;){
				int userId = Integer.valueOf(br.readLine().substring(1));
				String time = br.readLine().substring(1);
				String listId = br.readLine().substring(1);
				int change = Integer.valueOf(br.readLine().substring(1));
				int resultValue = Integer.valueOf(br.readLine().substring(1));
				String str1= br.readLine().substring(1);
				CreditChangeMove creditChangeMove;
				if(str1.equals("LISTEXECUTE")){
					creditChangeMove=CreditChangeMove.LISTEXECUTE;
				}else if(str1.equals("LISTABNORMAL")){
					creditChangeMove=CreditChangeMove.LISTABNORMAL;
				}else if(str1.equals("LISTREVOKE")){
					creditChangeMove=CreditChangeMove.LISTREVOKE;
				}else{
					creditChangeMove=CreditChangeMove.RECHARGE;
				}
				
				CreditChangePO creditChangePO= new CreditChangePO(userId,time,listId,change,resultValue,creditChangeMove);
						
				if(Map.containsKey(userId)){
					Map.get(userId).add(creditChangePO);
				}else{
					ArrayList<CreditChangePO> list=new ArrayList<CreditChangePO>(); 
					list.add(creditChangePO);
					Map.put(userId, list);
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
	public void updateCreditChangeData(HashMap<Integer, ArrayList<CreditChangePO>> creditChangeMap){
		File file = new File("src//main//resources//CreditChange.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer, ArrayList<CreditChangePO>>> iterator = creditChangeMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, ArrayList<CreditChangePO>> entry = iterator.next();
				ArrayList<CreditChangePO> tmp = entry.getValue();
				@SuppressWarnings("unchecked")
				ArrayList<CreditChangePO> creditarray = (ArrayList<CreditChangePO>)tmp.clone();
				while(!creditarray.isEmpty()){
					CreditChangePO creditChangePO = creditarray.get(0);
					int userId = creditChangePO.getUserId();
					String time = creditChangePO.getTime();
					String listId = creditChangePO.getListId();
					int change=creditChangePO.getChange();;
					int resultValue=creditChangePO.getResult();
					CreditChangeMove str2=creditChangePO.getCreditChangeMove();
					String creditChangeMove;
					
					if(str2.equals(CreditChangeMove.LISTEXECUTE)){
						creditChangeMove="LISTEXECUTE";
					}else if(str2.equals(CreditChangeMove.LISTABNORMAL)){
						creditChangeMove="LISTABNORMAL";
					}else if(str2.equals(CreditChangeMove.LISTREVOKE)){
						creditChangeMove="LISTREVOKE";
					}else{
						creditChangeMove="RECHARGE";
					}
					
					writer.write("<CreditChange>\r\n#" + userId + "\r\n#" + time + "\r\n#" + listId+ "\r\n#" + change+ "\r\n#" + resultValue+ "\r\n#"+creditChangeMove);
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
