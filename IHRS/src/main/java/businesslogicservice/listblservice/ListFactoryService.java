package businesslogicservice.listblservice;

import java.util.ArrayList;

import po.ListPO;
import vo.ListVO;

public interface ListFactoryService {
	public ArrayList<ListPO> getListForm(String userid, int num);
	public ListVO getList(String userid);
}
