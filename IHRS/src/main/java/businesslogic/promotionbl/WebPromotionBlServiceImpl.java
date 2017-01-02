package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.promotionblservice.WebPromotionBlService;
import data.dao.WebPromotionDao;
import po.promotionPO.WebPromotionPO;
import rmi.RemoteHelper;
import vo.promotionVO.WebPromotionVO;

public class WebPromotionBlServiceImpl implements WebPromotionBlService{
	
	private WebPromotionDao webPromotionDao;
	
	public WebPromotionBlServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		this.webPromotionDao=remoteHelper.getWebPromotionDao();
	}

	public ArrayList<WebPromotionVO> getWebPromotions() {
		ArrayList<WebPromotionPO> webPromotionPOs;
		ArrayList<WebPromotionVO> webPromotionVOs=new ArrayList<WebPromotionVO>();
		try {
			webPromotionPOs = webPromotionDao.getWebPromotions();
			for (WebPromotionPO webPromotionPO : webPromotionPOs) {
				webPromotionVOs.add(new WebPromotionVO(webPromotionPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return webPromotionVOs;
	}
	
	public boolean addWebPromotion(WebPromotionVO webPromotionVO) {
		boolean add=false;
		try {
			add=webPromotionDao.addWebPromotion(new WebPromotionPO(webPromotionVO.getDiscount(), webPromotionVO.getDiscountName(), 
					webPromotionVO.getStartTime(), webPromotionVO.getEndTime()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return add;
	}

	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO) {
		boolean delete=false;
		try {
			delete=webPromotionDao.deleteWebPromotion(new WebPromotionPO(webPromotionVO.getDiscount(), webPromotionVO.getDiscountName(),
					webPromotionVO.getStartTime() , webPromotionVO.getEndTime()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return delete;
	}

	public double getMinDiscountInWeb(String timeNow) {
		ArrayList<WebPromotionVO> webPromotionVOs=getWebPromotions();
		ArrayList<WebPromotionVO> webPromotions=new ArrayList<WebPromotionVO>();
		double minDiscount=1.0;
		
		for (WebPromotionVO webPromotionVO : webPromotionVOs) {
			
				if(webPromotionVO.getStartTime() != null){
				int nowTime=convertTime(timeNow);
				System.out.println(nowTime);
				System.out.println(webPromotionVO.getStartTime());
				int startTime=convertTime(webPromotionVO.getStartTime());
				System.out.println(startTime);
				int endTime=convertTime(webPromotionVO.getEndTime());
				System.out.println(endTime);
				if(nowTime>=startTime || nowTime<=endTime){
					webPromotions.add(webPromotionVO);
			}
		}
	}
		
		for(WebPromotionVO webPromotionVO : webPromotions){
			double tmpDiscount=webPromotionVO.getDiscount();
			if(tmpDiscount<=minDiscount){
				minDiscount=tmpDiscount;
			}
		}
		return minDiscount;
	}

	private int convertTime(String time) {
		String timeNow = time.substring(0, 4) + time.substring(5, 7) + time.substring(8, 10);
		int intTime = Integer.valueOf(timeNow);
		return intTime;
	}

}
