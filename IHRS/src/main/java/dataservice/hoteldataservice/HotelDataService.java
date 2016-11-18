package dataservice.hoteldataservice;

import po.HotelPO;
import dataservice.datafactoryservice.DatabaseService;

public interface HotelDataService extends DatabaseService {
	public HotelPO find(String hotel);
	public void insert(HotelPO po);
	public void update(HotelPO po);
	public void init();
	public void finish();
}
