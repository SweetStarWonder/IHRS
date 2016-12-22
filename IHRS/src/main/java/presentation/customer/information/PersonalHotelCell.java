package presentation.customer.information;

import java.io.IOException;

import org.controlsfx.control.GridCell;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presentation.customer.TestCustomer;
import vo.HotelVO;

public class PersonalHotelCell extends GridCell<HotelVO> {
	
	private TestCustomer mainApp;
	
	public PersonalHotelCell(TestCustomer mainApp) {
		super();
		this.mainApp = mainApp;
	}
	
	@Override
	public void updateItem(HotelVO item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null) {
			setGraphic(null);
		} else {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PersonalHotelCell.class.getResource("PresonalHotelInformationCell.fxml"));
			AnchorPane anchorPane = null;
			try {
				anchorPane = (AnchorPane) loader.load();
				PersonalHotelCellController controller = loader.getController();
				controller.setMainApp(mainApp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			setGraphic(anchorPane);
			
		}

	}
}
