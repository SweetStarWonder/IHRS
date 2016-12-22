package data.dao.impl;

import java.rmi.RemoteException;
import java.util.HashMap;

import data.dao.PasswordDao;
import data.dataHelper.DataFactory;
import data.dataHelper.PasswordDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.PasswordPO;

public class PasswordDaoImpl extends java.rmi.server.UnicastRemoteObject implements PasswordDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5816967170497320015L;
	
	
	private HashMap<Integer,PasswordPO> idMap;
	
	private HashMap<String,PasswordPO> nameMap;
	
	private PasswordDataHelper passwordDataHelper;
	
	private DataFactory dataFactory;
	
	private static PasswordDaoImpl passwordDaoImpl;
	
	public static PasswordDaoImpl getInstance() throws RemoteException{
		if(passwordDaoImpl==null){
			passwordDaoImpl=new PasswordDaoImpl();
		}
		return passwordDaoImpl;
	}
	
	private PasswordDaoImpl() throws RemoteException {
		if(idMap==null || nameMap==null){
			dataFactory=new DataFactoryImpl();
			passwordDataHelper=dataFactory.getPasswordDataHelper();
			idMap=passwordDataHelper.getPasswordById();
			nameMap=passwordDataHelper.getPasswordByName();
		}
	}

	public PasswordPO getPasswordById(int userId) throws RemoteException{
		if(idMap.containsKey(userId)){
			PasswordPO passwordPO=idMap.get(userId);
			return passwordPO;
		}
		else{
			return null;
		}
	}

	public PasswordPO getPasswordByName(String userName) throws RemoteException{
		if(nameMap.containsKey(userName)){
			PasswordPO passwordPO=nameMap.get(userName);
			return passwordPO;
		}
		else{
			return null;
		}
	}

	public boolean addPassword(PasswordPO passwordPO) throws RemoteException{
		int userId=passwordPO.getUserId();
		String userName=passwordPO.getUserName();
		if((!idMap.containsKey(userId)) && (!nameMap.containsKey(userName))){
			idMap.put(userId,passwordPO);
			nameMap.put(userName, passwordPO);
			passwordDataHelper.updatePasswordById(idMap);
			return true;
		}
		else{
			return false;
		}
	}

	public boolean updatePassword(PasswordPO passwordPO) throws RemoteException{
		int userId=passwordPO.getUserId();
		String userName=passwordPO.getUserName();
		if(idMap.containsKey(userId)){
			idMap.put(userId,passwordPO);
			nameMap.put(userName, passwordPO);
			passwordDataHelper.updatePasswordById(idMap);
			return true;
		}
		else{
			return false;
		}
	}

}
