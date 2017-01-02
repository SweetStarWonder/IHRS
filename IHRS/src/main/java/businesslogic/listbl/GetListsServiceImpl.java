package businesslogic.listbl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;

import businesslogicservice.listblservice.GetListsService;
import data.dao.ListDao;
import po.ListPO;
import po.ListStatus;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.HotelVO;
import vo.ListVO;

public class GetListsServiceImpl implements GetListsService{
	
	private ListDao listDao;
	
	public GetListsServiceImpl(){
		listDao=RemoteHelper.getInstance().getListDao();
	}

	public HashMap<Integer, ListVO> getHotelLists(int hotelId) {
		HashMap<Integer,ListVO> listMap=new HashMap<Integer, ListVO>();
		try {
			HashMap<Integer,ListPO> lists=listDao.getListsByHotel(hotelId);
			Iterator<Integer> iterator=lists.keySet().iterator();
			while(iterator.hasNext()){
				Integer listId=(Integer)iterator.next();
				listMap.put(listId,new ListVO(lists.get(listId)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return listMap;
	}

	public HashMap<Integer, ListVO> getPersonalListsInHotel(CustomerVO customerVO, HotelVO hotelVO) {
		HashMap<Integer,ListVO> listMap=new HashMap<Integer, ListVO>();
		HashMap<Integer,ListVO> allHotelLists=getHotelLists(hotelVO.getId());
		Iterator<Integer> iterator=allHotelLists.keySet().iterator();
		while(iterator.hasNext()){
			Integer listId=(Integer)iterator.next();
			if(allHotelLists.get(listId).getUserId()==customerVO.getId()){
				listMap.put(listId,allHotelLists.get(listId));
			}
		}
		return listMap;
	}

	public HashMap<Integer, ListVO> getDailyUnexecutedLists(String timeNow) {
		HashMap<Integer,ListVO> listMap=new HashMap<Integer, ListVO>();
		try {
			HashMap<Integer,ListPO> allLists=listDao.getAllLists();
			Iterator<Integer> iterator=allLists.keySet().iterator();
			while(iterator.hasNext()){
				Integer listId=(Integer)iterator.next();
				if(allLists.get(listId).getStatus().equals(ListStatus.NOTEXECUTED)  && allLists.get(listId).getLastListExecutedTime().startsWith(timeNow)){
					listMap.put(listId,new ListVO(allLists.get(listId)));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return listMap;
	}

	@Override
	public HashMap<Integer, ListVO> getAbnormalLists() {
		HashMap<Integer, ListVO> listMap = new HashMap<Integer,ListVO>();
		try {
			HashMap<Integer, ListPO> allLists = listDao.getAllLists();
			allLists = listDao.getAllLists();
			Iterator<Integer> iterator=allLists.keySet().iterator();
			while(iterator.hasNext()){
				Integer listId=(Integer)iterator.next();
				if(allLists.get(listId).getStatus().equals(ListStatus.ABNORMAL)){
					listMap.put(listId,new ListVO(allLists.get(listId)));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return listMap;
	}

}
