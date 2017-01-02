package presentation.hotelManager.room;

import java.util.ArrayList;

import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;

import controller.HotelManagerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import po.RoomStatus;
import vo.RoomVO;

public class RoomManageController {

	@FXML
	private AnchorPane roomAnchorPane;

	private ObservableList<RoomVO> roomList;

	private HotelManagerController mainApp;

	public RoomManageController() {
	}

	@FXML
	private void initialize() {
		roomList = FXCollections.observableArrayList();

	}

	public void addRooms(ArrayList<RoomVO> roomVOs) {
		roomList.addAll(roomVOs);
	}

	public void setMainApp(HotelManagerController mainApp) {
		// System.out.println("biu");
		this.mainApp = mainApp;

		roomList.add(new RoomVO(-1, -1, -1, -1, RoomStatus.SINGLE));
		roomList.addAll(mainApp.getRooms());

		GridView<RoomVO> myGrid = new GridView<RoomVO>(roomList);
		myGrid.setCellFactory(new Callback<GridView<RoomVO>, GridCell<RoomVO>>() {

			public GridCell<RoomVO> call(GridView<RoomVO> param) {
				return new RoomViewCell(mainApp, RoomManageController.this);
			}
		});

		myGrid.setCellHeight(80);
		myGrid.setCellWidth(80);
		myGrid.setHorizontalCellSpacing(5);
		myGrid.setPrefWidth(600);
		myGrid.setPrefHeight(475);

		roomAnchorPane.getChildren().add(myGrid);

	}
}
