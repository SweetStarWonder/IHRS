package data.dataHelper.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import data.dataHelper.PasswordDataHelper;
import po.PasswordPO;

public class PasswordDataTxtHelper implements PasswordDataHelper{

	public HashMap<Integer,PasswordPO> getPasswordById(){
		File file = new File("src//main//resources//Password.txt");
		HashMap<Integer,PasswordPO> passwordPOs=new HashMap<Integer,PasswordPO>();
		//自定义密钥
		DesUtils des = new DesUtils("sswzdhsa");
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str!=null;){
				int userid = Integer.valueOf(br.readLine().substring(1));
				String username = br.readLine().substring(1);
				String password = br.readLine().substring(1);
				//解密
				password=des.decrypt(password);
				String usertype = br.readLine().substring(1);
				PasswordPO  passwordPO = new PasswordPO(userid,username,password,usertype);
				passwordPOs.put(userid, passwordPO);
				str = br.readLine();
			}
			br.close();
			return passwordPOs;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public HashMap<String,PasswordPO> getPasswordByName(){
		File file = new File("src//main//resources//Password.txt");
		HashMap<String,PasswordPO> passwordPOs=new HashMap<String,PasswordPO>();
		//自定义密钥
		DesUtils des = new DesUtils("sswzdhsa");
		try{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(
					file), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			for(String str = br.readLine();str!=null;){
				int userid = Integer.valueOf(br.readLine().substring(1));
				String username = br.readLine().substring(1);
				String password = br.readLine().substring(1);
				//解密
				password=des.decrypt(password);
				String usertype = br.readLine().substring(1);
				PasswordPO  passwordPO = new PasswordPO(userid,username,password,usertype);
				passwordPOs.put(username, passwordPO);
				str = br.readLine();
			}
			br.close();
			return passwordPOs;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void updatePasswordById(HashMap<Integer,PasswordPO> passwordMap){
		File file = new File("src//main//resources//Password.txt");
		//自定义密钥
		DesUtils des = new DesUtils("sswzdhsa");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Entry<Integer, PasswordPO>> iterator = passwordMap.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<Integer, PasswordPO> entry = iterator.next();
				PasswordPO PasswordPO = entry.getValue();
				int userid = PasswordPO.getUserId();
				String username = PasswordPO.getUserName();
				String password = PasswordPO.getPassword();
				//加密
				password=des.encrypt(password);
				String usertype = PasswordPO.getUserType();
				writer.write("<Password>\r\n#" + userid + "\r\n#" + username + "\r\n#" + password + "\r\n#" + usertype);
				writer.write("\r\n");
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updatePasswordByName(HashMap<String,PasswordPO> passwordMap){
		File file = new File("src//main//resources//Password.txt");
		//自定义密钥
		DesUtils des = new DesUtils("sswzdhsa");
		try {		
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			
			//对map进行遍历
			Iterator<Entry<String, PasswordPO>> iterator = passwordMap.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String, PasswordPO> entry = iterator.next();
				PasswordPO PasswordPO = entry.getValue();
				int userid = PasswordPO.getUserId();
				String username = PasswordPO.getUserName();
				String password = PasswordPO.getPassword();
				//加密
				password=des.encrypt(password);
				String usertype = PasswordPO.getUserType();
				writer.write("<Password>\r\n#" + userid + "\r\n#" + username + "\r\n#" + password + "\r\n#" + usertype);
				writer.write("\r\n");
			}
			writer.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
