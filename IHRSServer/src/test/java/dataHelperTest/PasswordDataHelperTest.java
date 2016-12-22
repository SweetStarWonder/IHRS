package dataHelperTest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import data.dataHelper.impl.PasswordDataTxtHelper;
import po.PasswordPO;

public class PasswordDataHelperTest {

	int userid = 1234;
	String userName = "username";
	String password = "password";
	String userType = "usertype";
	PasswordDataTxtHelper passwordDataHelperImpl = new PasswordDataTxtHelper();
	

	
	@Test
	public void testupdatePasswordById(){
		PasswordPO passwordPO = new PasswordPO(userid, userName, password, userType);
		HashMap<Integer, PasswordPO> map = new HashMap<Integer, PasswordPO>();
		map.put(userid, passwordPO);
		passwordDataHelperImpl.updatePasswordById(map);
		
	}
	@Test
	public void testgetPasswordbyId() {
	
		assertEquals(userid, passwordDataHelperImpl.getPasswordById().get(userid).getUserId());
		assertEquals("username", passwordDataHelperImpl.getPasswordById().get(userid).getUserName());

		assertEquals("password", passwordDataHelperImpl.getPasswordById().get(userid).getPassword());

		assertEquals("usertype", passwordDataHelperImpl.getPasswordById().get(userid).getUserType());

	}

}
