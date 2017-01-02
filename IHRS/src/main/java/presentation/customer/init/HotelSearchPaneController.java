package presentation.customer.init;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.controlsfx.control.GridView;
import org.controlsfx.control.SegmentedButton;

import controller.CustomerController;
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
import utility.VerifyUtility;
import vo.HotelVO;
import vo.RoomVO;

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

	private CustomerController mainApp;

	private DetailSearchPaneController detailSearchPaneController;

	private GridView<HotelVO> hotelGridView;

	private SegmentedButton sortSegmentedButton;
	
	private ObservableList<String> businessDistrictList;
	
	private ObservableList<String> addressList;
	
	private HashMap<String, ArrayList<String>> addressMap;
	
	private ToggleButton priceToggleButton = new ToggleButton("价格");
	private ToggleButton starToggleButton = new ToggleButton("星级");
	private ToggleButton rankToggleButton = new ToggleButton("评分");
	

	ObservableList<HotelVO> listByPrice = FXCollections.observableArrayList();
	
	ObservableList<HotelVO> listByStar = FXCollections.observableArrayList();
	
	ObservableList<HotelVO> listByRate = FXCollections.observableArrayList();
	
	GridView<HotelVO> myGrid;
	
	public HotelSearchPaneController() {
		priceToggleButton.setOnAction(e -> myGrid.setItems(listByPrice));
		starToggleButton.setOnAction(e -> myGrid.setItems(listByStar));
		rankToggleButton.setOnAction(e -> myGrid.setItems(listByRate));
	}

	@FXML
	private void initialize() {
		businessDistrictList = FXCollections.observableArrayList();
		addressList = FXCollections.observableArrayList();
		businessDistrictComboBox.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					addressList.clear();
					addressList.addAll(addressMap.get(newValue));
					addressComboBox.setItems(addressList);
				});
		
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
		ObservableList<HotelVO> result = FXCollections.observableArrayList();
		
		if (businessDistrictComboBox.getSelectionModel().getSelectedItem()==null || addressComboBox.getSelectionModel().getSelectedItem()==null
				|| businessDistrictComboBox.getSelectionModel().getSelectedItem().isEmpty() || addressComboBox.getSelectionModel().getSelectedItem().isEmpty()) {
			VerifyUtility.showWarning("信息不完整", "请选择商圈和地址");
		} else {
			result.addAll(mainApp.getSearchResults(addressComboBox.getSelectionModel().getSelectedItem(), businessDistrictComboBox.getSelectionModel().getSelectedItem(), nameSearchTextField.getText(), detailSearchPaneController.getRoomNumber(), detailSearchPaneController.getMinRank(), 20, detailSearchPaneController.getRate(), detailSearchPaneController.getRoomStatus(), detailSearchPaneController.getMinPrice(), detailSearchPaneController.getMaxPrice(), detailSearchPaneController.hasOrdered()));
		}
		
		listByPrice.clear();
		listByRate.clear();
		listByStar.clear();
		listByPrice.addAll(result);
		listByRate.addAll(result);
		listByStar.addAll(result);
		
		listByRate.sort((a, b) -> a.getAverageRank() >= b.getAverageRank() ? -1 : 1);
		listByStar.sort((a, b) -> a.getStarRating() >= b.getStarRating() ? -1 : 1);
		listByPrice.sort((a, b) -> getPrice(a) >= getPrice(b) ? 1 : -1);
		
		myGrid = new GridView<HotelVO>(result);
		myGrid.setCellFactory(e -> new HotelCell(mainApp));
		
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
			buttons.add(priceToggleButton);
			buttons.add(starToggleButton);
			buttons.add(rankToggleButton);
			sortSegmentedButton = new SegmentedButton(buttons);
			children.add(sortSegmentedButton);
		}

	}

	public void setMainApp(CustomerController mainApp) {
		this.mainApp = mainApp;
		addressMap = mainApp.getAddressMap();
		businessDistrictList.addAll(addressMap.keySet());
		businessDistrictComboBox.setItems(businessDistrictList);
	}
	
	private int getPrice(HotelVO hotelVO) {
		int price = -1;
		for (RoomVO roomVO : hotelVO.getRooms()) {
			if (price<0 || (price>=0&&roomVO.getPrice()>price)) {
				price = roomVO.getPrice();
			}
		}
		return price;
	}
}
