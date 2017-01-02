package presentation.hotelManager;

import java.io.IOException;

import controller.HotelManagerController;
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
import presentation.hotelManager.hotel.HotelDetailInformationController;
import presentation.hotelManager.hotel.HotelInformationModifyController;
import presentation.hotelManager.init.MenuPaneController;
import presentation.hotelManager.init.RootLayoutController;
import presentation.hotelManager.list.CheckInRecordPaneController;
import presentation.hotelManager.list.CheckOutPaneController;
import presentation.hotelManager.list.ListViewController;
import presentation.hotelManager.promotion.AddNormalPromotionDialogController;
import presentation.hotelManager.promotion.AddTimePromotionDialogController;
import presentation.hotelManager.promotion.HotelPromotionListController;
import presentation.hotelManager.room.AddRoomDialogController;
import presentation.hotelManager.room.RoomManageController;
import vo.ListVO;

public class HotelManagerView extends Application {

	ObservableList<Node> sceneStack = FXCollections.observableArrayList();

	private Stage primaryStage;

	private BorderPane rootLayout;

	private HotelManagerController controller;

	public HotelManagerView(HotelManagerController controller) {
		this.controller = controller;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

		initRoot();
		showMenuPane();
	}

	public void initRoot() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("init/HotelManagerRootLayout.fxml"));
		try {
			rootLayout = (BorderPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		RootLayoutController controller = loader.getController();
		controller.setMainApp(this.controller);
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void showMenuPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("init/HotelManagerMenuPane.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			MenuPaneController controller = loader.getController();
			controller.setMainApp(this.controller);
			sceneStack.add(anchorPane);
			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showHotelInformation() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("hotel/HotelDetailInformation.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			HotelDetailInformationController controller = loader.getController();
			controller.setMainApp(this.controller);
			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void modifyHotelInformation() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("hotel/HotelInformationModifyPane.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			HotelInformationModifyController controller = loader.getController();
			controller.setController(this.controller);

			changeView(anchorPane);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showHotelPromotion() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("promotion/HotelPromotionListView.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);
			HotelPromotionListController controller = loader.getController();
			controller.setMainApp(this.controller);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addNormalPromotionPane(HotelPromotionListController upperController, String type) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("promotion/AddNormalPromotionDialog.fxml"));
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

		AddNormalPromotionDialogController controller = loader.getController();
		controller.setStage(dialogStage);
		controller.setController(this.controller);
		controller.setUpperController(upperController);
		controller.setType(type.charAt(0));

		dialogStage.showAndWait();
	}

	public void addTimePromotionPane(HotelPromotionListController upperController) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("promotion/AddTimePromotionDialog.fxml"));
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

		AddTimePromotionDialogController controller = loader.getController();
		controller.setStage(dialogStage);
		controller.setUpperController(upperController);
		controller.setController(this.controller);

		dialogStage.showAndWait();
	}

	public void showRoomInformation() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("room/RoomManagePane.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);
			RoomManageController controller = loader.getController();
			controller.setMainApp(this.controller);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addRoomPane(RoomManageController upperController) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("room/AddRoomDialog.fxml"));
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

		AddRoomDialogController controller = loader.getController();
		controller.setStage(dialogStage);
		controller.setController(this.controller);
		controller.setUpperController(upperController);

		dialogStage.showAndWait();
	}

	public void showLists() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("list/ListView.fxml"));
		SplitPane splitPane;
		try {
			splitPane = (SplitPane) loader.load();
			changeView(splitPane);

			ListViewController controller = loader.getController();
			controller.setMainApp(this.controller);
			rootLayout.setCenter(splitPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showCheckInRecord(ListViewController upperController, ListVO listVO) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("list/CheckInRecordPane.fxml"));
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

		CheckInRecordPaneController controller = loader.getController();
		controller.setStage(dialogStage);
		controller.setController(this.controller);
		controller.setUpperController(upperController);
		controller.setList(listVO);

		dialogStage.showAndWait();
	}

	public void showCheckOutRecord(ListViewController upperController, ListVO listVO) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerView.class.getResource("list/CheckOutRecordPane.fxml"));
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

		CheckOutPaneController controller = loader.getController();
		controller.setStage(dialogStage);
		controller.setController(this.controller);
		controller.setList(listVO);
		controller.setUpperController(upperController);

		dialogStage.showAndWait();
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
