package presentation.webSale.promotion;

import controller.WebSaleController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utility.VerifyUtility;
import vo.promotionVO.NormalVipPromotionVO;
import vo.promotionVO.PromotionVO;
import vo.promotionVO.WebPromotionVO;

public class AddNormalVipPromotionDialogController {

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField discountTextFiel;

	@FXML
	private ComboBox<String> businessDistrictComboBox;

	@FXML
	private ComboBox<Integer> rankComboBox;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private WebSaleController controller;

	private WebPromotionListController upperController;

	public AddNormalVipPromotionDialogController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleConfirmButton() {
		String name = nameTextField.getText();
		String discount = discountTextFiel.getText();
		String businessDistrict = businessDistrictComboBox.getSelectionModel().getSelectedItem();
		if (name == null || discount == null || businessDistrict == null
				|| rankComboBox.getSelectionModel().getSelectedItem() == null || name.isEmpty() || discount.isEmpty()
				|| businessDistrict.isEmpty()) {
			VerifyUtility.showWarning("信息不完整", "请填写完整信息");
		} else if (!discount.matches("-?[0-9]+.*[0-9]*") || !discount.startsWith("0")) {
			VerifyUtility.showWarning("格式错误", "折扣额度应为小于1的小数");
		} else {
			PromotionVO promotionVO = new NormalVipPromotionVO(Double.valueOf(discount), name,
					rankComboBox.getSelectionModel().getSelectedItem(), businessDistrict);
			boolean add = controller.addPromotion(promotionVO);
			if (add) {
				upperController.addPromotion(promotionVO);
				dialogStage.close();
				VerifyUtility.showSuccessMessage("添加成功", "已添加折扣" + name);
			} else {
				VerifyUtility.showWarning("添加失败", "该折扣已存在");
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

	public void setController(WebSaleController controller) {
		this.controller = controller;
		ObservableList<String> businessDistrictList = FXCollections.observableArrayList();
		ObservableList<Integer> rankList = FXCollections.observableArrayList();
		for (int i = 0; i < 10; i++) {
			rankList.add(i + 1);
		}
		businessDistrictList.addAll(controller.getBusinessDistricts());
		rankComboBox.setItems(rankList);
		businessDistrictComboBox.setItems(businessDistrictList);
	}

	public void setUpperController(WebPromotionListController upperController) {
		this.upperController = upperController;
	}

}
