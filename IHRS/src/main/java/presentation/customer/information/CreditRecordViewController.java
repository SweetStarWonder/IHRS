package presentation.customer.information;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import vo.CreditChangeVO;

public class CreditRecordViewController {
	
	
	@FXML
	private Label creditLabel;
	
	@FXML
	private ListView<CreditChangeVO> creditChangeListView;
	
	private ObservableList<CreditChangeVO> creditChangeVOs;
	
	public CreditRecordViewController() {
		
	}
	
	@FXML
	private void initialize() {
		creditChangeVOs = FXCollections.observableArrayList();
		showCreditChanges();
	}
	
	private void showCreditChanges() {
		creditChangeListView.setItems(creditChangeVOs);
		creditChangeListView.setCellFactory((ListView<CreditChangeVO> i) -> new CreditCell());
		for (int i = 0; i < 50; i++) {
			creditChangeVOs.add(null);
		}
		
				
	}
}
