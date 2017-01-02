package presentation.hotelManager.room;

import java.io.IOException;

import org.controlsfx.control.GridCell;

import controller.HotelManagerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import vo.RoomVO;

public class RoomViewCell extends GridCell<RoomVO> {

	private HotelManagerController mainApp;

	private RoomManageController upperController;

	public RoomViewCell(HotelManagerController mainApp, RoomManageController upperController) {
		super();
		this.mainApp = mainApp;
		this.upperController = upperController;
		// System.out.println("papap");
	}

	@Override
	public void updateItem(RoomVO item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null) {
			AnchorPane anchorPane = null;
			FXMLLoader loader = new FXMLLoader();

			try {
				if (item.getRoomNum() < 0) {
					loader.setLocation(RoomViewCell.class.getResource("AddCell.fxml"));
					anchorPane = (AnchorPane) loader.load();
					AddRoomCellController controller = loader.getController();
					controller.setMainApp(mainApp);
					controller.setUpperController(upperController);
				} else {
					loader.setLocation(RoomViewCell.class.getResource("RoomCell.fxml"));
					anchorPane = (AnchorPane) loader.load();
					ConcreteCellController controller = loader.getController();
					controller.setMainApp(mainApp);
					controller.setRoom(item);
				}
				RoomCellController controller = loader.getController();
				controller.setMainApp(mainApp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			setGraphic(anchorPane);

		}

	}
}
