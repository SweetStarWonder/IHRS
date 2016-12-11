package presentation.customer.init;

import java.io.IOException;

import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;
import org.controlsfx.control.SegmentedButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import presentation.customer.TestCustomer;
import vo.HotelVO;

public class HotelSearchPaneController {
	
	
	
	@FXML
	private ComboBox<String> businessDistrictComboBox;
	
	@FXML
	private ComboBox<String> addressComboBox;
	
	@FXML 
	private TextField nameSearchTextField;
	
	@FXML 
	private Button searchButton;
	
	@FXML 
	private TreeView<GridPane> detailSearchTreeView;
	
	@FXML
	private AnchorPane sortAnchorPane;
	
	@FXML 
	private AnchorPane searchResultAnchorPane;
	
	private TestCustomer mainApp;
	
	private DetailSearchPaneController detailSearchPaneController;
	
	private GridView<HotelVO> hotelGridView;
	
	private SegmentedButton sortSegmentedButton;
	
	public HotelSearchPaneController() {

	}
	
	@FXML
	private void initialize() {
		showDetailSearch();
	}
	
	@FXML
	private void showDetailSearch() {
		GridPane rootPane = null;
		GridPane detailSearchPane = null;
		FXMLLoader rootLoader = new FXMLLoader();
		rootLoader.setLocation(HotelSearchPaneController.class.getResource("DetailSearchRoot.fxml"));
		FXMLLoader childLoader = new FXMLLoader();
		childLoader.setLocation(HotelSearchPaneController.class.getResource("DetailSearchPane.fxml"));
		
		try {
			rootPane = (GridPane) rootLoader.load();
			detailSearchPane = (GridPane) childLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		detailSearchPaneController = childLoader.getController();
		TreeItem<GridPane> rootItem = new TreeItem<GridPane>(rootPane);
		TreeItem<GridPane> childItem = new TreeItem<GridPane>(detailSearchPane);
		rootItem.getChildren().add(childItem);
		detailSearchTreeView.setRoot(rootItem);
	}
	
	@FXML 
	private void showSearchResult() {
		ObservableList<HotelVO> list = FXCollections.observableArrayList();
		GridView<HotelVO> myGrid = new GridView<HotelVO>(list);
		myGrid.setCellFactory(new Callback<GridView<HotelVO>, GridCell<HotelVO>>() {
			
			public GridCell<HotelVO> call(GridView<HotelVO> param) {
				// TODO Auto-generated method stub
				return new HotelCell(mainApp);
			}
			});
		for (int i = 0; i < 20; i++) {
			list.add(null);
		}
		myGrid.setCellHeight(160);
		myGrid.setCellWidth(160);
		myGrid.setHorizontalCellSpacing(5);
		myGrid.setPrefHeight(325);
		myGrid.setPrefWidth(700);
		
		hotelGridView = myGrid;
		ObservableList<Node> children = searchResultAnchorPane.getChildren();
		if (!children.isEmpty()) {
			children.remove(0);
		}
		children.add(myGrid);
		
		
		showSortButtons();
	}
	
	private void showSortButtons() {
		ObservableList<Node> children = sortAnchorPane.getChildren();
		if (children.isEmpty()) {			
			ObservableList<ToggleButton> buttons = FXCollections.observableArrayList();
			ToggleButton priceToggleButton = new ToggleButton("价格");
			ToggleButton starToggleButton = new ToggleButton("星级");
			ToggleButton rankToggleButton = new ToggleButton("评分");
			buttons.add(priceToggleButton);
			buttons.add(starToggleButton);
			buttons.add(rankToggleButton);
			sortSegmentedButton = new SegmentedButton(buttons);
			children.add(sortSegmentedButton);	
		}
		
	}
	
	public void setMainApp(TestCustomer mainApp) {
		this.mainApp = mainApp;
	}
}
