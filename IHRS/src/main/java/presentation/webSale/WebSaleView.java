package presentation.webSale;

import java.io.IOException;

import controller.WebSaleController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.webSale.init.WebSaleMenuPaneController;
import presentation.webSale.init.WebSaleRootLayoutController;
import presentation.webSale.list.ListViewController;
import presentation.webSale.list.RevokeSelectPaneController;
import presentation.webSale.promotion.AddNormalVipPromotionDialogController;
import presentation.webSale.promotion.AddTimePromotionDialogController;
import presentation.webSale.promotion.WebPromotionListController;
import presentation.webSale.rank.RankPaneController;
import presentation.webSale.recharge.CreditRechargePaneController;
import presentation.webSale.recharge.RechargeMoneyPaneController;
import vo.CustomerVO;
import vo.ListVO;

public class WebSaleView extends Application {

	ObservableList<Node> sceneStack = FXCollections.observableArrayList();

	private Stage primaryStage;

	private BorderPane rootLayout;

	private WebSaleController controller;

	public WebSaleView(WebSaleController controller) {
		this.controller = controller;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		initRoot();
		showMenuPane();
	}

	public void initRoot() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleView.class.getResource("init/WebSaleRootLayout.fxml"));
		try {
			rootLayout = (BorderPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		WebSaleRootLayoutController controller = loader.getController();
		controller.setMainApp(this.controller);
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void showMenuPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleView.class.getResource("init/WebSaleMenuPane.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			WebSaleMenuPaneController controller = loader.getController();
			controller.setMainApp(this.controller);
			sceneStack.add(anchorPane);
			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showRankGrade() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleView.class.getResource("rank/RankPane.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			RankPaneController controller = loader.getController();
			controller.setController(this.controller);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showPromotion() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleView.class.getResource("promotion/WebPromotionListView.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			WebPromotionListController controller = loader.getController();
			controller.setMainApp(this.controller);
			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addTimePromotionPane(WebPromotionListController upperController) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleView.class.getResource("promotion/AddTimePromotionDialog.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stage dialogStage = new Stage();
		dialogStage.initStyle(StageStyle.TRANSPARENT);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(primaryStage);
		Scene scene = new Scene(anchorPane);
		dialogStage.setScene(scene);

		AddTimePromotionDialogController controller = loader.getController();
		controller.setStage(dialogStage);
		controller.setController(this.controller);
		controller.setUpperController(upperController);

		dialogStage.showAndWait();
	}

	public void addNormalVipPromotionPane(WebPromotionListController upperController) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleView.class.getResource("promotion/AddNormalVipPromotionDialog.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stage dialogStage = new Stage();
		dialogStage.initStyle(StageStyle.TRANSPARENT);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(primaryStage);
		Scene scene = new Scene(anchorPane);
		dialogStage.setScene(scene);

		AddNormalVipPromotionDialogController controller = loader.getController();
		controller.setStage(dialogStage);
		controller.setController(this.controller);
		controller.setUpperController(upperController);

		dialogStage.showAndWait();
	}

	public void showList() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleView.class.getResource("list/ListView.fxml"));
		SplitPane splitPane;
		try {
			splitPane = (SplitPane) loader.load();
			changeView(splitPane);

			ListViewController controller = loader.getController();
			controller.setMainApp(this.controller);

			rootLayout.setCenter(splitPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void selectRevoke(ListVO listVO, ListViewController upperController) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleView.class.getResource("list/RevokeSelectPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stage dialogStage = new Stage();
		dialogStage.initStyle(StageStyle.TRANSPARENT);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(primaryStage);
		Scene scene = new Scene(anchorPane);
		dialogStage.setScene(scene);

		RevokeSelectPaneController controller = loader.getController();
		controller.setController(this.controller);
		controller.setList(listVO);
		controller.setUpperController(upperController);
		controller.setStage(dialogStage);

		dialogStage.showAndWait();
	}

	public void showRechargePane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleView.class.getResource("recharge/CreditRechargePane.fxml"));
		AnchorPane anchorPane;
		try {
			anchorPane = (AnchorPane) loader.load();
			changeView(anchorPane);

			CreditRechargePaneController controller = loader.getController();
			controller.setMainApp(this.controller);

			rootLayout.setCenter(anchorPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void inputMoneyDialog(CustomerVO customerVO) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleView.class.getResource("recharge/RechargeMoneyPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stage dialogStage = new Stage();
		dialogStage.initStyle(StageStyle.TRANSPARENT);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(primaryStage);
		Scene scene = new Scene(anchorPane);
		dialogStage.setScene(scene);

		RechargeMoneyPaneController controller = loader.getController();
		controller.setStage(dialogStage);
		controller.setCustomer(customerVO);
		controller.setController(this.controller);

		dialogStage.showAndWait();
	}

	public void changeView(Node node) {
		sceneStack.add(node);
	}

	public void backView() {
		if (sceneStack.size() > 1) {
			int size = sceneStack.size();
			sceneStack.remove(size - 1);
			rootLayout.setCenter(sceneStack.get(size - 2));
		}
	}
}
