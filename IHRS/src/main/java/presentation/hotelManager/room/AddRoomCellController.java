package presentation.hotelManager.room;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AddRoomCellController extends RoomCellController {

	@FXML
	private AnchorPane pane;

	private RoomManageController upperController;

	public AddRoomCellController() {
		super();
	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleClick() {
		mainApp.addRoomPane(upperController);
	}

	public void setUpperController(RoomManageController upperController) {
		this.upperController = upperController;
	}

}
