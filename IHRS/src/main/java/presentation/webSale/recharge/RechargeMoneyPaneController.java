package presentation.webSale.recharge;

import controller.WebSaleController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utility.TimeUtility;
import utility.VerifyUtility;
import vo.CustomerVO;

public class RechargeMoneyPaneController {

	@FXML
	private Label userIdLabel;

	@FXML
	private TextField moneyTextField;

	@FXML
	private Label creditIncreaseLabel;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private CustomerVO customerVO;

	private WebSaleController controller;

	public RechargeMoneyPaneController() {

	}

	@FXML
	private void initialize() {
		creditIncreaseLabel.setText("");
		moneyTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			calculateCredit(newValue);
		});
	}

	private void calculateCredit(String money) {
		if (!money.isEmpty() && VerifyUtility.isInteger(money)) {
			int num = Integer.valueOf(money);
			if (num > 0) {
				creditIncreaseLabel.setText("+" + num * 100 + "");
			} else {
				creditIncreaseLabel.setText("");
			}
		} else {
			creditIncreaseLabel.setText("");
		}
	}

	@FXML
	private void handleConfirmButton() {
		String credit = creditIncreaseLabel.getText();
		if (credit == null || credit.isEmpty()) {
			VerifyUtility.showWarning("输入不正确", "请正确输入充值金额");
		} else {
			boolean recharge = controller.recharge(Integer.valueOf(credit) / 100, customerVO, TimeUtility.getTimeStr());
			if (recharge) {
				dialogStage.close();
				VerifyUtility.showSuccessMessage("充值成功", "成功为用户" + customerVO.getId() + "充值" + credit + "信用");
			} else {
				VerifyUtility.showWarning("充值失败", "请检查网络连接");
			}
		}
	}

	@FXML
	private void handleCancelButton() {
		dialogStage.close();
	}

	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setCustomer(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}

	public void setController(WebSaleController controller) {
		this.controller = controller;
	}
}
