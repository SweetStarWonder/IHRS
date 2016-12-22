package data.dataHelper;

public interface DataFactory {
	
	public  CreditChangeDataHelper getCreditChangeDataHelper();
	
	public CustomerDataHelper getCustomerDataHelper();
	
	public EnterpriseVipDataHelper getEnterpriseVipDataHelper();
	
	public EvaluateDataHelper getEvaluateDataHelper();
	
	public HotelDataHelper getHotelDataHelper();
	
	public HotelManagerDataHelper getHotelManagerDataHelper();
	
	public ListDataHelper getListDataHelper();
	
	public NormalVipDataHelper getNormalVipDataHelper();
	
	public RoomDataHelper getRoomDataHelper();
	
	public WebManagerDataHelper getWebManagerDataHelper();
	
	public WebSaleDataHelper getWebSaleDataHelper();
	
	public HotelPromotionDataHelper getHotelPromotionDataHelper();
	
	public NormalVipPromotionDataHelper getNormalVipPromotionDataHelper();
	
	public WebPromotionDataHelper getWebPromotionDataHelper();
	
	public AddressDataHelper getAddressDataHelper();
	
	public RankSystemDataHelper getRankSystemDataHelper();
	
	public PasswordDataHelper getPasswordDataHelper();
	
}
