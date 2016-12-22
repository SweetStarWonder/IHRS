package dataHelperTest;

import static org.junit.Assert.*;

import org.junit.Test;

import data.dataHelper.impl.AddressDataTxtHelper;

public class AddressDataHelperTest {

	@Test
	public void test() {
		AddressDataTxtHelper adt = new AddressDataTxtHelper();
		assertEquals(true,adt.getAddresses().containsKey("businessDistrict1"));
		assertEquals("address1",adt.getAddresses().get("businessDistrict1").get(0));
	}

}
