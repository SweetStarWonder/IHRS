package presentation.webManager.init;

import java.io.IOException;

import org.controlsfx.control.SegmentedButton;

import controller.WebManagerController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import presentation.webManager.WebManagerView;
import presentation.webManager.customer.CustomerInformationPaneController;
import presentation.webManager.customer.CustomerSearchPaneController;
import presentation.webManager.hotel.HotelManagerInformationPaneController;
import presentation.webManager.hotel.HotelManagerSearchPaneController;
import presentation.webManager.webSale.WebSaleInformationPaneController;
import presentation.webManager.webSale.WebSaleSearchPaneController;

public class TypeSelectPaneController {

	@FXML
	private AnchorPane chooseAnchorPane;

	@FXML
	private AnchorPane searchAnchorPane;

	private WebManagerController mainApp;

	private SegmentedButton typeChooseButton;

	public TypeSelectPaneController() {

	}

	@FXML
	private void initialize() {
		ToggleButton customerToggleButton = new ToggleButton("客户信息管理");
		customerToggleButton.setSelected(true);
		customerToggleButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				searchCustomer();
			}
		});
		ToggleButton hotelToggleButton = new ToggleButton("酒店信息管理");
		hotelToggleButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				searchHotelManager();
			}
		});
		ToggleButton webSaleToggleButton = new ToggleButton("网站营销人员信息管理");
		webSaleToggleButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				searchWebSale();
			}
		});
		typeChooseButton = new SegmentedButton(customerToggleButton, hotelToggleButton, webSaleToggleButton);
		chooseAnchorPane.getChildren().add(typeChooseButton);

	}

	private void searchCustomer() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebManagerView.class.getResource("customer/CustomerSearchPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
			CustomerSearchPaneController controller = loader.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}

		searchAnchorPane.getChildren().clear();
		searchAnchorPane.getChildren().add(anchorPane);
	}

	private void searchHotelManager() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebManagerView.class.getResource("hotel/HotelManagerSearchPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
			HotelManagerSearchPaneController controller = loader.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}

		searchAnchorPane.getChildren().clear();
		searchAnchorPane.getChildren().add(anchorPane);
	}

	private void searchWebSale() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebManagerView.class.getResource("webSale/WebSaleSearchPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
			WebSaleSearchPaneController controller = loader.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}

		searchAnchorPane.getChildren().clear();
		searchAnchorPane.getChildren().add(anchorPane);
	}

	public void setMainApp(WebManagerController mainApp) {
		this.mainApp = mainApp;
		searchCustomer();
	}

}
