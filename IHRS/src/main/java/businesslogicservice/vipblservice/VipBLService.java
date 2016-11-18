package businesslogicservice.vipblservice;

import po.VipPO;
import po.RankPO;

public interface VipBLService {
	public boolean register(VipPO vip);
	public String rankCalculate(int n);
	public boolean rankEstablish(RankPO rank);
}
