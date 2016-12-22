package po;

/**
 * id              网站营销人员编号
 * webManagerName  网站营销人员名
 * phone           手机号
 */
public class WebSalePO extends UserPO{

	private static final long serialVersionUID = -6795655559899303704L;

	
	public WebSalePO(int id,String webSaleName,String phone){
		super(id, webSaleName, phone);
	}
	
	@Override
	public boolean equals(Object o) {
		WebSalePO webSalePO = (WebSalePO) o;
		return (webSalePO.getId() == getId());
    }
}
