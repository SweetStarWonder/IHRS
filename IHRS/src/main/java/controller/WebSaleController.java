package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import presentation.webSale.WebSaleView;
import presentation.webSale.list.ListViewController;
import presentation.webSale.promotion.WebPromotionListController;
import vo.CustomerVO;
import vo.ListVO;
import vo.WebSaleVO;
import vo.promotionVO.PromotionVO;

public interface WebSaleController {

	public void setController(LoginController controller);

	public void setWebSale(WebSaleVO webSaleVO);

	public void setView(WebSaleView view);

	public void showRankGrade();

	public void showPromotion();

	public void addTimePromotionPane(WebPromotionListController upperController);

	public void addNormalVipPromotionPane(WebPromotionListController upperController);

	public void showList();

	public void selectRevoke(ListVO listVO, ListViewController upperController);

	public void showRechargePane();

	public void inputMoneyDialog(CustomerVO customerVO);

	public void backView();

	public void signout();

	// 与逻辑层交互
	public HashMap<Integer, Integer> getRankValue() throws Exception;

	public void setRankValue(HashMap<Integer, Integer> rankValue);

	public ArrayList<PromotionVO> getPromotions();

	public boolean addPromotion(PromotionVO promotion);

	public boolean deletePromotion(PromotionVO promotion);

	public ArrayList<ListVO> getUnexecutedLists(String time);

	public ArrayList<ListVO> getAbnormalLists();

	public ArrayList<ListVO> getRevokedLists();

	public ListVO revokeList(ListVO listVO, String revokeTime, boolean isHalf);

	public CustomerVO getCustomer(int id);

	public boolean recharge(int money, CustomerVO customerVO, String timeNow);

	public void modifyPassword();

	public WebSaleVO getWebSale();

	public Set<String> getBusinessDistricts();

}
