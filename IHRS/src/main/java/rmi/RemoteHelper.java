package rmi;

import java.rmi.Remote;

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

public class RemoteHelper {

	Remote creditChangeDao;
	Remote customerDao;
	Remote enterpriseVipDao;
	Remote evaluateDao;
	Remote hotelDao;
	Remote hotelManagerDao;
	Remote listDao;
	Remote normalVipDao;
//	Remote promotionDao;
	Remote roomDao;
	Remote webManagerDao;
	Remote webSaleDao;
	
	private static RemoteHelper remoteHelper=new RemoteHelper();
	
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	private RemoteHelper() {
	}

	public CreditChangeDao getCreditChangeDao() {
		return (CreditChangeDao)creditChangeDao;
	}
	public void setCreditChangeDao(Remote creditChangeDao) {
		this.creditChangeDao = creditChangeDao;
	}
	public CustomerDao getCustomerDao() {
		return (CustomerDao)customerDao;
	}
	public void setCustomerDao(Remote customerDao) {
		this.customerDao = customerDao;
	}
	public EnterpriseVipDao getEnterpriseVipDao() {
		return (EnterpriseVipDao)enterpriseVipDao;
	}
	public void setEnterpriseVipDao(Remote enterpriseVipDao) {
		this.enterpriseVipDao = enterpriseVipDao;
	}
	public EvaluateDao getEvaluateDao() {
		return (EvaluateDao)evaluateDao;
	}
	public void setEvaluateDao(Remote evaluateDao) {
		this.evaluateDao = evaluateDao;
	}
	public HotelDao getHotelDao() {
		return (HotelDao)hotelDao;
	}
	public void setHotelDao(Remote hotelDao) {
		this.hotelDao = hotelDao;
	}
	public HotelManagerDao getHotelManagerDao() {
		return (HotelManagerDao)hotelManagerDao;
	}
	public void setHotelManagerDao(Remote hotelManagerDao) {
		this.hotelManagerDao = hotelManagerDao;
	}
	public ListDao getListDao() {
		return (ListDao)listDao;
	}
	public void setListDao(Remote listDao) {
		this.listDao = listDao;
	}
	public NormalVipDao getNormalVipDao() {
		return (NormalVipDao)normalVipDao;
	}
	public void setNormalVipDao(Remote normalVipDao) {
		this.normalVipDao = normalVipDao;
	}
	public RoomDao getRoomDao() {
		return (RoomDao)roomDao;
	}
	public void setRoomDao(Remote roomDao) {
		this.roomDao = roomDao;
	}
	public WebManagerDao getWebManagerDao() {
		return (WebManagerDao)webManagerDao;
	}
	public void setWebManagerDao(Remote webManagerDao) {
		this.webManagerDao = webManagerDao;
	}
	public WebSaleDao getWebSaleDao() {
		return (WebSaleDao)webSaleDao;
	}
	public void setWebSaleDao(Remote webSaleDao) {
		this.webSaleDao = webSaleDao;
	}
	
}
