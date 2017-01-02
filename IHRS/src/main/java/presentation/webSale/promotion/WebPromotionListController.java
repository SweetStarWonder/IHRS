package presentation.webSale.promotion;

import java.io.IOException;

import org.controlsfx.control.PopOver;

import controller.WebSaleController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import utility.VerifyUtility;
import vo.promotionVO.NormalVipPromotionVO;
import vo.promotionVO.PromotionVO;
import vo.promotionVO.WebPromotionVO;

public class WebPromotionListController {

	@FXML
	private ListView<PromotionVO> promotioinListView;

	private WebSaleController mainApp;

	private ObservableList<PromotionVO> promotionList;

	public WebPromotionListController() {

	}

	@FXML
	private void initialize() {
		promotionList = FXCollections.observableArrayList();
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
			controller.setUpperController(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

		PopOver popOver = new PopOver(anchorPane);
		popOver.show(label);
	}

	public void deletePromotion(PromotionVO promotionVO) {
		boolean delete = mainApp.deletePromotion(promotionVO);
		if (delete) {
			promotionList.remove(promotionVO);
			VerifyUtility.showSuccessMessage("删除成功", "已成功删除优惠" + promotionVO.getDiscountName());
		} else {
			VerifyUtility.showWarning("删除失败", "请检查网络连接");
		}
	}

	public void addPromotion(PromotionVO promotionVO) {
		promotionList.add(promotionVO);
	}

	public void setMainApp(WebSaleController mainApp) {
		this.mainApp = mainApp;
		promotionList.add(null);
		promotionList.addAll(mainApp.getPromotions());
	}

}
