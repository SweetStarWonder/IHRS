package data.dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import data.dao.AddressDao;
import data.dataHelper.AddressDataHelper;
import data.dataHelper.DataFactory;
import data.dataHelper.impl.DataFactoryImpl;

public class AddressDaoImpl extends UnicastRemoteObject implements AddressDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private HashMap<String,ArrayList<String>> map;
	
	private AddressDataHelper addressDataHelper;
	
	private DataFactory dataFactory;
	
	private static AddressDaoImpl addressDaoImpl;
	
	public static AddressDaoImpl getInstance() throws RemoteException{
		if(addressDaoImpl==null){
			addressDaoImpl=new AddressDaoImpl();
		}
		return addressDaoImpl;
	}
	
	private AddressDaoImpl() throws RemoteException{
		if(map==null){
			dataFactory=new DataFactoryImpl();
			addressDataHelper=dataFactory.getAddressDataHelper();
			map=addressDataHelper.getAddresses();
		}
	}

	public HashMap<String, ArrayList<String>> getAddresses() throws RemoteException {
		return this.map;
	}

}
