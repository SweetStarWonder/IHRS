package data.dataHelper;

import java.util.ArrayList;
import java.util.HashMap;

public interface AddressDataHelper {
	
	/**
	 * @return  左商圈，右地址
	 */
	public HashMap<String,ArrayList<String>> getAddresses();

}
