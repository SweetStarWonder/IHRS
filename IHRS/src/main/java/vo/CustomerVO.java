package vo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.dao.CreditChangeDao;
import data.dao.ListDao;
import po.CreditChangePO;
import po.CustomerPO;
import po.ListPO;
import rmi.RemoteHelper;

/**
 * id            客户编号
 * customerName  客户名
 * phone         客户手机号
 * credits       客户所有信用变化记录
 * myLists       客户所有订单
 */
public class CustomerVO extends UserVO{
	
	private ArrayList<CreditChangeVO> credits;
	
	private HashMap<Integer, ListVO> myLists;
	
	public CustomerVO(int id, String userName, String phone) {
		super(id, userName, phone);
	}
	
	public CustomerVO(CustomerPO customerPO){
		super(customerPO.getId(), customerPO.getUserName(), customerPO.getPhone());
		CreditChangeDao creditChangeDao=RemoteHelper.getInstance().getCreditChangeDao();
		try {
			ArrayList<CreditChangePO> creditChangePOs = creditChangeDao.getCreditChange(customerPO.getId());
			this.credits=new ArrayList<CreditChangeVO>();
			for (CreditChangePO creditChangePO : creditChangePOs) {
				this.credits.add(new CreditChangeVO(creditChangePO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ListDao listDao=RemoteHelper.getInstance().getListDao();
		try {
			HashMap<Integer, ListPO> listPOs=listDao.getListsByUser(customerPO.getId());
			this.myLists = new HashMap<Integer, ListVO>();
			Iterator<Integer> iterator = listPOs.keySet().iterator();
			while (iterator.hasNext()) {
				Integer id = (Integer) iterator.next();
				myLists.put(id, new ListVO(listPOs.get(id)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CreditChangeVO> getCredits() {
		return credits;
	}

	public void setCredits(ArrayList<CreditChangeVO> credit) {
		this.credits = credit;
	}

	public HashMap<Integer, ListVO> getMyLists() {
		return myLists;
	}

	public void setMyLists(HashMap<Integer, ListVO> myLists) {
		this.myLists = myLists;
	}
	
	
}
