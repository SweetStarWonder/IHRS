package presentation.customer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller {
	
	@FXML
	private ListView<String> listView;
	
	@FXML
	private Label label;
	
	private ObservableList<String> list;
	
	public Controller() {
		
	}
	
	@FXML
	private void initialize() {
		list = FXCollections.observableArrayList();
		list.add("pi");
		list.add("ka");
		list.add("qiu");
		listView.setItems(list);
		
		 listView.getSelectionModel().selectedItemProperty().addListener(
		            new ChangeListener<String>() {

						@Override
						public void changed(ObservableValue<? extends String> observable, String oldValue,
								String newValue) {
							label.setText(newValue);
						}
		        });
	}
}
