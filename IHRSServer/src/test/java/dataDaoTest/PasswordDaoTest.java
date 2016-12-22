package dataDaoTest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import data.dao.impl.PasswordDaoImpl;
import po.PasswordPO;

public class PasswordDaoTest {

	int userId = 1235;
	String userName = "username";
	String password = "password";
	String userType = "usertype";
	
	@Test
	public void testgetPasswordById() throws RemoteException {
		PasswordDaoImpl passwordDaoImpl = PasswordDaoImpl.getInstance();
		PasswordPO passwordPO = new PasswordPO(userId, userName, password, userType);
		assertEquals(true,passwordDaoImpl.addPassword(passwordPO));
		assertEquals(userId, passwordDaoImpl.getPasswordById(userId).getUserId());
		assertEquals(userName, passwordDaoImpl.getPasswordById(userId).getUserName());
		assertEquals(userType, passwordDaoImpl.getPasswordById(userId).getUserType());
		
	}

	@Test
	public void testgetPasswordByName() throws RemoteException {
		PasswordDaoImpl passwordDaoImpl = PasswordDaoImpl.getInstance();
		PasswordPO passwordPO = new PasswordPO(userId, userName, password, userType);
		assertEquals(true,passwordDaoImpl.updatePassword(passwordPO));
		assertEquals(userId, passwordDaoImpl.getPasswordByName(userName).getUserId());
		assertEquals(userName, passwordDaoImpl.getPasswordByName(userName).getUserName());
		assertEquals(userType, passwordDaoImpl.getPasswordByName(userName).getUserType());
		
	}
}
