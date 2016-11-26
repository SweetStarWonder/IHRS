package data.dao;

import java.util.ArrayList;

import po.ListPO;
import po.ListStatus;

public interface ListDao {
	public ListPO getList(int listId);
	
	public ArrayList<ListPO> getListsByUser(int userId);
	
	public ArrayList<ListPO> getListsByHotel(int hotelId);
	
	public ArrayList<ListPO> getListsByStatus(ListStatus listStatus);
	
	public boolean updateList(ListPO listPO);
	
	public boolean addList(ListPO listPO);
}
