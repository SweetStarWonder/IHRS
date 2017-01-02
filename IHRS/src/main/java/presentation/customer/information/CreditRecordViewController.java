package presentation.customer.information;

import controller.CustomerController;
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
	}

	private void showCreditChanges() {
		creditChangeListView.setItems(creditChangeVOs);
		creditChangeListView.setCellFactory((ListView<CreditChangeVO> i) -> new CreditCell());
	}
	
	public void setController(CustomerController controller) {
		creditChangeVOs.addAll(controller.getCreditChanges());
		creditLabel.setText(controller.getCredit()+"");
		showCreditChanges();
	}
}
