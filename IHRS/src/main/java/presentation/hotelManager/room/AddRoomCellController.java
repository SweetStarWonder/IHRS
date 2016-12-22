package presentation.hotelManager.room;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AddRoomCellController extends RoomCellController {
	
	@FXML
	private AnchorPane pane;
	
	
	public AddRoomCellController() {
		super();
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML 
	private void handleClick() {
		mainApp.addRoomPane();
	}
	
}
