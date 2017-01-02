package controller.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import businesslogic.creditbl.CreditBlServiceImpl;
import businesslogic.listbl.GetListsServiceImpl;
import businesslogic.listbl.ListOperationServiceImpl;
import businesslogic.loginbl.WebSaleLoginBlServiceImpl;
import businesslogic.promotionbl.NormalVipPromotionBlServiceImpl;
import businesslogic.promotionbl.WebPromotionBlServiceImpl;
import businesslogic.userbl.FindUserServiceImpl;
import businesslogicservice.creditblservice.CreditBlService;
import businesslogicservice.listblservice.GetListsService;
import businesslogicservice.listblservice.ListOperationService;
import businesslogicservice.loginblservice.WebSaleLoginBlService;
import businesslogicservice.promotionblservice.NormalVipPromotionBlService;
import businesslogicservice.promotionblservice.WebPromotionBlService;
import businesslogicservice.userblservice.FindUserService;
import controller.LoginController;
import controller.WebSaleController;
import presentation.webSale.WebSaleView;
import presentation.webSale.list.ListViewController;
import presentation.webSale.promotion.WebPromotionListController;
import rmi.RemoteHelper;
import utility.VerifyUtility;
import vo.CustomerVO;
import vo.ListVO;
import vo.WebSaleVO;
import vo.promotionVO.NormalVipPromotionVO;
import vo.promotionVO.PromotionVO;
import vo.promotionVO.WebPromotionVO;

public class WebSaleControllerImpl implements WebSaleController {

	private WebSaleView view;

	private WebSaleVO self;

	private LoginController controller;

	private GetListsService getListsService;

	private ListOperationService listOperationService;

	private WebSaleLoginBlService loginService;

	private WebPromotionBlService webPromotionService;

	private NormalVipPromotionBlService normalVipPromotionService;

	private ArrayList<ListVO> revokedLists;

	private CustomerVO findCustomer;

	public WebSaleControllerImpl() {
		this.getListsService = new GetListsServiceImpl();
		this.listOperationService = new ListOperationServiceImpl();
		this.loginService = new WebSaleLoginBlServiceImpl();
		this.webPromotionService = new WebPromotionBlServiceImpl();
		this.normalVipPromotionService = new NormalVipPromotionBlServiceImpl();
		revokedLists = new ArrayList<ListVO>();
	}

	@Override
	public void setController(LoginController controller) {
		this.controller = controller;
	}

	@Override
	public void setWebSale(WebSaleVO webSaleVO) {
		this.self = webSaleVO;
	}

	@Override
	public void setView(WebSaleView view) {
		this.view = view;
	}

	@Override
	public void showRankGrade() {
		view.showRankGrade();
	}

	@Override
	public void showPromotion() {
		view.showPromotion();
	}

	@Override
	public void addTimePromotionPane(WebPromotionListController upperController) {
		view.addTimePromotionPane(upperController);
	}

	@Override
	public void addNormalVipPromotionPane(WebPromotionListController upperController) {
		view.addNormalVipPromotionPane(upperController);
	}

	@Override
	public void showList() {
		view.showList();
	}

	@Override
	public void selectRevoke(ListVO listVO, ListViewController upperController) {
		view.selectRevoke(listVO, upperController);
	}

	@Override
	public void showRechargePane() {
		view.showRechargePane();
	}

	@Override
	public void inputMoneyDialog(CustomerVO customerVO) {
		view.inputMoneyDialog(customerVO);
	}

	@Override
	public void backView() {
		view.backView();
	}

	@Override
	public void signout() {
		controller.signOut();
	}

	@Override
	public HashMap<Integer, Integer> getRankValue() throws Exception {
		return RemoteHelper.getInstance().getRankSystemDao().getRanks();
	}

	@Override
	public void setRankValue(HashMap<Integer, Integer> rankValue) {
		try {
			RemoteHelper.getInstance().getRankSystemDao().updateRank(rankValue);
		} catch (Exception e) {
			VerifyUtility.showWarning("修改失败", "未连接到服务器");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<PromotionVO> getPromotions() {
		ArrayList<WebPromotionVO> webPromotionVOs = webPromotionService.getWebPromotions();
		ArrayList<NormalVipPromotionVO> normalVipPromotionVOs = new ArrayList<NormalVipPromotionVO>();
		for (int i = 0; i < 10; i++) {
			normalVipPromotionVOs.addAll(normalVipPromotionService.getNormalVipPromotions(i + 1));
		}
		ArrayList<PromotionVO> promotionVOs = new ArrayList<PromotionVO>();
		for (PromotionVO promotionVO : webPromotionVOs) {
			promotionVOs.add(promotionVO);
		}
		for (PromotionVO promotionVO : normalVipPromotionVOs) {
			promotionVOs.add(promotionVO);
		}
		return promotionVOs;
	}

	@Override
	public boolean addPromotion(PromotionVO promotion) {
		if (promotion instanceof NormalVipPromotionVO) {
			return normalVipPromotionService.addNormalVipPromotion((NormalVipPromotionVO) promotion);
		} else if (promotion instanceof WebPromotionVO) {
			return webPromotionService.addWebPromotion((WebPromotionVO) promotion);
		} else {
			return false;
		}
	}

	@Override
	public boolean deletePromotion(PromotionVO promotion) {
		if (promotion instanceof NormalVipPromotionVO) {
			return normalVipPromotionService.deleteNormalVipPromotion((NormalVipPromotionVO) promotion);
		} else if (promotion instanceof WebPromotionVO) {
			return webPromotionService.deleteWebPromotion((WebPromotionVO) promotion);
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<ListVO> getUnexecutedLists(String time) {
		HashMap<Integer, ListVO> listMap = getListsService.getDailyUnexecutedLists(time);
		ArrayList<ListVO> unexecutedLists = new ArrayList<ListVO>();
		unexecutedLists.addAll(listMap.values());
		return unexecutedLists;
	}

	@Override
	public ArrayList<ListVO> getAbnormalLists() {
		HashMap<Integer, ListVO> listMap = getListsService.getAbnormalLists();
		ArrayList<ListVO> abnormalLists = new ArrayList<ListVO>();
		abnormalLists.addAll(listMap.values());
		return abnormalLists;
	}

	@Override
	public ArrayList<ListVO> getRevokedLists() {
		return revokedLists;
	}

	@Override
	public ListVO revokeList(ListVO listVO, String revokeTime, boolean isHalf) {
		listVO = listOperationService.revokeAbnormalList(listVO, revokeTime, isHalf);
		revokedLists.add(listVO);
		return listVO;
	}

	@Override
	public CustomerVO getCustomer(int id) {
		FindUserService findUserService = new FindUserServiceImpl();
		findCustomer = findUserService.getCustomer(id);
		return findCustomer;
	}

	@Override
	public boolean recharge(int money, CustomerVO customerVO, String timeNow) {
		CreditBlService creditBlService = new CreditBlServiceImpl(findCustomer, timeNow);
		return creditBlService.rechargeCredit(money);
	}

	@Override
	public void modifyPassword() {
		// TODO Auto-generated method stub

	}

	@Override
	public WebSaleVO getWebSale() {
		return self;
	}

	@Override
	public Set<String> getBusinessDistricts() {
		try {
			return RemoteHelper.getInstance().getAddressDao().getAddresses().keySet();
		} catch (RemoteException e) {
			VerifyUtility.showWarning("连接出错", "请检查网路");
			return null;
		}
	}
}
