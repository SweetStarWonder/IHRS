package utility;

import po.CreditChangeMove;

public class ConvertUtility {
	
	public static String creditChangeToStr(CreditChangeMove creditChangeMove) {
		if (creditChangeMove.equals(CreditChangeMove.LISTABNORMAL)) {
			return "异常订单";
		} else if (creditChangeMove.equals(CreditChangeMove.LISTEXECUTE)) {
			return "执行订单";
		} else if (creditChangeMove.equals(CreditChangeMove.RECHARGE)) {
			return "线下充值";			
		} else if (creditChangeMove.equals(CreditChangeMove.LISTREVOKE)) {
			return "撤销异常订单";
		} else {
			return "？？？";
		}
	}
}
