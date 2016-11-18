package businesslogicservice.listblservice;

import vo.ListVO;

public interface ListBLService {
	public boolean revoke(String userid,int num);
	public boolean delay (String userid,int num);
	public boolean create(String userid,ListVO list);
	public boolean evaluate(int num,int rank,String comment);
}
