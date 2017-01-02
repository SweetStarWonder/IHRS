package presentation.customer.init;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class CustomerRootLayoutController {

	@FXML
	private Button backButton;
	
	@FXML
	private MenuButton nameMenuButton;

	@FXML
	private MenuItem personalInformationItem;

	@FXML
	private MenuItem creditRecordItem;

	@FXML
	private MenuItem registerNormalVipItem;

	@FXML
	private MenuItem registerEnterpriseVipItem;

	@FXML
	private MenuItem modifyPasswordItem;

	@FXML
	private MenuItem signOutItem;

	@FXML
	private MenuItem personalListItem;

	@FXML
	private MenuItem personalHotelItem;

	@FXML
	private CustomerController testCustomer;

	public CustomerRootLayoutController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleBackButton() {
		testCustomer.backView();
	}

	@FXML
	private void showPersonalLists() {
		testCustomer.showPersonalLists();
	}

	@FXML
	private void showPersonalInformation() {
		testCustomer.showPersonalInformation();
	}

	@FXML
	private void showCreditRecord() {
		testCustomer.showCreditRecord();
	}

	@FXML
	private void registerNormalVip() {
		testCustomer.registerNormalVip();
	}

	@FXML
	private void registerEnterpriseVip() {
		testCustomer.registerEnterpriseVip();
	}

	@FXML
	private void showPersonalHotels() {
		testCustomer.showPersonalHotels();
	}

	@FXML
	private void handleModifyPasswordItem() {

	}

	@FXML
	private void handleSignoutItem() {
		testCustomer.signout();
	}

	public void setMainApp(CustomerController testCustomer) {
		this.testCustomer = testCustomer;
		nameMenuButton.setText(testCustomer.getSelf().getUserName());
	}
}
