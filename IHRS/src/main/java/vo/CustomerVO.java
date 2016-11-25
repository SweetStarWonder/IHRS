package vo;

import java.util.ArrayList;

public class CustomerVO extends UserVO{
	
	private CreditVO credit;
	private ArrayList<ListVO> myLists;

	public CustomerVO(int id,String customerName,String phone,int creditValue,ArrayList<ListVO> myLists){
		
		super(id,customerName,phone);
		credit=new CreditVO(creditValue);
		this.setMyLists(myLists);
	}
	
	public int getCredit() {
		return credit.getCreditValue();
	}

	public void setCredit(int creditValue) {
		credit.setCreditValue(creditValue);
	}

	public ArrayList<ListVO> getMyLists() {
		return myLists;
	}

	public void setMyLists(ArrayList<ListVO> myLists) {
		this.myLists = myLists;
	}

}
