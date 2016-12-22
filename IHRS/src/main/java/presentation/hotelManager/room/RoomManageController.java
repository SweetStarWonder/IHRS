package presentation.hotelManager.room;

import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import po.RoomStatus;
import presentation.hotelManager.TestHotelManager;
import vo.RoomVO;

public class RoomManageController {
	
	
	@FXML
	private AnchorPane roomAnchorPane;
	
	private ObservableList<RoomVO> roomList;
	
	private TestHotelManager mainApp;
	
	public RoomManageController() {
	}
	
	@FXML
	private void initialize() {
		roomList = FXCollections.observableArrayList();
		roomList.add(new RoomVO(-1, -1, -1, -1, RoomStatus.SINGLE));

		GridView<RoomVO> myGrid = new GridView<RoomVO>(roomList);
		myGrid.setCellFactory(new Callback<GridView<RoomVO>, GridCell<RoomVO>>() {
			
			public GridCell<RoomVO> call(GridView<RoomVO> param) {
				return new RoomViewCell(mainApp);
			}
			});
		for (int i = 0; i < 20; i++) {
			roomList.add(new RoomVO(0, 0, 0, 0, null));
		}
		myGrid.setCellHeight(80);
		myGrid.setCellWidth(80);
		myGrid.setHorizontalCellSpacing(5);
		myGrid.setPrefWidth(600);
		myGrid.setPrefHeight(475);
		
		roomAnchorPane.getChildren().add(myGrid);
	}
	
	public void setMainApp(TestHotelManager mainApp) {
		//System.out.println("biu");
		this.mainApp = mainApp;
	}
}
