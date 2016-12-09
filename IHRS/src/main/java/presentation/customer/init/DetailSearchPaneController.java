package presentation.customer.init;

import org.controlsfx.control.Rating;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import po.RoomStatus;

public class DetailSearchPaneController {
	
	
	@FXML
	private ComboBox<RoomStatus> roomTypeComboBox;
	
	@FXML 
	private TextField roomNumTextField;
	
	@FXML
	private AnchorPane ratingAnchorPane;
	
	@FXML 
	private TextField minPriceTextField;
	
	@FXML 
	private TextField maxPriceTextField;
	
	@FXML 
	private TextField minRankTextField;
	
	@FXML 
	private ToggleButton hasOrderedToggleButton;
	
	private Rating starRating;
	
	public DetailSearchPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		showStar();
	}
	
	private void showStar() {
		starRating = new Rating(5, 0);
		ratingAnchorPane.getChildren().add(starRating);
	}
	
	public RoomStatus getRoomStatus() {
		return roomTypeComboBox.getValue();
	}
	
	
}
