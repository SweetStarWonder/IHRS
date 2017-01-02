package presentation.hotelManager.promotion;

import controller.HotelManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import po.promotionPO.HotelPromotionType;
import utility.VerifyUtility;
import vo.promotionVO.HotelPromotionVO;

public class AddNormalPromotionDialogController {

	@FXML
	private Label typeLabel;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField discountTextFiel;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private HotelManagerController controller;

	private HotelPromotionListController upperController;

	private HotelPromotionType type;

	public AddNormalPromotionDialogController() {

	}

	@FXML
	private void initialize() {
	}

	@FXML
	private void handleConfirmButton() {
		String name = nameTextField.getText();
		String discount = discountTextFiel.getText();
		if (name == null || discount == null || name.isEmpty() || discount.isEmpty()) {
			VerifyUtility.showWarning("未填写完整信息", "请填写完整折扣信息");
		} else if (!discount.matches("-?[0-9]+.*[0-9]*") || !discount.startsWith("0")) {
			VerifyUtility.showWarning("格式错误", "折扣额度应为小于1的小数");
		} else {
			HotelPromotionVO promotionVO = new HotelPromotionVO(Double.valueOf(discount), name,
					controller.getSelf().getHotelId(), type, "0", "0");
			boolean add = controller.addPromotion(promotionVO);
			if (add) {
				upperController.addPromotioin(promotionVO);
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

	public void setController(HotelManagerController controller) {
		this.controller = controller;
	}

	public void setUpperController(HotelPromotionListController upperController) {
		this.upperController = upperController;
	}

	public void setType(char type) {
		if (type == 'B') {
			typeLabel.setText("生日特惠折扣");
			this.type = HotelPromotionType.BIRTHDAY;
		} else if (type == 'E') {
			typeLabel.setText("合作企业会员折扣");
			this.type = HotelPromotionType.ENTERPRISE;
		} else if (type == 'T') {
			typeLabel.setText("三间及以上优惠");
			this.type = HotelPromotionType.THREEMORE;
		}
	}

}
