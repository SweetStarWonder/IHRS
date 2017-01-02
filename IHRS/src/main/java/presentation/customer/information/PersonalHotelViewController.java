package presentation.customer.information;

import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;

import controller.CustomerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import presentation.customer.init.HotelCell;
import vo.HotelVO;

public class PersonalHotelViewController {

	@FXML
	private AnchorPane hotelAnchorPane;

	private ObservableList<HotelVO> hotels;

	private CustomerController mainApp;

	public PersonalHotelViewController() {

	}

	@FXML
	private void initialize() {
	}

	public void setMainApp(CustomerController mainApp) {
		hotels = FXCollections.observableArrayList();
		GridView<HotelVO> myGrid = new GridView<HotelVO>(hotels);
		myGrid.setCellFactory(new Callback<GridView<HotelVO>, GridCell<HotelVO>>() {

			public GridCell<HotelVO> call(GridView<HotelVO> param) {
				return new PersonalHotelCell(mainApp);
			}
		});
		hotels.addAll(mainApp.getPersonalHotels());
		myGrid.setCellHeight(160);
		myGrid.setCellWidth(160);
		myGrid.setHorizontalCellSpacing(5);
		myGrid.setPrefHeight(325);
		myGrid.setPrefWidth(700);
		this.mainApp = mainApp;

		hotelAnchorPane.getChildren().add(myGrid);
	}
}
