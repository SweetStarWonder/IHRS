package presentation.customer;

import java.io.IOException;

import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;
import org.controlsfx.control.Rating;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.customer.init.HotelCell;
import vo.HotelVO;

public class Test extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	     this.primaryStage.setTitle("aha");

	     //initRootLayout();
	     //initDetailSearch();
	    // testGrid();
	     //testCell();
	     testList();
	}
	
	private void initRootLayout() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Test.class.getResource("CustomerRootLayout.fxml"));
		try {
			rootLayout = (BorderPane)loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void initDetailSearch() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Test.class.getResource("init/DetailSearchPane.fxml"));
		try {
			GridPane gridPane = (GridPane) loader.load();
			AnchorPane anchorPane = new AnchorPane();
			Rating rating = new Rating(5, 0);
			anchorPane.getChildren().add(rating);			
			gridPane.add(anchorPane, 3, 0);
			
			Scene scene = new Scene(gridPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testGrid() {
		ObservableList<HotelVO> list = FXCollections.observableArrayList();
		GridView<HotelVO> myGrid = new GridView<HotelVO>(list);
		myGrid.setCellFactory(new Callback<GridView<HotelVO>, GridCell<HotelVO>>() {
			
			public GridCell<HotelVO> call(GridView<HotelVO> param) {
				// TODO Auto-generated method stub
				return new HotelCell();
			}
			});
		for (int i = 0; i < 20; i++) {
			list.add(null);
		}
		myGrid.setCellHeight(160);
		myGrid.setCellWidth(160);
		myGrid.setHorizontalCellSpacing(5);
		myGrid.setPrefHeight(325);
		myGrid.setPrefWidth(650);
		myGrid.setStyle("-fx-background: #CFFFFF;");
		
		
		
		Scene scene = new Scene(myGrid);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@SuppressWarnings("static-access")
	public void testCell() {
		 FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(Test.class.getResource("HotelInformationCell.fxml"));
		 AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Rating rating = new Rating();
		 anchorPane.getChildren().add(rating);
		 anchorPane.setLeftAnchor(rating, (double) 12);
		 anchorPane.setTopAnchor(rating, 62.0);
		 anchorPane.setRightAnchor(rating, 73.0);
		 
		 Scene scene = new Scene(anchorPane);
		 primaryStage.setScene(scene);
		 primaryStage.show();
	}
	
	public void testList() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Test.class.getResource("Testlist.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane)loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scene scene = new Scene(anchorPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
