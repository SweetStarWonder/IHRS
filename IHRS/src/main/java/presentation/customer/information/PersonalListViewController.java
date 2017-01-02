package presentation.customer.information;

import java.io.IOException;
import java.util.ArrayList;

import org.controlsfx.control.PopOver;

import controller.CustomerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import po.ListStatus;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import vo.ListVO;

public class PersonalListViewController {

	@FXML
	private ToggleButton unexecutedListToggleButton;

	@FXML
	private ToggleButton executedListToggleButton;

	@FXML
	private ToggleButton abnormalListToggleButton;

	@FXML
	private ToggleButton revokedListToggleButton;

	@FXML
	private ListView<ListVO> listListView;
	
	private CustomerController controller;

	private int type = 0;
	
	private ObservableList<ListVO> unexecutedLists;

	private ObservableList<ListVO> executedLists;

	private ObservableList<ListVO> abnormalLists;

	private ObservableList<ListVO> revokedLists;

	public PersonalListViewController() {
	}

	@FXML
	private void initialize() {
		
		unexecutedLists = FXCollections.observableArrayList();
		executedLists = FXCollections.observableArrayList();
		abnormalLists = FXCollections.observableArrayList();
		revokedLists = FXCollections.observableArrayList();
		
		listListView.setCellFactory((ListView<ListVO> e) -> new ListViewCell(this));
		
	}
	
	@FXML
	private void showUnexecutedLists() {

		listListView.setItems(unexecutedLists);
		type = 0;
	}

	@FXML
	private void showExecutedLists() {
		listListView.setItems(executedLists);
		type = 1;
	}

	@FXML
	private void showAbnormalLists() {
		listListView.setItems(abnormalLists);
		type = 2;
	}

	@FXML
	private void showRevokedLists() {
		listListView.setItems(revokedLists);
		type = 3;
	}

	public void showDetail(Label label, ListVO listVO) {
		listListView.getSelectionModel().select(-1);
		FXMLLoader loader = new FXMLLoader();
		AnchorPane anchorPane = null;
		try {
			switch (type) {
			case 0:
				loader.setLocation(PersonalListViewController.class.getResource("UnExecutedListCell.fxml"));
				anchorPane = (AnchorPane) loader.load();
				UnexecutedListCellController uController = loader.getController();
				uController.setController(controller);
				uController.setUpperController(this);
				uController.setList(listVO);
				break;
			case 1:
				
			case 2:
				loader.setLocation(PersonalListViewController.class.getResource("ListCell.fxml"));
				anchorPane = (AnchorPane) loader.load();
				ListCellController aController = loader.getController();
				aController.setList(listVO);
				break;
			case 3:
				loader.setLocation(PersonalListViewController.class.getResource("RevokedListCell.fxml"));
				anchorPane = (AnchorPane) loader.load();
				ListCellController controller = loader.getController();
				controller.setList(listVO);
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		PopOver popOver = new PopOver(anchorPane);
		popOver.show(label);
	}
	
	public void setController(CustomerController controller) {
		this.controller = controller;
	}
	
	public void revoke(ListVO listVO) {
		unexecutedLists.remove(listVO);
		revokedLists.add(listVO);
	}
	
	public void setLists(ArrayList<ListVO> listVOs) {
		for (ListVO listVO : listVOs) {
			if (listVO.getStatus().equals(ListStatus.NOTEXECUTED)) {
				unexecutedLists.add(listVO);
			} else if (listVO.getStatus().equals(ListStatus.EXECUTED)) {
				executedLists.add(listVO);
			} else if (listVO.getStatus().equals(ListStatus.ABNORMAL)) {
				abnormalLists.add(listVO);
			} else if (listVO.getStatus().equals(ListStatus.REVOKED)) {
				revokedLists.add(listVO);
			}
		}
		showUnexecutedLists();
	}

}
