package presentation.customer.information;

import java.io.IOException;

import org.controlsfx.control.GridCell;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import vo.HotelVO;

public class PersonalHotelCell extends GridCell<HotelVO>{
	public class HotelCell extends GridCell<HotelVO>{
		@Override 
		public void updateItem(HotelVO item, boolean empty) {
			super.updateItem(item, empty);
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HotelCell.class.getResource("PersonalHotelInformationCell.fxml"));
			AnchorPane anchorPane = null;
			try {
				anchorPane = (AnchorPane) loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			 setGraphic(anchorPane);
			 
		 }
	}

}
