package presentation.hotelManager.promotion;

import java.io.IOException;

import org.controlsfx.control.PopOver;

import controller.HotelManagerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import po.promotionPO.HotelPromotionType;
import utility.VerifyUtility;
import vo.promotionVO.HotelPromotionVO;

public class HotelPromotionListController {

	@FXML
	private ListView<HotelPromotionVO> promotioinListView;

	private HotelManagerController mainApp;

	private ObservableList<HotelPromotionVO> promotionList;

	public HotelPromotionListController() {

	}

	@FXML
	private void initialize() {
		promotionList = FXCollections.observableArrayList();

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
			controller.setUpperController(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

		PopOver popOver = new PopOver(anchorPane);
		popOver.show(label);
	}

	public void delete(HotelPromotionVO promotionVO) {
		boolean delete = mainApp.deletePromotion(promotionVO);
		if (delete) {
			promotionList.remove(promotionVO);
			VerifyUtility.showSuccessMessage("删除成功", "成功删除促销策略" + promotionVO.getDiscountName());
		} else {
			VerifyUtility.showWarning("删除失败", "请检查网络连接");
		}
	}

	public void addPromotioin(HotelPromotionVO promotionVO) {
		promotionList.add(promotionVO);
	}

	public void setMainApp(HotelManagerController mainApp) {
		this.mainApp = mainApp;
		promotionList.add(new HotelPromotionVO(0, null, 0, null, null, null));
		promotionList.addAll(mainApp.getPromotions());
		promotioinListView.setItems(promotionList);
	}

}
