package presentation.customer;

import java.io.IOException;
import java.util.ArrayList;

import controller.CustomerController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.customer.hotel.HotelDetailInformationController;
import presentation.customer.information.CreditRecordViewController;
import presentation.customer.information.ModifyInformationController;
import presentation.customer.information.PersonInformationController;
import presentation.customer.information.PersonalHotelViewController;
import presentation.customer.information.PersonalListViewController;
import presentation.customer.init.CustomerRootLayoutController;
import presentation.customer.init.HotelSearchPaneController;
import presentation.customer.list.ListGenerateViewController;
import presentation.customer.vip.EnterpriseVipPaneController;
import presentation.customer.vip.NormalVipPaneController;
import vo.HotelVO;
import vo.ListVO;

public class CustomerView extends Application {

	private CustomerController controller;

	public CustomerView(CustomerController controller) {
		this.controller = controller;
	}

	ObservableList<Node> sceneStack = FXCollections.observableArrayList();

	private Stage primaryStage;

	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

		initRoot();
		showSearchPane();
	}

	public void initRoot() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("init/CustomerRootLayout.fxml"));
		try {
			rootLayout = (BorderPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		CustomerRootLayoutController controller = loader.getController();
		controller.setMainApp(this.controller);
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void showSearchPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("init/HotelSearchPane.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			HotelSearchPaneController controller = loader.getController();
			controller.setMainApp(this.controller);
			sceneStack.add(anchorPane);
			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPersonalInformation() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("information/PersonInformationOverview.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PersonInformationController controller = loader.getController();
		controller.setMainApp(this.controller);
	}

	public void modifyPersonalInformation() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("information/PersonInformationModify.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			ModifyInformationController controller = loader.getController();
			controller.setController(this.controller);
			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showCreditRecord() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("information/CreditRecordView.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			CreditRecordViewController controller = loader.getController();
			controller.setController(this.controller);
			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void registerNormalVip() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("vip/RegisterNormalVipPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stage dialogStage = new Stage();
		dialogStage.initStyle(StageStyle.TRANSPARENT);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(primaryStage);
		Scene scene = new Scene(anchorPane);
		dialogStage.setScene(scene);

		NormalVipPaneController controller = loader.getController();
		controller.setNormalVipStage(dialogStage);
		controller.setController(this.controller);

		dialogStage.showAndWait();
	}

	public void registerEnterpriseVip() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("vip/RegisterEnterpriseVipPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stage dialogStage = new Stage();
		dialogStage.initStyle(StageStyle.TRANSPARENT);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(primaryStage);
		Scene scene = new Scene(anchorPane);
		dialogStage.setScene(scene);

		EnterpriseVipPaneController controller = loader.getController();
		controller.setNormalVipStage(dialogStage);
		controller.setController(this.controller);

		dialogStage.showAndWait();
	}

	public void showHotelLists(HotelVO hotelVO) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("information/PersonalListView.fxml"));
		SplitPane splitPane;
		ArrayList<ListVO> listVOs = controller.getHotelLists(hotelVO);
		try {
			splitPane = (SplitPane) loader.load();
			changeView(splitPane);
			PersonalListViewController controller = loader.getController();
			controller.setController(this.controller);
			controller.setLists(listVOs);
			rootLayout.setCenter(splitPane);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void showPersonalLists() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("information/PersonalListView.fxml"));
		SplitPane splitPane;
		ArrayList<ListVO> listVOs = controller.getPersonalLists();
		try {
			splitPane = (SplitPane) loader.load();
			changeView(splitPane);
			PersonalListViewController controller = loader.getController();
			controller.setController(this.controller);
			controller.setLists(listVOs);
			rootLayout.setCenter(splitPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPersonalHotels() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("information/PersonalHotelView.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			PersonalHotelViewController controller = loader.getController();
			controller.setMainApp(this.controller);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showHotelDetailInformation(HotelVO hotelVO) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("hotel/HotelDetailInfomation.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();

			HotelDetailInformationController controller = loader.getController();
			controller.setMainApp(this.controller);
			controller.setHotel(hotelVO);
			
			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showGenerateList(HotelVO hotelVO) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerView.class.getResource("list/ListGenerateView.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			
			ListGenerateViewController controller = loader.getController();
			controller.setHotel(hotelVO);
			controller.setController(this.controller);
			
			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void changeName() {
		initRoot();
	}
	
	public void changeView(Node node) {
		sceneStack.add(node);
	}

	public void backView() {
		if (sceneStack.size() > 1) {
			int size = sceneStack.size();
			sceneStack.remove(size - 1);
			rootLayout.setCenter(sceneStack.get(size - 2));
		}
	}
}
