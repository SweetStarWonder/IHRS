package data.dao;

import java.rmi.RemoteException;

import po.PasswordPO;

public interface PasswordDao extends java.rmi.Remote{
	
	/**
	 * @param userId  用户编号
	 * @return        密码信息
	 * @throws RemoteException
	 */
	public PasswordPO getPasswordById(int userId) throws RemoteException;
	
	/**
	 * @param userName  用户名
	 * @return          密码信息
	 * @throws RemoteException
	 */
	public PasswordPO getPasswordByName(String userName) throws RemoteException;
	
	/**
	 * @param passwordPO  密码信息
	 * @return            是否添加成功
	 * @throws RemoteException
	 */
	public boolean addPassword(PasswordPO passwordPO) throws RemoteException;
	
	/**
	 * @param passwordPO  密码信息
	 * @return            是否修改成功
	 * @throws RemoteException
	 */
	public boolean updatePassword(PasswordPO passwordPO) throws RemoteException;
	
	/**
	 * @param userId    用户编号
	 * @param userName  用户名
	 * @return          用户名是否修改成功
	 * @throws RemoteException
	 */
	public boolean updateName(int userId,String userName) throws RemoteException;
	
}
