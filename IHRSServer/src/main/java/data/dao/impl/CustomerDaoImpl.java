package data.dao.impl;

import java.rmi.RemoteException;
import java.util.HashMap;

import data.dao.CustomerDao;
import data.dataHelper.CustomerDataHelper;
import data.dataHelper.DataFactory;
import data.dataHelper.impl.DataFactoryImpl;
import po.CustomerPO;

public class CustomerDaoImpl extends java.rmi.server.UnicastRemoteObject implements CustomerDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8022858008908310268L;

	private HashMap<Integer,CustomerPO> idMap;
	
	private HashMap<String,CustomerPO> nameMap;
	
	private CustomerDataHelper customerDataHelper;
	
	private DataFactory dataFactory;
	
	private static CustomerDaoImpl customerDaoImpl;
	
	public static CustomerDaoImpl getInstance() throws RemoteException{
		if(customerDaoImpl==null){
			customerDaoImpl=new CustomerDaoImpl();
		}
		return customerDaoImpl;
	}
	
	private CustomerDaoImpl() throws RemoteException {
		if(idMap==null || nameMap==null){
			dataFactory=new DataFactoryImpl();
			customerDataHelper=dataFactory.getCustomerDataHelper();
			idMap=customerDataHelper.getCustomerDataById();
			nameMap=customerDataHelper.getCustomerDataByName();
		}
	}

	public CustomerPO getCustomer(int userId) throws RemoteException {
		CustomerPO customerPO=idMap.get(userId);
		return customerPO;
	}

	public CustomerPO getCustomer(String userName) throws RemoteException {
		CustomerPO customerPO=nameMap.get(userName);
		return customerPO;
	}

	public boolean updateCustomer(CustomerPO customerPO) throws RemoteException {
		int customerId=customerPO.getId();
		String customerName=customerPO.getUserName();
		if(idMap.containsKey(customerId)){
			idMap.put(customerId,customerPO);
			nameMap.put(customerName,customerPO);
			customerDataHelper.updateCustomerDataById(idMap);
			return true;
		}
		else{
			return false;
		}
	}

	public boolean addCustomer(CustomerPO customerPO) throws RemoteException {
		int customerId=customerPO.getId();
		String customerName=customerPO.getUserName();
		if(!idMap.containsKey(customerId)){
			idMap.put(customerId,customerPO);
			nameMap.put(customerName,customerPO);
			customerDataHelper.updateCustomerDataById(idMap);
			return true;
		}
		else{
			return false;
		}
	}

}
