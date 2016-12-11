package presentation.customer.list;

import org.controlsfx.control.CheckComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ListGenerateViewController {

	
	
	@FXML
	private DatePicker beginTimeDatePicker;
	
	@FXML
	private TextField beginTimeHourTextField;
	
	@FXML
	private TextField beginTimeMinuteTextField;
	
	@FXML
	private DatePicker endTimeDatePicker;
	
	@FXML
	private TextField endTimeHourTextField;
	
	@FXML
	private TextField endTimeMinuteTextField;
	
	@FXML
	private DatePicker lastExTimeDatePicker;
	
	@FXML
	private TextField lastExTimeHourTextField;
	
	@FXML
	private TextField lastExTimeMinuteTextField;
	
	@FXML
	private HBox roomChooseHBox;
	
	@FXML
	private Label singleNumLabel;
	
	@FXML
	private Label singlePriceLabel;
	
	@FXML
	private Label doubleNumLabel;
	
	@FXML
	private Label doublePriceLabel;
	
	@FXML
	private Label tripleNumLabel;
	
	@FXML
	private Label triplePriceLabel;
	
	@FXML
	private TextField personNumTextField;
	
	@FXML
	private RadioButton haveChildRadioButton;
	
	@FXML
	private RadioButton noChildRadioButton;
	
	@FXML
	private Label promotionNameLabel;
	
	@FXML
	private Label promotionPriceLabel;
	
	@FXML 
	private Label totalPriceLabel;
	
	@FXML
	private Button confirmButton;
	
	private CheckComboBox<String> roomChooseComboBox;
	
	private ObservableList<String> rooms;
	
	public ListGenerateViewController() {
		
	}
	
	@FXML
	private void initialize() {
		rooms = FXCollections.observableArrayList();
		for (int i = 0; i < 50; i++) {
			rooms.add("jiba " + i);
		}
		roomChooseComboBox = new CheckComboBox<>(rooms);
		roomChooseHBox.getChildren().add(roomChooseComboBox);
	}
	
	@FXML
	private void handleConfirmButton() {
		
	}
}
