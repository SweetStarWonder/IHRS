package dataDaoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import data.dao.impl.WebSaleDaoImpl;
import po.WebSalePO;


public class WebSaleDaoTest {

	WebSalePO webSalePO = new WebSalePO(1234,"username","15105198966");
	
	@Test
	public void testupdateWebSale()throws Exception{
		WebSaleDaoImpl webSale = WebSaleDaoImpl.getInstance();
		assertEquals(true,webSale.updateWebSale(webSalePO));
	}
	
	@Test
	public void testgetWebSale()throws Exception{
		WebSaleDaoImpl webSale = WebSaleDaoImpl.getInstance();
		WebSalePO websaleid = webSale.getWebSale(1234);
		WebSalePO websalename = webSale.getWebSale("username");
		assertEquals(1234,websaleid.getId());
		assertEquals("username",websaleid.getUserName());
		assertEquals("15105198966",websaleid.getPhone());
		assertEquals(1234,websalename.getId());
		assertEquals("15105198966",websalename.getPhone());
		assertEquals("username",websalename.getUserName());
	}

}
