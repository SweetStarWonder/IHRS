package dataDaoTest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import data.dao.impl.CustomerDaoImpl;
import po.CustomerPO;
public class CustomerDaoTest {

	CustomerPO CustomerPO=new CustomerPO(1234,"username","phone");
	
	@Test
	public void testUpdateCustomer() throws Exception{
		CustomerDaoImpl Customer = CustomerDaoImpl.getInstance();
		assertEquals(true,Customer.updateCustomer(CustomerPO));
		
	}
	
	
	@Test
	public void testGetCustomerById()throws RemoteException{
		
		CustomerDaoImpl Customer=CustomerDaoImpl.getInstance();
		CustomerPO CustomerPOtest=Customer.getCustomer(1234);
		
		assertEquals(1234,CustomerPOtest.getId());
		assertEquals("username",CustomerPOtest.getUserName());
		assertEquals("phone",CustomerPOtest.getPhone());
	}
	
	
	@Test
	public void testGetCustomerByName()throws RemoteException{
		
		CustomerDaoImpl Customer=CustomerDaoImpl.getInstance();
		CustomerPO CustomerPOtest=Customer.getCustomer("username");
		
		assertEquals(1234,CustomerPOtest.getId());
		assertEquals("username",CustomerPOtest.getUserName());
		assertEquals("phone",CustomerPOtest.getPhone());
		
	}
	
	
	
	
	
	
}