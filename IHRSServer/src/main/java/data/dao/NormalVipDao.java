package data.dao;

import java.util.ArrayList;

import po.NormalVipPO;

public interface NormalVipDao {
	public ArrayList<NormalVipPO> getNormaVips(String birthday);
	
	public NormalVipPO getNormalVip(int userId);
	
	public boolean addNormalVip(NormalVipPO normalVipPO);
	
	public boolean updateNormalVip(NormalVipPO normalVipPO);
	
	public boolean deleteNormalVip(NormalVipPO normalVipPO);
}
