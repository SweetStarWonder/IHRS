package presentation.hotelManager.room;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import po.RoomStatus;
import utility.VerifyUtility;
import vo.RoomVO;

public class ConcreteCellController extends RoomCellController {

	@FXML
	private Label roomNum;

	@FXML
	private Label roomStatus;

	@FXML
	private Label price;

	private RoomVO roomVO;

	public ConcreteCellController() {
		super();
	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleClick() {
		if (roomVO.getListId() == 0) {
			boolean check = mainApp.checkIn(roomVO);
			if (check) {
				roomNum.setText(roomNum.getText() + "已入住");
				VerifyUtility.showSuccessMessage("入住成功", "已为房间" + roomVO.getRoomNum() + "登记入住");
			} else {
				VerifyUtility.showWarning("入住失败", "请检查网络连接");
			}
		} else {
			boolean check = mainApp.checkOut(roomVO);
			if (check) {
				roomNum.setText(roomVO.getRoomNum() + "");
				VerifyUtility.showSuccessMessage("退房成功", "已为房间" + roomVO.getRoomNum() + "登记退房");
			} else {
				VerifyUtility.showWarning("退房失败", "请检查网络连接");
			}
		}

	}

	public void setRoom(RoomVO roomVO) {
		this.roomVO = roomVO;
		roomNum.setText(roomVO.getRoomNum() + "");
		price.setText(roomVO.getPrice() + "元");
		String status = "";
		if (roomVO.getStatus().equals(RoomStatus.SINGLE)) {
			status = "单人间";
		} else if (roomVO.getStatus().equals(RoomStatus.DOUBLE)) {
			status = "双人间";
		} else if (roomVO.getStatus().equals(RoomStatus.TRIPLE)) {
			status = "三人间";
		}
		roomStatus.setText(status);
		if (roomVO.getListId() != 0) {
			roomNum.setText(roomNum.getText() + "已入住");
		}
	}

}
