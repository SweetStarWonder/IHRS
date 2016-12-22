package presentation.hotelManager.room;

import java.io.IOException;

import org.controlsfx.control.GridCell;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presentation.hotelManager.TestHotelManager;
import vo.RoomVO;

public class RoomViewCell extends GridCell<RoomVO>{
	
	private TestHotelManager mainApp;
	
	public RoomViewCell(TestHotelManager mainApp) {
		super();
		this.mainApp = mainApp;
		//System.out.println("papap");
	}
	
	@Override 
	public void updateItem(RoomVO item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null) {
			FXMLLoader loader = new FXMLLoader();
			
			if (item!=null && item.getRoomNum()<0) {
				loader.setLocation(RoomViewCell.class.getResource("AddCell.fxml"));
				//AddRoomCellController controller = loader.getController();
				//controller.setMainApp(mainApp);
			} else {
				loader.setLocation(RoomViewCell.class.getResource("RoomCell.fxml"));
				//ConcreteCellController controller = loader.getController();
				//controller.setMainApp(mainApp);
			}
			
			AnchorPane anchorPane = null;
			try {
				anchorPane = (AnchorPane) loader.load();
				RoomCellController controller = loader.getController();
				controller.setMainApp(mainApp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			setGraphic(anchorPane);
			
		}
		 
	 }
}
