package dataDaoTest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.dao.impl.CreditChangeDaoImpl;
import po.CreditChangePO;
import po.CreditChangeMove;

public class CreditChangeDaoTest {
	CreditChangeMove move=CreditChangeMove.LISTEXECUTE;
	CreditChangePO CreditChangePO=new CreditChangePO(1234,"20161001","1111",111,111,move);
	
	
	@Test
	public void testAddCreditChange() throws Exception{
		CreditChangeDaoImpl CreditChange = CreditChangeDaoImpl.getInstance();
		assertEquals(true,CreditChange.addCreditChange(CreditChangePO));
		
	}
	
	
	@Test
	public void testGetCreditChange()throws RemoteException{
		
		
		CreditChangeDaoImpl CreditChange=CreditChangeDaoImpl.getInstance();
		ArrayList<CreditChangePO> list = new ArrayList<CreditChangePO>(); 
		list=CreditChange.getCreditChange(1234);
		CreditChangePO CreditChangePOtest=list.get(0);
		
		assertEquals(1234,CreditChangePOtest.getUserId());
		assertEquals("20161001",CreditChangePOtest.getTime());
		assertEquals("1111",CreditChangePOtest.getListId());
		assertEquals(111,CreditChangePOtest.getChange());
		assertEquals(111,CreditChangePOtest.getResult());
		assertEquals(move,CreditChangePOtest.getCreditChangeMove());


		
	}
	
	
	
}
