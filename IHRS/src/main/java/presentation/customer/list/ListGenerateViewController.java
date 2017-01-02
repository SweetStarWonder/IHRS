package presentation.customer.list;

import java.util.ArrayList;
import java.util.HashMap;

import org.controlsfx.control.CheckComboBox;

import controller.CustomerController;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import po.ListStatus;
import po.RoomStatus;
import utility.TimeUtility;
import utility.VerifyUtility;
import vo.HotelVO;
import vo.ListVO;
import vo.RoomVO;

public class ListGenerateViewController {

	@FXML
	private DatePicker beginTimeDatePicker;

	@FXML
	private TextField beginTimeHourTextField;

	@FXML
	private TextField beginTimeMinuteTextField;

	@FXML
	private DatePicker endTimeDatePicker;

	@FXML
	private TextField endTimeHourTextField;

	@FXML
	private TextField endTimeMinuteTextField;

	@FXML
	private DatePicker lastExTimeDatePicker;

	@FXML
	private TextField lastExTimeHourTextField;

	@FXML
	private TextField lastExTimeMinuteTextField;

	@FXML
	private HBox roomChooseHBox;

	@FXML
	private Label singleNumLabel;

	@FXML
	private Label singlePriceLabel;

	@FXML
	private Label doubleNumLabel;

	@FXML
	private Label doublePriceLabel;

	@FXML
	private Label tripleNumLabel;

	@FXML
	private Label triplePriceLabel;

	@FXML
	private Label personNumLabel;

	@FXML
	private RadioButton haveChildRadioButton;

	@FXML
	private RadioButton noChildRadioButton;
	
	@FXML
	private Button confirmButton;

	private CheckComboBox<String> roomChooseComboBox;

	private ObservableList<String> rooms;
	
	private HashMap<Integer, RoomVO> roomMap;
	
	private HotelVO hotelVO;
	
	private ArrayList<RoomVO> roomVOs = new ArrayList<>();
	
	private CustomerController controller;
	
	private int singleNum = 0;
	private int doubleNum = 0;
	private int tripleNum = 0;
	private int singlePrice = 0;
	private int doublePrice = 0;
	private int triplePrice = 0;
	private int totalNum = 0;

	public ListGenerateViewController() {
		
	}

	@FXML
	private void initialize() {
		singleNumLabel.setText("0");
		doubleNumLabel.setText("0");
		tripleNumLabel.setText("0");
		singlePriceLabel.setText("0");
		doublePriceLabel.setText("0");
		triplePriceLabel.setText("0");
		personNumLabel.setText("0");
		rooms = FXCollections.observableArrayList();
		roomMap = new HashMap<Integer, RoomVO>();
	
		roomChooseComboBox = new CheckComboBox<>(rooms);
		roomChooseHBox.getChildren().add(roomChooseComboBox);
		
		roomChooseComboBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<String>() {
		     public void onChanged(ListChangeListener.Change<? extends String> c) {
		        ObservableList<String> rooms = roomChooseComboBox.getCheckModel().getCheckedItems();
		        refresh();
		        roomVOs.clear();
		        for (String string : rooms) {
					int roomNum = Integer.valueOf(string.split(" ")[0]);
					RoomVO roomVO = roomMap.get(roomNum);
					roomVOs.add(roomVO);
					if (roomVO.getStatus().equals(RoomStatus.SINGLE)) {
						singleNum++;
						totalNum += 1;
						singlePrice += roomVO.getPrice();
					} else if (roomVO.getStatus().equals(RoomStatus.DOUBLE)) {
						doubleNum++;
						totalNum += 2;
						doublePrice += roomVO.getPrice();
					} else if (roomVO.getStatus().equals(RoomStatus.TRIPLE)) {
						tripleNum++;
						totalNum += 3;
						triplePrice += roomVO.getPrice();
					}
				}
		        singleNumLabel.setText(singleNum+"间");
				doubleNumLabel.setText(doubleNum+"间");
				tripleNumLabel.setText(tripleNum+"间");
				singlePriceLabel.setText(singlePrice+"元");
				doublePriceLabel.setText(doublePrice+"元");
				triplePriceLabel.setText(triplePrice+"元");
				personNumLabel.setText(totalNum + "人");
		     }
		 });
	}

	@FXML
	private void handleConfirmButton() {
		String beginDate = beginTimeDatePicker.getValue().toString();
		String beginHour = beginTimeHourTextField.getText();
		String beginMinute = beginTimeMinuteTextField.getText();
		String endDate = endTimeDatePicker.getValue().toString();
		String endHour = endTimeHourTextField.getText();
		String endMinute = endTimeMinuteTextField.getText();
		String lastDate = lastExTimeDatePicker.getValue().toString();
		String lastHour = lastExTimeHourTextField.getText();
		String lastMinute = lastExTimeMinuteTextField.getText();
		boolean hasChild = haveChildRadioButton.isSelected();
		if (beginDate==null || beginHour==null || beginMinute==null || endDate==null || endHour==null
				|| endMinute==null || lastDate==null || lastHour==null || lastMinute==null
				|| beginDate.isEmpty() || beginHour.isEmpty() || beginMinute.isEmpty() || endDate.isEmpty() || endHour.isEmpty()
				|| endMinute.isEmpty() || lastDate.isEmpty() || lastHour.isEmpty() || lastMinute.isEmpty()) {
			VerifyUtility.showWarning("信息不完整", "请填写完整时间信息");
		} else if (roomVOs.isEmpty()) {
			VerifyUtility.showWarning("未选择房间", "选择的房间为0间");
		} else {
			int price = controller.generateList(new ListVO(0, hotelVO.getId(), controller.getSelf().getId(), ListStatus.NOTEXECUTED, beginDate.substring(0, 4) + "/" + beginDate.substring(5, 7) + "/" + beginDate.substring(8) + " " + beginHour+":"+beginMinute+":"+"00", 
					endDate.substring(0, 4) + "/" + endDate.substring(5, 7) + "/" + endDate.substring(8) + " " + endHour+":"+endMinute+":"+"00", 
					lastDate.substring(0, 4) + "/" + lastDate.substring(5, 7) + "/" + lastDate.substring(8) + " " + lastHour+":"+lastMinute+":"+"00", singlePrice+doublePrice+triplePrice, hasChild, roomVOs), TimeUtility.getTimeStr());
			if (price>=0) {
				VerifyUtility.showSuccessMessage("下单成功", "订单价格共" + price + "元");
				controller.backView();
			} else {
				VerifyUtility.showWarning("下单失败", "信用小于0");
			}
		}
	}
	
	public void setHotel(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
		for (RoomVO roomVO : hotelVO.getRooms()) {
			if (roomVO.getListId()==0) {				
				roomMap.put(roomVO.getRoomNum(), roomVO);
				String type = "";
				if (roomVO.getStatus().equals(RoomStatus.SINGLE)) {
					type = "单人间";
				} else if (roomVO.getStatus().equals(RoomStatus.DOUBLE)) {
					type = "双人间";
				} else if (roomVO.getStatus().equals(RoomStatus.TRIPLE)) {
					type = "三人间";
				}
				rooms.add(roomVO.getRoomNum() + "  " + type);
			}
		}
		
		
		
	}
	
	private void refresh() {
		singleNum = 0;
		doubleNum = 0;
		tripleNum = 0;
		singlePrice = 0;
		doublePrice = 0;
		triplePrice = 0;
		totalNum = 0;
	}
	
	public void setController(CustomerController controller) {
		this.controller = controller;
	}
}
