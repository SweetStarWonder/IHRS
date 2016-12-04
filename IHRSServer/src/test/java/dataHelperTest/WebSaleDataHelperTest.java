  package dataHelperTest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.WebSaleDataTxtHelper;
import po.WebSalePO;



public class WebSaleDataHelperTest {
	
	static WebSaleDataTxtHelper webSale = new WebSaleDataTxtHelper();
	
	@BeforeClass
	public static void testWebSaleDataHelper(){
		WebSalePO websalepo = new WebSalePO(1234,"username","15105198966");
		HashMap<String,WebSalePO> map = new HashMap<String,WebSalePO>();
		map.put("username", websalepo);
		webSale.updateWebSaleDataByName(map);
	}
	
	@Test
	public void testgetWebSaleDataById(){
		WebSalePO websalepo = webSale.getWebSaleDataById().get(1234);
		assertEquals(1234, websalepo.getId());
		assertEquals("username",websalepo.getUserName());
		assertEquals("15105198966",websalepo.getPhone());
	}
	
	@Test
	public void testgetWebSaleDataByName(){
		WebSalePO websalepo = webSale.getWebSaleDataByName().get("username");
		assertEquals(1234,websalepo.getId());
		assertEquals("username",websalepo.getUserName());
		assertEquals("15105198966",websalepo.getPhone());
	}
	
	

}
