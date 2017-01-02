package presentation.webSale.rank;

import java.util.ArrayList;
import java.util.HashMap;

import controller.WebSaleController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import utility.VerifyUtility;

public class RankPaneController {

	@FXML
	private TextField oneTextField;

	@FXML
	private TextField twoTextField;

	@FXML
	private TextField threeTextField;

	@FXML
	private TextField fourTextField;

	@FXML
	private TextField fiveTextField;

	@FXML
	private TextField sixTextField;

	@FXML
	private TextField sevenTextField;

	@FXML
	private TextField eightTextField;

	@FXML
	private TextField nineTextField;

	@FXML
	private TextField tenTextField;

	@FXML
	private Button resetButton;

	@FXML
	private Button confirmButton;

	private WebSaleController controller;

	private HashMap<Integer, Integer> rankMap;

	private ArrayList<TextField> rankTextFields;

	public RankPaneController() {
	}

	private void initialize() {
		rankTextFields = new ArrayList<TextField>();
		rankTextFields.add(oneTextField);
		rankTextFields.add(twoTextField);
		rankTextFields.add(threeTextField);
		rankTextFields.add(fourTextField);
		rankTextFields.add(fiveTextField);
		rankTextFields.add(sixTextField);
		rankTextFields.add(sevenTextField);
		rankTextFields.add(eightTextField);
		rankTextFields.add(nineTextField);
		rankTextFields.add(tenTextField);
		for (int i = 0; i < 10; i++) {
			if (rankMap.containsKey(i + 1)) {
				rankTextFields.get(i).setText(rankMap.get(i + 1) + "");
			}
		}
	}

	@FXML
	private void handleResetButton() {
		initialize();
	}

	@FXML
	private void handleConfirmButton() {
		ArrayList<Integer> credits = new ArrayList<Integer>();
		int temp = 0;
		for (int i = 0; i < 10; i++) {
			String creditStr = rankTextFields.get(i).getText();
			if (creditStr == null || creditStr.isEmpty()) {
				VerifyUtility.showWarning("未填写完整", "请完整填写等级制度");
				break;
			} else if (!VerifyUtility.isInteger(creditStr)) {
				VerifyUtility.showWarning("内容错误", creditStr + "不是整数");
				break;
			} else {
				int credit = Integer.valueOf(creditStr);
				if (credit <= temp) {
					VerifyUtility.showWarning("内容错误", "等级" + (i + 1) + "的最低积分必须比等级" + i + "的积分大");
					break;
				} else {
					credits.add(credit);
					temp = credit;
				}
			}
		}

		if (credits.size() == 10) {
			for (int i = 0; i < 10; i++) {
				rankMap.put(i + 1, credits.get(i));
			}
			controller.setRankValue(rankMap);
			VerifyUtility.showSuccessMessage("修改成功", "成功修改信用等级制度");
			controller.backView();
		}
	}

	public void setController(WebSaleController controller) throws Exception {
		this.controller = controller;
		rankMap = controller.getRankValue();
		initialize();
	}

}
