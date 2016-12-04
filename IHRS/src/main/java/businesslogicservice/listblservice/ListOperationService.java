package businesslogicservice.listblservice;

import vo.ListVO;

public interface ListOperationService {
	
	public ListVO revokeList(ListVO listVO,String timeNow);  //用户撤销未执行订单
	
	public ListVO updateCheckIn(ListVO listVO, String timeNow);  //酒店工作人员更新入住信息
	
	public ListVO updateCheckOut(ListVO listVO, String timeNow);  //酒店工作人员更新退房信息
	
	public ListVO executeList(ListVO listVO, String timeNow);  //酒店工作人员执行订单
	
	public ListVO setAbnormal(ListVO listVO, String timeNow);  //如果时间超过最晚订单执行时间后还未办理入住，系统自动将其置为异常订单
	
	public ListVO lateCheckIn(ListVO listVO, String timeNow);  //酒店工作人员手工登记执行情况（延迟入住），状态改为已执行，恢复扣除信用值
	
	public ListVO revokeAbnormalList(ListVO listVO,String revokeTime, boolean isHalf);
}
