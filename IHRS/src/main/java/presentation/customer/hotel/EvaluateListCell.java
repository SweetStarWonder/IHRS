package presentation.customer.hotel;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import presentation.customer.init.HotelCell;
import vo.EvaluateVO;

public class EvaluateListCell extends ListCell<EvaluateVO> {
	@Override
	public void updateItem(EvaluateVO item, boolean empty) {
		super.updateItem(item, empty);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelCell.class.getResource("EvaluateCell.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setGraphic(anchorPane);

	}
}
