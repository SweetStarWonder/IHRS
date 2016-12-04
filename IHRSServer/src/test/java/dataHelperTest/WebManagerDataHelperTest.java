package dataHelperTest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.WebManagerDataTxtHelper;
import po.WebManagerPO;

public class WebManagerDataHelperTest {

	static WebManagerDataTxtHelper WebManager = new WebManagerDataTxtHelper();
	
	@BeforeClass
	public static void testWebManagerDataHelper(){
		WebManagerPO WebManagerpo = new WebManagerPO(1234,"username","15105198966");
		HashMap<Integer,WebManagerPO> map = new HashMap<Integer,WebManagerPO>();
		map.put(1234, WebManagerpo);
		WebManager.updateWebManagerData(map);
	}
	
	@Test
	public void testgetWebManagerData(){
		WebManagerPO webmanagerpo = WebManager.getWebManagerData().get(1234);
		assertEquals(1234,webmanagerpo.getId());
		assertEquals("username",webmanagerpo.getUserName());
		assertEquals("15105198966",webmanagerpo.getPhone());
	}
	
	

}
