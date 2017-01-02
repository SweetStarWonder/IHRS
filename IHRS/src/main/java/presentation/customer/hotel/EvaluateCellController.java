package presentation.customer.hotel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import vo.EvaluateVO;

public class EvaluateCellController {
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private Label rankLabel;
	
	@FXML
	private TextArea contentTextArea;
	
	public EvaluateCellController() {
		
	}
	
	public void setEvaluate(EvaluateVO evaluateVO) {
		nameLabel.setText(evaluateVO.getCustomerName());
		rankLabel.setText(evaluateVO.getRankValue()+"分");
		contentTextArea.setText(evaluateVO.getContents());
	}
}
