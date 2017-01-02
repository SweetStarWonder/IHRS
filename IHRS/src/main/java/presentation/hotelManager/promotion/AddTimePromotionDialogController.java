package presentation.hotelManager.promotion;

import controller.HotelManagerController;
import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import po.promotionPO.HotelPromotionType;
import utility.VerifyUtility;
import vo.promotionVO.HotelPromotionVO;
import vo.promotionVO.PromotionVO;
import vo.promotionVO.WebPromotionVO;

public class AddTimePromotionDialogController {

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField discountTextFiel;

	@FXML
	private DatePicker beginTimeDatePicker;

	@FXML
	private DatePicker endTimeDatePicker;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private HotelManagerController controller;

	private HotelPromotionListController upperController;

	public AddTimePromotionDialogController() {

	}

	@FXML
	private void initialize() {
	}

	@FXML
	private void handleConfirmButton() {
		String name = nameTextField.getText();
		String discount = discountTextFiel.getText();
		String beginTime = beginTimeDatePicker.getValue().toString();
		String endTime = endTimeDatePicker.getValue().toString();
		if (name == null || discount == null || beginTime == null || endTime == null || name.isEmpty()
				|| discount.isEmpty() || beginTime.isEmpty() || endTime.isEmpty()) {
			VerifyUtility.showWarning("未填写完整信息", "请填写完整折扣信息");
		} else if (beginTime.compareTo(endTime) >= 0) {
			VerifyUtility.showWarning("日期错误", "结束日期应该在开始日期之后");
		} else if (!discount.matches("-?[0-9]+.*[0-9]*") || !discount.startsWith("0")) {
			VerifyUtility.showWarning("格式错误", "折扣额度应为小于1的小数");
		} else {
			HotelPromotionVO promotionVO = new HotelPromotionVO(Double.valueOf(discount), name,
					controller.getSelf().getHotelId(), HotelPromotionType.DOUBLE11,
					beginTime.substring(0, 4) + "/" + beginTime.substring(5, 7) + "/" + beginTime.substring(8),
					endTime.substring(0, 4) + "/" + endTime.substring(5, 7) + "/" + endTime.substring(8));
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
}
