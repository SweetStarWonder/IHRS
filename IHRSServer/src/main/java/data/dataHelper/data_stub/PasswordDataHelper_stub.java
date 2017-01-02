package data.dataHelper.data_stub;

import java.util.HashMap;

import data.dataHelper.PasswordDataHelper;
import po.PasswordPO;

public class PasswordDataHelper_stub implements PasswordDataHelper{

	@Override
	public HashMap<Integer, PasswordPO> getPasswordById() {
		// TODO Auto-generated method stub
		HashMap<Integer, PasswordPO> hashMap = new HashMap<>();
		PasswordPO passwordPO = new PasswordPO(00001, "customerName", "password", "userType");
		hashMap.put(00001, passwordPO);
		return hashMap;
	}

	@Override
	public HashMap<String, PasswordPO> getPasswordByName() {
		// TODO Auto-generated method stub
		HashMap<String, PasswordPO> hashMap = new HashMap<>();
		PasswordPO passwordPO = new PasswordPO(00001, "customerName", "password", "userType");
		hashMap.put("customerName", passwordPO);
		return hashMap;
	}

	@Override
	public void updatePasswordById(HashMap<Integer, PasswordPO> passwordMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePasswordByName(HashMap<String, PasswordPO> passwordMap) {
		// TODO Auto-generated method stub
		
	}

}
