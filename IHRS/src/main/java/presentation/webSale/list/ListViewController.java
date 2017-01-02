package presentation.webSale.list;

import java.io.IOException;

import org.controlsfx.control.PopOver;

import controller.WebSaleController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import utility.TimeUtility;
import vo.ListVO;

public class ListViewController {

	@FXML
	private ToggleButton unexecutedToggleButton;

	@FXML
	private ToggleButton abnormalToggleButton;

	@FXML
	private ToggleButton revokedToggleButton;

	@FXML
	private ListView<ListVO> simpleListView;

	private WebSaleController mainApp;

	/*
	 * 0:δִ�ж���;1:��ִ�ж���;2:�쳣����;3:�ѳ�������;
	 */
	private int type;

	private ObservableList<ListVO> unexecutedLists;

	private ObservableList<ListVO> abnormalLists;

	private ObservableList<ListVO> revokedLists;

	// private ObservableList<ListVO> showLists;

	public ListViewController() {
	}

	@FXML
	private void initialize() {
		// showLists = FXCollections.observableArrayList();
		unexecutedLists = FXCollections.observableArrayList();
		abnormalLists = FXCollections.observableArrayList();
		revokedLists = FXCollections.observableArrayList();

		// simpleListView.setItems(showLists);
		simpleListView.setCellFactory((ListView<ListVO> e) -> new SimpleListViewCell(this));
	}

	@FXML
	private void showUnexecutedLists() {

		simpleListView.setItems(unexecutedLists);
		// showLists.clear();
		// for (ListVO listVO : unexecutedLists) {
		// showLists.add(listVO);
		// }
		type = 0;
	}

	@FXML
	private void showAbnormalLists() {
		simpleListView.setItems(abnormalLists);
		// showLists.clear();
		// for (ListVO listVO : abnormalLists) {
		// showLists.add(listVO);
		// }
		type = 2;
	}

	@FXML
	private void showRevokedLists() {
		simpleListView.setItems(revokedLists);
		// showLists.clear();
		// for (ListVO listVO : revokedLists) {
		// showLists.add(listVO);
		// }
		type = 3;
	}

	public void showDetail(Label label, ListVO listVO) {
		simpleListView.getSelectionModel().select(-1);
		FXMLLoader loader = new FXMLLoader();
		AnchorPane anchorPane = null;
		try {
			switch (type) {
			case 0:
				loader.setLocation(ListViewController.class.getResource("UnExecutedListCell.fxml"));
				anchorPane = (AnchorPane) loader.load();
				UnexecutedListCellController uController = loader.getController();
				uController.setList(listVO);
				uController.setUpperController(this);
				break;
			case 2:
				loader.setLocation(ListViewController.class.getResource("AbnormalListCell.fxml"));
				anchorPane = (AnchorPane) loader.load();
				AbnormalListCellController aController = loader.getController();
				aController.setList(listVO);
				aController.setUpperController(this);
				aController.setMainApp(mainApp);
				;
				break;
			case 3:
				loader.setLocation(ListViewController.class.getResource("RevokedListCell.fxml"));
				anchorPane = (AnchorPane) loader.load();
				RevokedListCellController rController = loader.getController();
				rController.setList(listVO);
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		PopOver popOver = new PopOver(anchorPane);
		popOver.show(label);
	}

	public void revoke(ListVO listVO) {
		abnormalLists.remove(listVO);
		revokedLists.add(listVO);
	}

	public void setMainApp(WebSaleController mainApp) {
		this.mainApp = mainApp;
		showAbnormalLists();
		unexecutedLists.addAll(mainApp.getUnexecutedLists(TimeUtility.getDateStr()));
		abnormalLists.addAll(mainApp.getAbnormalLists());
		revokedLists.addAll(mainApp.getRevokedLists());
	}
}
