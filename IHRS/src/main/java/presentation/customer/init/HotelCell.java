package presentation.customer.init;

import java.io.IOException;

import org.controlsfx.control.GridCell;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import vo.HotelVO;

public class HotelCell extends GridCell<HotelVO>{
	@Override 
	public void updateItem(HotelVO item, boolean empty) {
		super.updateItem(item, empty);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelCell.class.getResource("HotelInformationCell.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //Rating rating = new Rating();
		 //anchorPane.getChildren().add(rating);
		// anchorPane.setLeftAnchor(rating, (double) 12);
		 //anchorPane.setTopAnchor(rating, 62.0);
		 //anchorPane.setRightAnchor(rating, 73.0);
		 
		 setGraphic(anchorPane);
		 
	 }
}
