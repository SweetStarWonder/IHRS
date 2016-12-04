package dataHelperTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.CreditChangeDataTxtHelper;
import po.CreditChangeMove;
import po.CreditChangePO;

public class CreditChangeDataHelperTest {


	static CreditChangeDataTxtHelper CreditChange = new CreditChangeDataTxtHelper();
	
	@BeforeClass
	public static void testCreditChangeDataHelper(){
		
        CreditChangeMove creditChangeMove=CreditChangeMove.LISTEXECUTE;
		CreditChangePO CreditChangepo = new CreditChangePO(1111,"software","1234",100,100,creditChangeMove);
		ArrayList<CreditChangePO> list = new ArrayList<CreditChangePO>(); 
		HashMap<Integer, ArrayList<CreditChangePO>> map=new HashMap<Integer, ArrayList<CreditChangePO>>();
		list.add(CreditChangepo);
		map.put(1111, list);
		CreditChange.updateCreditChangeData(map);
		
	}
	
	@Test
	public void testgetCreditChangeData(){
		CreditChangePO creditChangePO = CreditChange.getCreditChangeData().get(1111).get(0);
		CreditChangeMove creditChangeMove=CreditChangeMove.LISTEXECUTE;
		assertEquals(1111,creditChangePO.getUserId());
		assertEquals("software",creditChangePO.getTime());
		assertEquals("1234",creditChangePO.getListId());
		assertEquals(100,creditChangePO.getChange());
		assertEquals(100,creditChangePO.getResult());
		assertEquals(creditChangeMove,creditChangePO.getCreditChangeMove());
	}

}
