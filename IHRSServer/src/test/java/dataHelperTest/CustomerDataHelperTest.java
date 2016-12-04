package dataHelperTest;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;

import data.dataHelper.impl.CustomerDataTxtHelper;
import po.CustomerPO;

public class CustomerDataHelperTest {


	static CustomerDataTxtHelper Customer = new CustomerDataTxtHelper();
	
	@BeforeClass
	public static void testUpdateCustomerDataById(){
		

		CustomerPO Customerpo = new CustomerPO(1111,"software","1234");
		HashMap<Integer,  CustomerPO> map = new HashMap<Integer, CustomerPO>();
		map.put(1111, Customerpo);
		Customer.updateCustomerDataById(map);
		
	}
	
	
	
	@Test
	public void testGetCustomerDataById(){
		CustomerPO customerPO = Customer.getCustomerDataById().get(1111);
		assertEquals(1111,customerPO.getId());
		assertEquals("software",customerPO.getUserName());
		assertEquals("1234",customerPO.getPhone());
		
	}

}
