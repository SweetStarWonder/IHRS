package presentation.customer.information;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import po.CreditChangeMove;
import utility.ConvertUtility;
import utility.VerifyUtility;
import vo.CreditChangeVO;

public class CreditChangeCellController {

	
	@FXML
	private Label moveLabel;
	
	@FXML
	private Label changeLabel;
	
	@FXML
	private Label listIdLabel;
	
	@FXML
	private Label timeLabel;
	
	@FXML
	private Label resultLabel;
	
	public CreditChangeCellController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	private void initialize() {
		
	}
	
	public void setCreditChange(CreditChangeVO creditChangeVO) {
		moveLabel.setText(ConvertUtility.creditChangeToStr(creditChangeVO.getCreditChangeMove()));
		changeLabel.setText(creditChangeVO.getChange()>0?"+"+creditChangeVO.getChange():creditChangeVO.getChange()+"");
		listIdLabel.setText(VerifyUtility.isInteger(creditChangeVO.getListId()) ? creditChangeVO.getListId() : "无");
		timeLabel.setText(creditChangeVO.getTime());
		resultLabel.setText(creditChangeVO.getResult()+"");
	}
}
