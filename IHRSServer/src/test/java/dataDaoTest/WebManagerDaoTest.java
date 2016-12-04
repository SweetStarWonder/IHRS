package dataDaoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import data.dao.impl.WebManagerDaoImpl;
import po.WebManagerPO;

public class WebManagerDaoTest {

	WebManagerPO webManagerPO = new WebManagerPO(1234,"username","15105198966");
	
	@Test
	public void testupdateWebManager()throws Exception{
		WebManagerDaoImpl webManager = WebManagerDaoImpl.getInstance();
		assertEquals(true,webManager.updateWebManager(webManagerPO));
	}
	
	@Test
	public void testgetWebManager()throws Exception{
		WebManagerDaoImpl webManager = WebManagerDaoImpl.getInstance();
		WebManagerPO webmanager = webManager.getWebManager(1234);
		assertEquals(1234,webmanager.getId());
		assertEquals("username",webmanager.getUserName());
		assertEquals("15105198966",webmanager.getPhone());
	}

}
