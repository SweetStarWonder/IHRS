package presentation.webManager;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.webManager.customer.CustomerModifyPaneControlelr;
import presentation.webManager.hotel.HotelManagerModifyPaneController;
import presentation.webManager.init.TypeSelectPaneController;
import presentation.webManager.init.WebManagerRootLayoutController;
import presentation.webManager.webSale.WebSaleModifyPaneController;

public class TestWebManager extends Application {

	
	ObservableList<Node> sceneStack = FXCollections.observableArrayList();
	
	private Stage primaryStage;
	
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		initRoot();
		showTypeSelectPane();
	}
	
	public void initRoot() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestWebManager.class.getResource("init/WebManagerRootLayout.fxml"));
		try {
			rootLayout = (BorderPane)loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		WebManagerRootLayoutController controller = loader.getController();
		controller.setMainApp(this);
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void showTypeSelectPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestWebManager.class.getResource("init/TypeSelectPane.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			TypeSelectPaneController controller = loader.getController();
			controller.setMainApp(this);
			sceneStack.add(anchorPane);
			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyCustomerDialog() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestWebManager.class.getResource("customer/CustomerModifyPane.fxml"));
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
        
        CustomerModifyPaneControlelr controller = loader.getController();
        controller.setStage(dialogStage);
        
        dialogStage.showAndWait();
	}
	
	public void modifyHotelManagerDialog() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestWebManager.class.getResource("hotel/HotelManagerModifyPane.fxml"));
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
        
        HotelManagerModifyPaneController controller = loader.getController();
        controller.setStage(dialogStage);
        
        dialogStage.showAndWait();
	}
	
	public void modifyWebSaleDialog() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestWebManager.class.getResource("webSale/WebSaleModifyPane.fxml"));
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
        
        WebSaleModifyPaneController controller = loader.getController();
        controller.setStage(dialogStage);
        
        dialogStage.showAndWait();
	}
	
	public void addWebSaleDialog() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestWebManager.class.getResource("webSale/WebSaleModifyPane.fxml"));
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
        
        WebSaleModifyPaneController controller = loader.getController();
        controller.setStage(dialogStage);
        
        dialogStage.showAndWait();
	}
	
	public void addHotelPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TestWebManager.class.getResource("hotel/AddHotelPane.fxml"));
		ScrollPane scrollPane;
		try {
			scrollPane = (ScrollPane) loader.load();
			changeView(scrollPane);
			
			rootLayout.setCenter(scrollPane);
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
