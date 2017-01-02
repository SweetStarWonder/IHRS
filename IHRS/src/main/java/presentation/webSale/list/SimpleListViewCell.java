package presentation.webSale.list;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import vo.ListVO;

public class SimpleListViewCell extends ListCell<ListVO> {

	private ListViewController upperController;

	public SimpleListViewCell(ListViewController upperController) {
		super();
		this.upperController = upperController;
	}

	@Override
	public void updateItem(ListVO item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null) {
			setGraphic(null);
		} else {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SimpleListViewCell.class.getResource("ListSimpleCell.fxml"));
			AnchorPane anchorPane = null;
			try {
				anchorPane = loader.load();

				ListSimpleCellController controller = loader.getController();
				controller.setList(item);
				controller.setUpperController(upperController);
			} catch (IOException e) {
				e.printStackTrace();
			}

			setGraphic(anchorPane);
		}
	}

}
