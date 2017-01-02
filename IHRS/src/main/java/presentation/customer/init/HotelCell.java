package presentation.customer.init;

import java.io.IOException;

import org.controlsfx.control.GridCell;

import controller.CustomerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import vo.HotelVO;

public class HotelCell extends GridCell<HotelVO> {
	private CustomerController mainApp;

	public HotelCell(CustomerController testCustomer) {
		super();
		this.mainApp = testCustomer;
	}

	@Override
	public void updateItem(HotelVO item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null) {
			setGraphic(null);
		} else {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HotelCell.class.getResource("HotelInformationCell.fxml"));
			AnchorPane anchorPane = null;
			try {
				anchorPane = (AnchorPane) loader.load();
				HotelCellController controller = loader.getController();
				controller.setMainApp(mainApp);
				controller.setHotel(item);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setGraphic(anchorPane);

		}
		// Rating rating = new Rating();
		// anchorPane.getChildren().add(rating);
		// anchorPane.setLeftAnchor(rating, (double) 12);
		// anchorPane.setTopAnchor(rating, 62.0);
		// anchorPane.setRightAnchor(rating, 73.0);

	}
}
