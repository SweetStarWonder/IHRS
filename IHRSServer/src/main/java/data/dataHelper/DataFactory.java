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
	
	public PromotionDataHelper getPromotionDataHelper();
	
	public RoomDataHelper getRoomDataHelper();
	
	public WebManagerDataHelper getWebManagerDataHelper();
	
	public WebSaleDataHelper getWebSaleDataHelper();
	
}
