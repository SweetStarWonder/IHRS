package presentation.webSale.promotion;

import java.io.IOException;

import org.controlsfx.control.PopOver;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import presentation.webSale.TestWebSale;
import vo.promotionVO.NormalVipPromotionVO;
import vo.promotionVO.PromotionVO;
import vo.promotionVO.WebPromotionVO;

public class WebPromotionListController {
	
	
	@FXML
	private ListView<PromotionVO> promotioinListView;
	
	private TestWebSale mainApp;
	 
	private ObservableList<PromotionVO> promotionList;
	
	public WebPromotionListController() {
		
	}
	
	@FXML
	private void initialize() {
		promotionList = FXCollections.observableArrayList();
		promotionList.add(null);
		for (int i = 0; i < 10; i++) {
			if (i % 3 == 1) {
				promotionList.add(new WebPromotionVO(0.0, "0", "0", "0"));				
			}
			promotionList.add(new NormalVipPromotionVO(0, null, 0, null));	
		}
		
		promotioinListView.setItems(promotionList);
		promotioinListView.setCellFactory((ListView<PromotionVO> e) -> new PromotionCell(this));
	}
	
	public void showTypeChoosePane(Label label) {
		promotioinListView.getSelectionModel().select(-1);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebPromotionListController.class.getResource("TypeChoosePane.fxml"));
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
	
	public void setMainApp(TestWebSale mainApp) {
		this.mainApp = mainApp;
	}
	
}
