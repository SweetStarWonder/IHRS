package controller;

import presentation.login.LoginView;

public interface LoginController {

	public void login(int userId, String userName, String passWord);

	public boolean register(String customerName, String password, String phone);

	public void setView(LoginView view);

	public void signOut();
}
