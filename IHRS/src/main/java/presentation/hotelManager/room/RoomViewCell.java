package presentation.hotelManager.room;

import java.io.IOException;

import org.controlsfx.control.GridCell;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import vo.RoomVO;

public class RoomViewCell extends GridCell<RoomVO>{
	
	@Override 
	public void updateItem(RoomVO item, boolean empty) {
		super.updateItem(item, empty);
		FXMLLoader loader = new FXMLLoader();
		
		if (item!=null && item.getRoomNum()<0) {
			loader.setLocation(RoomViewCell.class.getResource("AddCell.fxml"));
		} else {
			loader.setLocation(RoomViewCell.class.getResource("RoomCell.fxml"));
		}
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 setGraphic(anchorPane);
		 
	 }
}
