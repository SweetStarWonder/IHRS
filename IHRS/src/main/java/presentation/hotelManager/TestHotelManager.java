package presentation.hotelManager;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.customer.TestCustomer;
import presentation.customer.information.PersonInformationController;
import presentation.hotelManager.hotel.HotelDetailInformationController;
import presentation.hotelManager.init.MenuPaneController;
import presentation.hotelManager.init.RootLayoutController;

public class TestHotelManager extends Application{
	ObservableList<Node> sceneStack = FXCollections.observableArrayList();
	
	private Stage primaryStage;
	
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		initRoot();
		showMenuPane();
	}
	
	public void initRoot() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestHotelManager.class.getResource("init/HotelManagerRootLayout.fxml"));
		try {
			rootLayout = (BorderPane)loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		RootLayoutController controller = loader.getController();
		controller.setMainApp(this);
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void showMenuPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestHotelManager.class.getResource("init/HotelManagerMenuPane.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			MenuPaneController controller = loader.getController();
			controller.setMainApp(this);
			sceneStack.add(anchorPane);
			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showHotelInformation() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestHotelManager.class.getResource("hotel/HotelDetailInformation.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);
			
			HotelDetailInformationController controller = loader.getController();
			controller.setMainApp(this);
			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyHotelInformation() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestHotelManager.class.getResource("hotel/HotelInformationModifyPane.fxml"));
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
			sceneStack.remove(size-1);
			rootLayout.setCenter(sceneStack.get(size-2));
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
