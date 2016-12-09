package dataDaoTest;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.dao.impl.EvaluateDaoImpl;
import po.EvaluatePO;

public class EvaluateDaoTest {


	EvaluatePO EvaluatePO=new EvaluatePO(111,"111",111,"111");
	
	@Test
	public void testAddEvaluate () throws Exception{
		EvaluateDaoImpl Evaluate =EvaluateDaoImpl.getInstance();
		assertEquals(true,Evaluate.addEvaluate(EvaluatePO));
		
	}

	

	@Test
	public void testGetEvaluate()throws RemoteException{
		
		EvaluateDaoImpl Evaluate=EvaluateDaoImpl.getInstance();
		ArrayList<EvaluatePO> list=new ArrayList<EvaluatePO>();
		list =Evaluate.getEvaluates(111);
		
		
		
		assertEquals(111,list.get(0).getHotelId());
		assertEquals("111",list.get(0).getCustomerName());
		assertEquals(111,list.get(0).getRankValue());
		assertEquals("111",list.get(0).getContents());
		
	}
}
