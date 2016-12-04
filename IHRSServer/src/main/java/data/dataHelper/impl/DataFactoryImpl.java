package data.dataHelper.impl;

import data.dataHelper.CreditChangeDataHelper;
import data.dataHelper.CustomerDataHelper;
import data.dataHelper.DataFactory;
import data.dataHelper.EnterpriseVipDataHelper;
import data.dataHelper.EvaluateDataHelper;
import data.dataHelper.HotelDataHelper;
import data.dataHelper.HotelManagerDataHelper;
import data.dataHelper.ListDataHelper;
import data.dataHelper.NormalVipDataHelper;
import data.dataHelper.PromotionDataHelper;
import data.dataHelper.RoomDataHelper;
import data.dataHelper.WebManagerDataHelper;
import data.dataHelper.WebSaleDataHelper;

public class DataFactoryImpl implements DataFactory{

	public CreditChangeDataHelper getCreditChangeDataHelper() {
		CreditChangeDataHelper creditChangeDao=new CreditChangeDataTxtHelper();
		return creditChangeDao;
	}

	public CustomerDataHelper getCustomerDataHelper() {
		CustomerDataHelper customerChangeDao=new CustomerDataTxtHelper();
		return customerChangeDao;
	}

	public EnterpriseVipDataHelper getEnterpriseVipDataHelper() {
		EnterpriseVipDataHelper EnterpriseVipDao=new EnterpriseVipDataTxtHelper();
		return EnterpriseVipDao;
	}

	public EvaluateDataHelper getEvaluateDataHelper() {
		EvaluateDataHelper EvaluateDao=new EvaluateDataTxtHelper();
		return EvaluateDao;
	}

	public HotelDataHelper getHotelDataHelper() {
		HotelDataHelper HotelDao=new HotelDataTxtHelper();
		return HotelDao;
	}

	public HotelManagerDataHelper getHotelManagerDataHelper() {
		HotelManagerDataHelper HotelManagerDao=new HotelManagerDataTxtHelper();
		return HotelManagerDao;
	}

	public ListDataHelper getListDataHelper() {
		ListDataHelper ListDao=new ListDataTxtHelper();
		return ListDao;
	}

	public NormalVipDataHelper getNormalVipDataHelper() {
		NormalVipDataHelper NormalVipDao=new NormalVipDataTxtHelper();
		return NormalVipDao;
	}

	public PromotionDataHelper getPromotionDataHelper() {
		
		return null;
	}

	public RoomDataHelper getRoomDataHelper() {
		 RoomDataHelper  RoomDao=new  RoomDataTxtHelper();
		return RoomDao;
	}

	public WebManagerDataHelper getWebManagerDataHelper() {
		WebManagerDataHelper WebManagerDao=new WebManagerDataTxtHelper();
		return WebManagerDao;
	}

	public WebSaleDataHelper getWebSaleDataHelper() {
		WebSaleDataHelper WebSaleDao=new WebSaleDataTxtHelper();
		return WebSaleDao;
	}
}