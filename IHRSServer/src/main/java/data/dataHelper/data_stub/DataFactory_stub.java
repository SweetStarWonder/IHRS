package data.dataHelper.data_stub;

import data.dataHelper.impl.*;
import data.dataHelper.AddressDataHelper;
import data.dataHelper.CreditChangeDataHelper;
import data.dataHelper.CustomerDataHelper;
import data.dataHelper.DataFactory;
import data.dataHelper.EnterpriseVipDataHelper;
import data.dataHelper.EvaluateDataHelper;
import data.dataHelper.HotelDataHelper;
import data.dataHelper.HotelManagerDataHelper;
import data.dataHelper.HotelPromotionDataHelper;
import data.dataHelper.ListDataHelper;
import data.dataHelper.NormalVipDataHelper;
import data.dataHelper.NormalVipPromotionDataHelper;
import data.dataHelper.PasswordDataHelper;
import data.dataHelper.RankSystemDataHelper;
import data.dataHelper.RoomDataHelper;
import data.dataHelper.RoomInListDataHelper;
import data.dataHelper.WebManagerDataHelper;
import data.dataHelper.WebPromotionDataHelper;
import data.dataHelper.WebSaleDataHelper;

public class DataFactory_stub implements DataFactory{

	@Override
	public CreditChangeDataHelper getCreditChangeDataHelper() {
		// TODO Auto-generated method stub
		return new CreditChangeDataTxtHelper();
	}

	@Override
	public CustomerDataHelper getCustomerDataHelper() {
		// TODO Auto-generated method stub
		return new CustomerDataTxtHelper();
	}

	@Override
	public EnterpriseVipDataHelper getEnterpriseVipDataHelper() {
		// TODO Auto-generated method stub
		return new EnterpriseVipDataTxtHelper();
	}

	@Override
	public EvaluateDataHelper getEvaluateDataHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelDataHelper getHotelDataHelper() {
		// TODO Auto-generated method stub
		return new HotelDataTxtHelper();
	}

	@Override
	public HotelManagerDataHelper getHotelManagerDataHelper() {
		// TODO Auto-generated method stub
		return new HotelManagerDataTxtHelper();
	}

	@Override
	public ListDataHelper getListDataHelper() {
		// TODO Auto-generated method stub
		return new ListDataTxtHelper();
	}

	@Override
	public NormalVipDataHelper getNormalVipDataHelper() {
		// TODO Auto-generated method stub
		return new NormalVipDataTxtHelper();
	}

	@Override
	public RoomDataHelper getRoomDataHelper() {
		// TODO Auto-generated method stub
		return new RoomDataTxtHelper();
	}

	@Override
	public WebManagerDataHelper getWebManagerDataHelper() {
		// TODO Auto-generated method stub
		return new WebManagerDataTxtHelper();
	}

	@Override
	public WebSaleDataHelper getWebSaleDataHelper() {
		// TODO Auto-generated method stub
		return new WebSaleDataTxtHelper();
	}

	@Override
	public HotelPromotionDataHelper getHotelPromotionDataHelper() {
		// TODO Auto-generated method stub
		return new HotelPromotionDataTxtHelper();
	}

	@Override
	public NormalVipPromotionDataHelper getNormalVipPromotionDataHelper() {
		// TODO Auto-generated method stub
		return new NormalVipPromotionDataTxtHelper();
	}

	@Override
	public WebPromotionDataHelper getWebPromotionDataHelper() {
		// TODO Auto-generated method stub
		return new WebPromotionDataTxtHelper();
	}

	@Override
	public AddressDataHelper getAddressDataHelper() {
		// TODO Auto-generated method stub
		return new AddressDataTxtHelper();
	}

	@Override
	public RankSystemDataHelper getRankSystemDataHelper() {
		// TODO Auto-generated method stub
		return new RankSystemDataTxtHelper();
	}

	@Override
	public PasswordDataHelper getPasswordDataHelper() {
		// TODO Auto-generated method stub
		return new PasswordDataTxtHelper();
	}

	@Override
	public RoomInListDataHelper getRoomInListDataHelper() {
		// TODO Auto-generated method stub
		return new RoomInListDataTxtHelper();
	}

}
