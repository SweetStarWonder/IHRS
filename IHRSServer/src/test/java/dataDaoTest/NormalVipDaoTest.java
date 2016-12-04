package dataDaoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import data.dao.impl.NormalVipDaoImpl;
import po.NormalVipPO;

public class NormalVipDaoTest {

	NormalVipPO normalVipPO = new NormalVipPO(1234,"username","15105198966",50,"19980705");
	
	@Test
	public void testupdateNormalVip() throws Exception{
		NormalVipDaoImpl normalVip = NormalVipDaoImpl.getInstance();
		assertEquals(true,normalVip.updateNormalVip(normalVipPO));
	}

	@Test
	public void testgetNormalVip() throws Exception{
		NormalVipDaoImpl normalVip = NormalVipDaoImpl.getInstance();
		NormalVipPO normalvipid = normalVip.getNormalVip(1234);
		NormalVipPO normalvipname = normalVip.getNormaVips("19980705").get(0);
		assertEquals(1234,normalvipid.getId());
		assertEquals("username",normalvipid.getUserName());
		assertEquals("15105198966",normalvipid.getPhone());
		assertEquals("19980705",normalvipid.getBirthday());
		assertEquals(50,normalvipid.getBonus());
		assertEquals(1234,normalvipname.getId());
		assertEquals("username",normalvipname.getUserName());
		assertEquals("15105198966",normalvipname.getPhone());
		assertEquals("19980705",normalvipname.getBirthday());
		assertEquals(50,normalvipname.getBonus());
	}
}
