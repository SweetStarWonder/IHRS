package dataDaoTest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Ignore;
import org.junit.Test;

import data.dao.impl.EnterpriseVipDaoImpl;
import po.EnterpriseVipPO;


public class EnterpriseVipDaoTest {

	EnterpriseVipPO EnterpriseVipPO=new EnterpriseVipPO(111,"111","111","111",111);
	
	@Test
	public void testAddEnterpriseVip () throws Exception{
		EnterpriseVipDaoImpl EnterpriseVip =EnterpriseVipDaoImpl.getInstance();
		assertEquals(false,EnterpriseVip.addEnterpriseVip(EnterpriseVipPO));
		
	}
	
	@Test
	public void testUpdateEnterpriseVip() throws Exception{
		EnterpriseVipDaoImpl EnterpriseVip = EnterpriseVipDaoImpl.getInstance();
		assertEquals(true,EnterpriseVip.updateEnterpriseVip(EnterpriseVipPO));
		
	}
	

	@Test
	public void testGetEnterpriseVip()throws RemoteException{
		
		EnterpriseVipDaoImpl EnterpriseVip=EnterpriseVipDaoImpl.getInstance();
		EnterpriseVipPO EnterpriseVipPOtest=EnterpriseVip.getEnterpriseVip(111);
		
		assertEquals(111,EnterpriseVipPOtest.getId());
		assertEquals("111",EnterpriseVipPOtest.getUserName());
		assertEquals("111",EnterpriseVipPOtest.getPhone());
		assertEquals("111",EnterpriseVipPOtest.getEnterpriseName());
		assertEquals(111,EnterpriseVipPOtest.getBonus());
		
	}
	
	@Ignore
	public void testDeleteEnterpriseVip () throws Exception{
		EnterpriseVipDaoImpl EnterpriseVip =EnterpriseVipDaoImpl.getInstance();
		assertEquals(true,EnterpriseVip.deleteEnterpriseVip(EnterpriseVipPO));
		
	}
	
	
}
