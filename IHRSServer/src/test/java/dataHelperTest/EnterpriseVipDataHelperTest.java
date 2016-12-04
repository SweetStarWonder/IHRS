package dataHelperTest;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;

import data.dataHelper.impl.EnterpriseVipDataTxtHelper;
import po.EnterpriseVipPO;

public class EnterpriseVipDataHelperTest {


	static EnterpriseVipDataTxtHelper EnterpriseVip = new EnterpriseVipDataTxtHelper();
	
	@BeforeClass
	public static void testEnterpriseVipDataHelper(){
		

		EnterpriseVipPO EnterpriseVippo = new EnterpriseVipPO(1111,"1111","1111","1111",100);
		HashMap<Integer, EnterpriseVipPO> map = new HashMap<Integer, EnterpriseVipPO>();
		map.put(1111, EnterpriseVippo);
		EnterpriseVip.updateEnterpriseVipData(map);
		
	}
	
	@Test
	public void testgetEnterpriseVipData(){
		EnterpriseVipPO EnterpriseVipPO = EnterpriseVip.getEnterpriseVipData().get(1111);
		assertEquals(1111,EnterpriseVipPO.getId());
		assertEquals("1111",EnterpriseVipPO.getUserName());
		assertEquals("1111",EnterpriseVipPO.getPhone());
		assertEquals("1111",EnterpriseVipPO.getEnterpriseName());
		assertEquals(100,EnterpriseVipPO.getBonus());
	}

}
