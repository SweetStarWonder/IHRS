package presentation.customer.information;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import po.RoomStatus;
import utility.TimeUtility;
import utility.VerifyUtility;
import vo.ListVO;
import vo.RoomVO;

public class UnexecutedListCellController {
	@FXML
	private Label listIdLabel;

	@FXML
	private Label hotelNameLabel;

	@FXML
	private Label beginTimeLabel;

	@FXML
	private Label endTimeLabel;

	@FXML
	private Label lastExcecutedTimeLabel;

	@FXML
	private Label singleNumLabel;

	@FXML
	private Label doubleNumLabel;

	@FXML
	private Label tripleNumLabel;

	@FXML
	private Label peopleNumLabel;

	@FXML
	private Label priceLabel;

	@FXML
	private Label haveChildLabel;
	
	@FXML
	private Button revokeButton;
	
	private CustomerController controller;
	
	private PersonalListViewController upperController;

	private ListVO listVO;

	public UnexecutedListCellController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleRevokeButton() {
		listVO = controller.revokeList(listVO, TimeUtility.getTimeStr());
		upperController.revoke(listVO);
		VerifyUtility.showSuccessMessage("订单撤销成功",
				"已撤销订单" + listVO.getListId() + "（有可能扣除信用）");
	
	}
	
	public void setList(ListVO listVO) {
		this.listVO = listVO;
		listIdLabel.setText(listVO.getListId() + "");
		hotelNameLabel.setText(listVO.getHotelId() + "");
		beginTimeLabel.setText(listVO.getEntryTime());
		endTimeLabel.setText(listVO.getLastTime());
		lastExcecutedTimeLabel.setText(listVO.getLastListExecutedTime());
		priceLabel.setText(listVO.getPrice() + "元");
		haveChildLabel.setText(listVO.isIfHaveChild() ? "有" : "无");
		int singleRoom = 0;
		int doubleRoom = 0;
		int tripleRoom = 0;
		int peopleNum = 0;
		for (RoomVO roomVO : listVO.getRooms()) {
			if (roomVO.getStatus().equals(RoomStatus.SINGLE)) {
				singleRoom++;
				peopleNum++;
			} else if (roomVO.getStatus().equals(RoomStatus.DOUBLE)) {
				doubleRoom++;
				peopleNum += 2;
			} else if (roomVO.getStatus().equals(RoomStatus.TRIPLE)) {
				tripleRoom++;
				peopleNum += 3;
			}
		}
		singleNumLabel.setText(singleRoom + "" + "间");
		doubleNumLabel.setText(doubleRoom + "" + "间");
		tripleNumLabel.setText(tripleRoom + "" + "间");
		peopleNumLabel.setText(peopleNum + "");
	}
	
	public void setController(CustomerController controller) {
		this.controller = controller;
	}
	
	public void setUpperController(PersonalListViewController upperController) {
		this.upperController = upperController;
	}
	
}
