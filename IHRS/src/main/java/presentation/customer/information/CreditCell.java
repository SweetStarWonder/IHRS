package presentation.customer.information;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import vo.CreditChangeVO;

public class CreditCell extends ListCell<CreditChangeVO> {
	@Override
	public void updateItem(CreditChangeVO item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null) {
			setGraphic(null);
		} else {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(CreditCell.class.getResource("CreditChangeCell.fxml"));
			AnchorPane anchorPane = null;
			try {
				anchorPane = loader.load();
				CreditChangeCellController controller = loader.getController();
				controller.setCreditChange(item);
			} catch (IOException e) {
				e.printStackTrace();
			}

			setGraphic(anchorPane);
		}
	}
}
