package dataHelperTest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.NormalVipDataTxtHelper;
import po.NormalVipPO;

public class NormalVipDataHelperTest {

	static NormalVipDataTxtHelper NormalVip = new NormalVipDataTxtHelper();
	
	@BeforeClass
	public static void testNormalVipDataHelper(){
		NormalVipPO NormalVippo = new NormalVipPO(1234,"username","15105198966",50,"19980705");
		HashMap<Integer,NormalVipPO> map = new HashMap<Integer,NormalVipPO>();
		map.put(5, NormalVippo);
		NormalVip.updateNormalVipData(map);
	}
	
	@Test
	public void testgetNormalVipData(){
		NormalVipPO normalvip = NormalVip.getNormalVipData().get(1234);
		assertEquals(1234, normalvip.getId());
		assertEquals("username",normalvip.getUserName());
		assertEquals("15105198966",normalvip.getPhone());
		assertEquals(50,normalvip.getBonus());
		assertEquals("19980705",normalvip.getBirthday());
	}
	

}
