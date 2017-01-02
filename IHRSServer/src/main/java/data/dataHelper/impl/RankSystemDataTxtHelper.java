package data.dataHelper.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

import data.dataHelper.RankSystemDataHelper;

public class RankSystemDataTxtHelper implements RankSystemDataHelper{

	public HashMap<Integer, Integer> getRanks() {
		File file = new File("src//main//resources//RankSystem.txt");
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				String num[] = str.substring(1).split(";");
				int rank = Integer.valueOf(num[0]);
				int creditvalue = Integer.valueOf(num[1]);
				map.put(rank, creditvalue);
				str = br.readLine();
			}
			br.close();
			return map;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateRank(HashMap<Integer, Integer> ranks) {
		File file = new File("src//main//resources//RankSystem.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Integer> iterator = ranks.keySet().iterator();
			while(iterator.hasNext()){
				Integer entry = iterator.next();
				int rank = entry;
				int creditvalue = ranks.get(entry);
				writer.write("#" + rank + ";" + creditvalue);
				writer.write("\r\n");
			}
			writer.close();	
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

