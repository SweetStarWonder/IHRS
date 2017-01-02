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

import data.dataHelper.RoomInListDataHelper;

public class RoomInListDataTxtHelper implements RoomInListDataHelper{

	@Override
	public HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> getRooms() {
		File file = new File("src//main//resources//RoomInList.txt");
		HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> Map = new HashMap<Integer, HashMap<Integer, ArrayList<Integer>>>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				int listid = Integer.valueOf(br.readLine().substring(1));
				int hotelid = Integer.valueOf(br.readLine().substring(1));
				ArrayList<Integer> Rooms = new ArrayList<>();
				String read = br.readLine();
				String room = read.substring(1,read.length() - 1);
				String temp[] = room.split(";");
				for(String s: temp){
					Rooms.add(Integer.parseInt(s));
				}
				if(Map.containsKey(listid)){
					Map.get(listid).put(hotelid, Rooms);
				}else{
					HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
					map.put(hotelid, Rooms);
					Map.put(listid, map);
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

	@Override
	public void updateRoom(HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> roomMap) {
		File file = new File("src//main//resources//RoomInList.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			//对map进行遍历
			Iterator<Map.Entry<Integer, HashMap<Integer, ArrayList<Integer>>>> iterator = roomMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, HashMap<Integer, ArrayList<Integer>>> entry = iterator.next();
				HashMap<Integer, ArrayList<Integer>> map = entry.getValue();
				Iterator<Map.Entry<Integer, ArrayList<Integer>>> temp = map.entrySet().iterator();
				while(temp.hasNext()){
					Map.Entry<Integer, ArrayList<Integer>> tmp = temp.next();
					@SuppressWarnings("unchecked")
					ArrayList<Integer> rooms = (ArrayList<Integer>) tmp.getValue().clone();
					int listid = entry.getKey();
					int hotelid = tmp.getKey();
					writer.write("<RoomInList>\r\n#" + listid + "\r\n#" + hotelid + "\r\n#");
					while(!rooms.isEmpty()){
						int value = rooms.get(0);
						writer.write(value + ";");
						rooms.remove(0);
					}
					writer.write("\r\n");
				}
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
