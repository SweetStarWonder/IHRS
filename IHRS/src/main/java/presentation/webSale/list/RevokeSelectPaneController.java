package presentation.webSale.list;

import controller.WebSaleController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import utility.TimeUtility;
import utility.VerifyUtility;
import vo.ListVO;

public class RevokeSelectPaneController {

	@FXML
	private ToggleButton halfToggleButton;

	@FXML
	private ToggleButton allToggleButton;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private ListViewController upperController;

	private ListVO listVO;

	private WebSaleController controller;

	public RevokeSelectPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleHalfToggleButton() {

	}

	@FXML
	private void handleAllToggleButton() {

	}

	@FXML
	private void handleConfirmButton() {
		boolean isHalf = halfToggleButton.isSelected();
		listVO = controller.revokeList(listVO, TimeUtility.getTimeStr(), isHalf);
		dialogStage.close();
		upperController.revoke(listVO);
		VerifyUtility.showSuccessMessage("撤销成功", "已撤销异常订单" + listVO.getListId());
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
	}

	public void setList(ListVO listVO) {
		this.listVO = listVO;
	}

	public void setUpperController(ListViewController upperController) {
		this.upperController = upperController;
	}

}
