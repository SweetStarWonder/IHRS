package controller.impl;

import businesslogic.loginbl.CustomerLoginBlServiceImpl;
import businesslogic.loginbl.EveryoneLoginBlServiceImpl;
import businesslogicservice.loginblservice.CustomerLoginBlService;
import businesslogicservice.loginblservice.EveryoneLoginBlService;
import controller.LoginController;
import controller.WebManagerController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import presentation.login.LoginView;
import presentation.webManager.WebManagerView;
import utility.VerifyUtility;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.HotelManagerVO;
import vo.NormalVipVO;
import vo.UserVO;
import vo.WebManagerVO;
import vo.WebSaleVO;

public class LoginControllerImpl implements LoginController{

	private Stage primaryStage;
	
	private LoginView view;
	
	public LoginControllerImpl(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void login(int userId, String userName, String password) {
		EveryoneLoginBlService loginBlService = new EveryoneLoginBlServiceImpl();
		UserVO userVO;
		userVO = loginBlService.login(userId, userName, password);
		if (userVO == null) {
			VerifyUtility.showWarning("验证错误", "请输入正确的用户名和密码");
		} else if (userVO instanceof CustomerVO) {
			System.out.println("customer!");
		} else if (userVO instanceof NormalVipVO) {
			System.out.println("normalVip!");
		} else if (userVO instanceof EnterpriseVipVO) {
			System.out.println("enterpriseVip!");
		} else if (userVO instanceof HotelManagerVO) {
			System.out.println("hotelManager!");
		} else if (userVO instanceof WebSaleVO) {
			System.out.println("webSale!");
		} else if (userVO instanceof WebManagerVO) {
			System.out.println("webManager!");
			primaryStage.close();
			WebManagerController controller = new WebManagerControllerImpl();
			WebManagerView view = new WebManagerView(controller);
			controller.setWebManager((WebManagerVO) userVO);
			controller.setView(view);
			controller.setController(this);
			view.start(primaryStage);
			
			VerifyUtility.showSuccessMessage(userVO.getUserName()+" 登录成功", "您以网站管理人员的身份登录");
		}
	}
	
	
	
	@Override
	public boolean register(String customerName, String password, String phone) {
		CustomerLoginBlService loginBlService = new CustomerLoginBlServiceImpl();
		boolean register = loginBlService.register(customerName, password, phone);
		return register;
	}
	
	
	@Override
	public void setView(LoginView view) {
		this.view = view;
	}

	@Override
	public void signOut() {
		primaryStage.close();
		try {
			view.start(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	


	
}
