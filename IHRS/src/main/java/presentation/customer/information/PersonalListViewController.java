package presentation.customer.information;

import java.io.IOException;

import org.controlsfx.control.PopOver;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import po.ListStatus;
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
	
	private ObservableList<ListVO> listVOs;
	
	public PersonalListViewController() {
	}
	
	@FXML 
	private void initialize() {
		listVOs = FXCollections.observableArrayList();
		for (int i = 0; i < 50; i++) {
			listVOs.add(new ListVO(i, 22, 22, ListStatus.ABNORMAL, "1", "2", "2", 2, false));
		}
		listListView.setItems(listVOs);
		listListView.setCellFactory((ListView<ListVO> e) -> new ListViewCell());
		listListView.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showListDetail(newValue));
		
	}
		
	private void showListDetail(ListVO listVO) {
		FXMLLoader loader = new FXMLLoader();
		AnchorPane anchorPane = null;
		loader.setLocation(PersonalListViewController.class.getResource("ListCell.fxml"));
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PopOver popOver = new PopOver(anchorPane);
		popOver.show(listListView);
	}
	
	
}
