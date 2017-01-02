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

import data.dataHelper.RoomDataHelper;
import po.RoomPO;
import po.RoomStatus;

public class RoomDataTxtHelper implements RoomDataHelper{

	public RoomDataTxtHelper() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<Integer, HashMap<Integer, RoomPO>> getRoomData() {
		// TODO Auto-generated method stub
		File file = new File("src//main//resources//Room.txt");
		HashMap<Integer,HashMap<Integer,RoomPO>> Map = new HashMap<Integer,HashMap<Integer,RoomPO>>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int hotelID = Integer.valueOf(br.readLine().substring(1));
				int listID = Integer.valueOf(br.readLine().substring(1));
				int roomNum = Integer.valueOf(br.readLine().substring(1));
				int price = Integer.valueOf(br.readLine().substring(1));
				String status = br.readLine().substring(1);
				RoomStatus roomstatus;
				if(status.equals("SINGLE")){
					roomstatus = RoomStatus.SINGLE;
				}else if(status.equals("DOUBLE")){
					roomstatus = RoomStatus.DOUBLE;
				}else{
					roomstatus = RoomStatus.TRIPLE;
				}
				RoomPO  roomPO = new RoomPO(hotelID, listID, roomNum, price, roomstatus);
				if(Map.containsKey(hotelID)){
					Map.get(hotelID).put(roomNum, roomPO);
				}else{
					HashMap<Integer,RoomPO> map = new HashMap<Integer, RoomPO>();
					map.put(roomNum, roomPO);
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

	public void updateRoomData(HashMap<Integer, HashMap<Integer, RoomPO>> roomDataMap) {
		// TODO Auto-generated method stub
		File file = new File("src//main//resources//Room.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer, HashMap<Integer, RoomPO>>> iterator = roomDataMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, HashMap<Integer, RoomPO>> entry = iterator.next();
				HashMap<Integer, RoomPO> map = entry.getValue();
				Iterator<Map.Entry<Integer, RoomPO>> tmp = map.entrySet().iterator();
				while(tmp.hasNext()){
					Map.Entry<Integer, RoomPO> temp = tmp.next();
					RoomPO roomPO = temp.getValue();
					int hotelid = roomPO.getHotelId();
					int listid = roomPO.getListId();
					int roomnum = roomPO.getRoomNum();
					int price = roomPO.getPrice();
					RoomStatus roomstatus = roomPO.getStatus();
					String status;
					if(roomstatus.equals(RoomStatus.SINGLE)){
						status = "SINGLE";
					}else if(roomstatus.equals(RoomStatus.DOUBLE)){
						status = "DOUBLE";
					}else{
						status = "TRIPLE";
					}
					writer.write("<Room>\r\n#" + hotelid + "\r\n#" + listid + "\r\n#" + roomnum + "\r\n#"
							+ price + "\r\n#" + status);
					writer.write("\r\n");
				}
				
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
