package presentation.customer.init;

import org.controlsfx.control.Rating;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import po.RoomStatus;
import utility.VerifyUtility;

public class DetailSearchPaneController {

	@FXML
	private ComboBox<String> roomTypeComboBox;

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
		roomTypeComboBox.setItems(FXCollections.observableArrayList("单人间", "双人间", "三人间"));
	}

	private void showStar() {
		starRating = new Rating(5, 0);
		ratingAnchorPane.getChildren().add(starRating);
	}

	public RoomStatus getRoomStatus() {
		if (roomTypeComboBox.getValue() == null) {
			return null;
		} else if (roomTypeComboBox.getValue().equals("单人间")) {
			return RoomStatus.SINGLE;
		} else if (roomTypeComboBox.getValue().equals("双人间")) {
			return RoomStatus.DOUBLE;
		} else if (roomTypeComboBox.getValue().equals("三人间")) {
			return RoomStatus.TRIPLE;
		} else {
			return null;
		}
	}
	
	public int getRoomNumber() {
		String roomNum = roomNumTextField.getText();
		if (roomNum!=null && !roomNum.isEmpty() && VerifyUtility.isInteger(roomNum)) {
			return Integer.valueOf(roomNum);
		} else {
			return -1;
		}
	}
	
	public int getRate() {
		return (int) starRating.getRating();
	}
	
	public int getMinPrice() {
		String minPrice = minPriceTextField.getText();
		if (minPrice!=null && !minPrice.isEmpty() && VerifyUtility.isInteger(minPrice)) {
			return Integer.valueOf(minPrice);
		} else {
			return -1;
		}
	}
	
	public int getMaxPrice() {
		String maxPrice = maxPriceTextField.getText();
		if (maxPrice!=null && !maxPrice.isEmpty() && VerifyUtility.isInteger(maxPrice)) {
			return Integer.valueOf(maxPrice);
		} else {
			return -1;
		}
	}
	
	public int getMinRank() {
		String minRank = minRankTextField.getText();
		if (minRank!=null && !minRank.isEmpty() && VerifyUtility.isInteger(minRank)) {
			return Integer.valueOf(minRank);
		} else {
			return -1;
		}
	}
	
	public boolean hasOrdered() {
		return hasOrderedToggleButton.isSelected();
	}

}
