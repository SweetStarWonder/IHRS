package presentation.customer;

import java.io.IOException;

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
import presentation.customer.information.PersonInformationController;
import presentation.customer.information.PersonalHotelViewController;
import presentation.customer.init.CustomerRootLayoutController;
import presentation.customer.init.HotelSearchPaneController;
import presentation.customer.vip.EnterpriseVipPaneController;
import presentation.customer.vip.NormalVipPaneController;

public class TestCustomer extends Application {

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
		loader.setLocation(TestCustomer.class.getResource("init/CustomerRootLayout.fxml"));
		try {
			rootLayout = (BorderPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		CustomerRootLayoutController controller = loader.getController();
		controller.setMainApp(this);
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void showSearchPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestCustomer.class.getResource("init/HotelSearchPane.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			HotelSearchPaneController controller = loader.getController();
			controller.setMainApp(this);
			sceneStack.add(anchorPane);
			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPersonalInformation() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestCustomer.class.getResource("information/PersonInformationOverview.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PersonInformationController controller = loader.getController();
		controller.setMainApp(this);
	}

	public void modifyPersonalInformation() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestCustomer.class.getResource("information/PersonInformationModify.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showCreditRecord() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestCustomer.class.getResource("information/CreditRecordView.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void registerNormalVip() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestCustomer.class.getResource("vip/RegisterNormalVipPane.fxml"));
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

		dialogStage.showAndWait();
	}

	public void registerEnterpriseVip() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestCustomer.class.getResource("vip/RegisterEnterpriseVipPane.fxml"));
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

		dialogStage.showAndWait();
	}

	public void showPersonalLists() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestCustomer.class.getResource("information/PersonalListView.fxml"));
		SplitPane splitPane;
		try {
			splitPane = (SplitPane) loader.load();
			changeView(splitPane);

			rootLayout.setCenter(splitPane);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showPersonalHotels() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestCustomer.class.getResource("information/PersonalHotelView.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			PersonalHotelViewController controller = loader.getController();
			controller.setMainApp(this);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showHotelDetailInformation() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestCustomer.class.getResource("hotel/HotelDetailInfomation.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();

			HotelDetailInformationController controller = loader.getController();
			controller.setMainApp(this);

			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showGenerateList() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestCustomer.class.getResource("list/ListGenerateView.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public static void main(String[] args) {
		launch(args);
	}
}
