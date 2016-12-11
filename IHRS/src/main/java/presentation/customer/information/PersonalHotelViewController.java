package presentation.customer.information;

import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import presentation.customer.TestCustomer;
import presentation.customer.init.HotelCell;
import vo.HotelVO;

public class PersonalHotelViewController {

	@FXML
	private AnchorPane hotelAnchorPane;
	
	private ObservableList<HotelVO> hotels;
	
	private TestCustomer mainApp;
	
	public PersonalHotelViewController() {
		
	}
	
	@FXML
	private void initialize() {
		hotels = FXCollections.observableArrayList();
		showHotels();
	}
	
	private void showHotels() {
		GridView<HotelVO> myGrid = new GridView<HotelVO>(hotels);
		myGrid.setCellFactory(new Callback<GridView<HotelVO>, GridCell<HotelVO>>() {
			
			public GridCell<HotelVO> call(GridView<HotelVO> param) {
				return new PersonalHotelCell(mainApp);
			}
			});
		for (int i = 0; i < 20; i++) {
			hotels.add(null);
		}
		myGrid.setCellHeight(160);
		myGrid.setCellWidth(160);
		myGrid.setHorizontalCellSpacing(5);
		myGrid.setPrefWidth(700);
		myGrid.setPrefHeight(480);
		
		hotelAnchorPane.getChildren().add(myGrid);
	}
	
	public void setMainApp(TestCustomer mainApp) {
		this.mainApp = mainApp;
	}
}
