package presentation.customer.information;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import vo.ListVO;

public class ListViewCell extends ListCell<ListVO>{
	@Override
	public void updateItem(ListVO item, boolean empty) {
		super.updateItem(item, empty);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CreditCell.class.getResource("ListSimpleCell.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setGraphic(anchorPane);
	}
}
