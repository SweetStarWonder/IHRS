package presentation.hotelManager.promotion;

import java.io.IOException;

import org.controlsfx.control.PopOver;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import po.promotionPO.HotelPromotionType;
import presentation.hotelManager.TestHotelManager;
import vo.promotionVO.HotelPromotionVO;

public class HotelPromotionListController {
	
	
	@FXML
	private ListView<HotelPromotionVO> promotioinListView;
	
	private TestHotelManager mainApp;
	 
	private ObservableList<HotelPromotionVO> promotionList;
	
	public HotelPromotionListController() {
		
	}
	
	@FXML
	private void initialize() {
		promotionList = FXCollections.observableArrayList();
		promotionList.add(new HotelPromotionVO(0, "", 0, null,null,null));
		for (int i = 0; i < 100; i++) {
			if (i % 3 == 1) {
				promotionList.add(new HotelPromotionVO(0.0, "0", 0, HotelPromotionType.DOUBLE11,null,null));				
			}
			promotionList.add(new HotelPromotionVO(0.0, "0", 0, HotelPromotionType.BIRTHDAY,null,null));	
		}
		
		promotioinListView.setItems(promotionList);
		promotioinListView.setCellFactory((ListView<HotelPromotionVO> e) -> new PromotionCell(this));
	}
	
	public void showTypeChoosePane(Label label) {
		promotioinListView.getSelectionModel().select(-1);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelPromotionListController.class.getResource("TypeChoosePane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
			TypeChoosePaneController controller = loader.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PopOver popOver = new PopOver(anchorPane);
		popOver.show(label);
	}
	
	public void setMainApp(TestHotelManager mainApp) {
		this.mainApp = mainApp;
	}
	
}
