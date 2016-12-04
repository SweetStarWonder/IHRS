package businesslogic.creditbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.creditblservice.CreditBlService;
import data.dao.CreditChangeDao;
import po.CreditChangeMove;
import po.CreditChangePO;
import rmi.RemoteHelper;
import vo.CreditChangeVO;
import vo.CustomerVO;
import vo.ListVO;

public class CreditBlServiceImpl implements CreditBlService{
	
	private CustomerVO customerVO;
	
	private ArrayList<CreditChangePO> creditChanges;
	
	private CreditChangeDao creditChangeDao;
	
	private String timeNow;
	
	public CreditBlServiceImpl(CustomerVO customerVO,String timeNow){
		this.setCustomerVO(customerVO);
		this.timeNow=timeNow;
		creditChangeDao=RemoteHelper.getInstance().getCreditChangeDao();
		try {
			this.creditChanges=creditChangeDao.getCreditChange(customerVO.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public boolean deductRevokeCredit(ListVO listVO) {
		boolean add = false;
		int resultValue=getCreditResult();
		int price=listVO.getPrice();
		resultValue-=0.5*price;
		CreditChangePO creditChangePO=new CreditChangePO(customerVO.getId(), timeNow, listVO.getListId()+"",(int)-0.5*price, resultValue,CreditChangeMove.LISTREVOKE);
		creditChanges.add(creditChangePO);
		try {
			add = creditChangeDao.addCreditChange(creditChangePO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		ArrayList<CreditChangeVO> creditChangeVOs=customerVO.getCredits();
		creditChangeVOs.add(new CreditChangeVO(creditChangePO));
		customerVO.setCredits(creditChangeVOs);
		return add;
	}
	
	public boolean deductAbnormalCredit(ListVO listVO){
		boolean add = false;
		int resultValue=getCreditResult();
		int price=listVO.getPrice();
		resultValue-=price;
		CreditChangePO creditChangePO=new CreditChangePO(customerVO.getId(), timeNow, listVO.getListId()+"",(int)-price, resultValue,CreditChangeMove.LISTABNORMAL);
		creditChanges.add(creditChangePO);
		try {
			add = creditChangeDao.addCreditChange(creditChangePO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		ArrayList<CreditChangeVO> creditChangeVOs=customerVO.getCredits();
		creditChangeVOs.add(new CreditChangeVO(creditChangePO));
		customerVO.setCredits(creditChangeVOs);
		return add;
	}

	public boolean recoverCredit(ListVO listVO) {
		boolean recover = false;
		int resultValue=getCreditResult();
		int price=listVO.getPrice();
		resultValue+=0.5*price;
		CreditChangePO creditChangePO=new CreditChangePO(customerVO.getId(), timeNow, listVO.getListId()+"",(int)0.5*price, resultValue,CreditChangeMove.LISTEXECUTE);
		creditChanges.add(creditChangePO);
		try {
			recover = creditChangeDao.addCreditChange(creditChangePO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		ArrayList<CreditChangeVO> creditChangeVOs=customerVO.getCredits();
		creditChangeVOs.add(new CreditChangeVO(creditChangePO));
		customerVO.setCredits(creditChangeVOs);
		return recover;
	}

	public boolean rechargeCredit(int rechargeNum) {
		boolean recharge = false;
		int resultValue=getCreditResult();
		resultValue+=rechargeNum*100;
		CreditChangePO creditChangePO=new CreditChangePO(customerVO.getId(), timeNow,"Recharge",rechargeNum*100, resultValue,CreditChangeMove.RECHARGE);
		creditChanges.add(creditChangePO);
		try {
			recharge = creditChangeDao.addCreditChange(creditChangePO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		ArrayList<CreditChangeVO> creditChangeVOs=customerVO.getCredits();
		creditChangeVOs.add(new CreditChangeVO(creditChangePO));
		customerVO.setCredits(creditChangeVOs);
		return recharge;
	}

	public CustomerVO getCustomerVO() {
		return customerVO;
	}

	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}
	
	//得到最新的信用值
	private int getCreditResult(){
		String time="";
		int resultValue=0;
		for (CreditChangePO creditChangePO : creditChanges) {
			if(creditChangePO.getTime().compareToIgnoreCase(time)==1){
				time=creditChangePO.getTime();
				resultValue=creditChangePO.getResult();
			}
		}
		return resultValue;
	}

}
