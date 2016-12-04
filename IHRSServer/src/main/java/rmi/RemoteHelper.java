package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.dao.CreditChangeDao;
import data.dao.CustomerDao;
import data.dao.EnterpriseVipDao;
import data.dao.EvaluateDao;
import data.dao.HotelDao;
import data.dao.HotelManagerDao;
import data.dao.ListDao;
import data.dao.NormalVipDao;
import data.dao.RoomDao;
import data.dao.WebManagerDao;
import data.dao.WebSaleDao;
import data.dao.impl.CreditChangeDaoImpl;
import data.dao.impl.CustomerDaoImpl;
import data.dao.impl.EnterpriseVipDaoImpl;
import data.dao.impl.EvaluateDaoImpl;
import data.dao.impl.HotelDaoImpl;
import data.dao.impl.HotelManagerDaoImpl;
import data.dao.impl.ListDaoImpl;
import data.dao.impl.NormalVipDaoImpl;
import data.dao.impl.RoomDaoImpl;
import data.dao.impl.WebManagerDaoImpl;
import data.dao.impl.WebSaleDaoImpl;

public class RemoteHelper {
	
	public RemoteHelper() {
		initServer();
	}
	public void initServer(){
		CreditChangeDao creditChangeDao;
		CustomerDao customerDao;
		EnterpriseVipDao enterpriseVipDao;
		EvaluateDao evaluateDao;
		HotelDao hotelDao;
		HotelManagerDao hotelManagerDao;
		ListDao listDao;
		NormalVipDao normalVipDao;
//		PromotionDao promotionDao;
		RoomDao roomDao;
		WebManagerDao webManagerDao;
		WebSaleDao webSaleDao;
		
		
		try {
			
			creditChangeDao=CreditChangeDaoImpl.getInstance();
			customerDao=CustomerDaoImpl.getInstance();
			enterpriseVipDao=EnterpriseVipDaoImpl.getInstance();
			evaluateDao=EvaluateDaoImpl.getInstance();
			hotelDao=HotelDaoImpl.getInstance();
			hotelManagerDao=HotelManagerDaoImpl.getInstance();
			listDao=ListDaoImpl.getInstance();
			normalVipDao=NormalVipDaoImpl.getInstance();
//		promotionDao=PromotionDaoImpl.getInstance();
			roomDao=RoomDaoImpl.getInstance();
			webManagerDao=WebManagerDaoImpl.getInstance();
			webSaleDao=WebSaleDaoImpl.getInstance();
			
			LocateRegistry.createRegistry(6666);
			
			Naming.bind("rmi://localhost:6666/CreditChangeDao",creditChangeDao);
			Naming.bind("rmi://localhost:6666/CustomerDao",customerDao);
			Naming.bind("rmi://localhost:6666/EnterpriseVipDao",enterpriseVipDao);
			Naming.bind("rmi://localhost:6666/EvaluateDao",evaluateDao);
			Naming.bind("rmi://localhost:6666/HotelDao",hotelDao);
			Naming.bind("rmi://localhost:6666/HotelManagerDao",hotelManagerDao);
			Naming.bind("rmi://localhost:6666/ListDao",listDao);
			Naming.bind("rmi://localhost:6666/NormalVipDao",normalVipDao);
			Naming.bind("rmi://localhost:6666/RoomDao",roomDao);
			Naming.bind("rmi://localhost:6666/WebManagerDao",webManagerDao);
			Naming.bind("rmi://localhost:6666/WebSaleDao",webSaleDao);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}
