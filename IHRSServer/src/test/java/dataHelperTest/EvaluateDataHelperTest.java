package dataHelperTest;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import data.dataHelper.impl.EvaluateDataTxtHelper;
import po.EvaluatePO;

public class EvaluateDataHelperTest {


	static EvaluateDataTxtHelper Evaluate = new EvaluateDataTxtHelper();
	
	@BeforeClass
	public static void testEvaluateDataHelper(){
		

		EvaluatePO Evaluatepo = new EvaluatePO(1111,"software",100,"100");
		ArrayList<EvaluatePO> list = new ArrayList<EvaluatePO>(); 
		HashMap<Integer, ArrayList<EvaluatePO>> map=new HashMap<Integer, ArrayList<EvaluatePO>>();
		list.add(Evaluatepo);
		map.put(1111, list);
		Evaluate.updateEvaluateData(map);
		
	}
	
	@Test
	public void testgetEvaluateData(){
		EvaluatePO EvaluatePO = Evaluate.getEvaluateData().get(1111).get(0);
		assertEquals(1111,EvaluatePO.getHotelId());
		assertEquals("software",EvaluatePO.getCustomerName());
		assertEquals(10,EvaluatePO.getRankValue());
		assertEquals("100",EvaluatePO.getContents());

	}
}
