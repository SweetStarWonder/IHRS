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

import data.dataHelper.EvaluateDataHelper;
import po.EvaluatePO;

public class EvaluateDataTxtHelper implements EvaluateDataHelper{

    public HashMap<Integer, ArrayList<EvaluatePO>> getEvaluateData(){
    	File file = new File("src//main//resources//Evaluate.txt");
    	HashMap<Integer, ArrayList<EvaluatePO>> Map = new HashMap<Integer, ArrayList<EvaluatePO>>();
		
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str != null;){
				
				int hotelId = Integer.valueOf(br.readLine().substring(1));
				String customerName= br.readLine().substring(1);
				int rankValue = Integer.valueOf(br.readLine().substring(1));
				String contents= br.readLine().substring(1);
				
				EvaluatePO evaluatePO= new EvaluatePO(hotelId,customerName,rankValue,contents);
				if(Map.containsKey(hotelId)){
					Map.get(hotelId).add(evaluatePO);
				}else{
					ArrayList<EvaluatePO> list=new ArrayList<EvaluatePO>(); 
					list.add(evaluatePO);
					Map.put(hotelId, list);
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
	
	public void updateEvaluateData(HashMap<Integer, ArrayList<EvaluatePO>> evaluateDataMap){
		File file = new File("src//main//resources//Evaluate.txt");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Map.Entry<Integer, ArrayList<EvaluatePO>>> iterator = evaluateDataMap.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, ArrayList<EvaluatePO>> entry = iterator.next();
				ArrayList<EvaluatePO> evaluateArraytmp= entry.getValue();
				@SuppressWarnings("unchecked")
				ArrayList<EvaluatePO> evaluateArray = (ArrayList<EvaluatePO>)evaluateArraytmp.clone();
				while(!evaluateArray.isEmpty()){
					EvaluatePO evaluatePO = evaluateArray.get(0);
					int hotelId = evaluatePO.getHotelId();
					String customerName= evaluatePO.getCustomerName();
					int rankValue =evaluatePO.getRankValue();
					String contents=evaluatePO.getContents();
					
					writer.write("<Evaluate>\r\n#" + hotelId + "\r\n#" + customerName+ "\r\n#" + rankValue+ "\r\n#" + contents);
					writer.write("\r\n");
					evaluateArray.remove(0);
				}
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
