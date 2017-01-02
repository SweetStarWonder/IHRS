package presentation.customer.information;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import po.RoomStatus;
import vo.ListVO;
import vo.RoomVO;

public class ListCellController {
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

	private ListVO listVO;

	public ListCellController() {

	}

	@FXML
	private void initialize() {

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
}
