package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public interface AddressDao extends java.rmi.Remote{
	
	/**
	 * @return  所在商圈的所有地址（左商圈，右地址）
	 * @throws RemoteException
	 */
	public HashMap<String,ArrayList<String>> getAddresses() throws RemoteException;
	
}