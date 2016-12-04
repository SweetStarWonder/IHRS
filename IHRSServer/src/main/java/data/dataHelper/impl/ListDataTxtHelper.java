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

import data.dataHelper.ListDataHelper;
import po.ListPO;
import po.ListStatus;

public class ListDataTxtHelper implements ListDataHelper{

	public ListDataTxtHelper() {
		// TODO Auto-generated constructor stub
	}

	public  HashMap<Integer, HashMap<Integer, ListPO>> getListDataByUser() {
		// TODO Auto-generated method stub
		File file = new File("TxtData//List.txt");
		HashMap<Integer,HashMap<Integer,ListPO>> Map = new HashMap<Integer,HashMap<Integer,ListPO>>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int listID = Integer.valueOf(br.readLine().substring(1));
				int hotelID = Integer.valueOf(br.readLine().substring(1));
				int userID = Integer.valueOf(br.readLine().substring(1));
				String status = br.readLine().substring(1);
				ListStatus liststatus;
				if(status.equals("ABNORMAL")){
					liststatus = ListStatus.ABNORMAL;
				}else if(status.equals("EXECUTED")){
					liststatus = ListStatus.EXECUTED;
				}else if(status.equals("NOTEXECUTED")){
					liststatus = ListStatus.NOTEXECUTED;
				}else{
					liststatus = ListStatus.REVOKED;
				}
				String entrytime = br.readLine().substring(1);
				String lasttime = br.readLine().substring(1);
				String lastlist = br.readLine().substring(1);
				int price = Integer.valueOf(br.readLine().substring(1));
				int child = Integer.valueOf(br.readLine().substring(1));
				boolean withchild;
				if(child == 0){
					withchild = false;
				}else{
					withchild = true;
				}
				ListPO  listPO = new ListPO(listID, hotelID, userID, liststatus, entrytime, lasttime, lastlist, price, withchild);
				if(Map.containsKey(userID)){
					Map.get(userID).put(listID, listPO);
				}else{
					HashMap<Integer,ListPO> map = new HashMap<Integer, ListPO>();
					map.put(listID, listPO);
					Map.put(userID, map);
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

	public HashMap<Integer, HashMap<Integer, ListPO>> getListDataByHotel() {
		// TODO Auto-generated method stub
		File file = new File("TxtData//List.txt");
		HashMap<Integer,HashMap<Integer,ListPO>> Map = new HashMap<Integer,HashMap<Integer,ListPO>>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int listID = Integer.valueOf(br.readLine().substring(1));
				int hotelID = Integer.valueOf(br.readLine().substring(1));
				int userID = Integer.valueOf(br.readLine().substring(1));
				String status = br.readLine().substring(1);
				ListStatus liststatus;
				if(status.equals("ABNORMAL")){
					liststatus = ListStatus.ABNORMAL;
				}else if(status.equals("EXECUTED")){
					liststatus = ListStatus.EXECUTED;
				}else if(status.equals("NOTEXECUTED")){
					liststatus = ListStatus.NOTEXECUTED;
				}else{
					liststatus = ListStatus.REVOKED;
				}
				String entrytime = br.readLine().substring(1);
				String lasttime = br.readLine().substring(1);
				String lastlist = br.readLine().substring(1);
				int price = Integer.valueOf(br.readLine().substring(1));
				int child = Integer.valueOf(br.readLine().substring(1));
				boolean withchild;
				if(child == 0){
					withchild = false;
				}else{
					withchild = true;
				}
				ListPO  listPO = new ListPO(listID, hotelID, userID, liststatus, entrytime, lasttime, lastlist, price, withchild);
				if(Map.containsKey(hotelID)){
					Map.get(hotelID).put(listID, listPO);
				}else{
					HashMap<Integer,ListPO> map = new HashMap<Integer, ListPO>();
					map.put(listID, listPO);
					Map.put(hotelID, map);
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

	public void updateListDataByUser(HashMap<Integer, HashMap<Integer, ListPO>> listDataMap) {
		// TODO Auto-generated method stub
		File file = new File("TxtData//List.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer, HashMap<Integer, ListPO>>> iterator = listDataMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, HashMap<Integer, ListPO>> entry = iterator.next();
				HashMap<Integer, ListPO> map = entry.getValue();
				Iterator<Map.Entry<Integer, ListPO>> tmp = map.entrySet().iterator();
				while(tmp.hasNext()){
					Map.Entry<Integer, ListPO> temp = tmp.next();
					ListPO listPO = temp.getValue();
					int listid = listPO.getListId();
					int hotelid = listPO.getHotelId();
					int userid = listPO.getUserId();
					ListStatus liststatus = listPO.getStatus();
					String entrytime = listPO.getEntryTime();
					String lasttime = listPO.getLastTime();
					String lastlist = listPO.getLastListExecutedTime();
					int price = listPO.getPrice();
					boolean withchild = listPO.isIfHaveChild();
					String status;
					int child;
					if(liststatus.equals(ListStatus.ABNORMAL)){
						status = "ABNORMAL";
					}else if(liststatus.equals(ListStatus.EXECUTED)){
						status = "EXECUTED";
					}else if(liststatus.equals(ListStatus.NOTEXECUTED)){
						status = "NOTEXECUTED";
					}else{
						status = "REVOKED";
					}
					if(withchild){
						child = 1;
					}else{
						child = 0;
					}
					writer.write("<List>\r\n#" + listid + "\r\n#" + hotelid + "\r\n#" + userid + "\r\n#"
									+ status + "\r\n#" + entrytime + "\r\n#" + lasttime + "\r\n#"
									+ lastlist + "\r\n#" + price + "\r\n#" + child);
					writer.write("\r\n");
				}
				
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateListDataByHotel(HashMap<Integer, HashMap<Integer, ListPO>> listDataMap) {
		// TODO Auto-generated method stub
		
	}

}



