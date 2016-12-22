package po;

/**
 * id              网站管理人员编号
 * webManagerName  网站管理人员名
 * phone           手机号
 */
public class WebManagerPO extends UserPO{

	private static final long serialVersionUID = -2535853446386625523L;

	
	public WebManagerPO(int id,String webManagerName,String phone){
		super(id, webManagerName, phone);
	}
	
	@Override
	public boolean equals(Object o) {
		WebManagerPO webManagerPO = (WebManagerPO) o;
		return (webManagerPO.getId() == getId());
    }
}
