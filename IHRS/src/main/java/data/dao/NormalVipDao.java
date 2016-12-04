package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.NormalVipPO;

public interface NormalVipDao extends java.rmi.Remote {
	public ArrayList<NormalVipPO> getNormaVips(String birthday) throws RemoteException;
	
	public NormalVipPO getNormalVip(int userId) throws RemoteException;
	
	public boolean addNormalVip(NormalVipPO normalVipPO) throws RemoteException;
	
	public boolean updateNormalVip(NormalVipPO normalVipPO) throws RemoteException;
	
	public boolean deleteNormalVip(NormalVipPO normalVipPO) throws RemoteException;
}
