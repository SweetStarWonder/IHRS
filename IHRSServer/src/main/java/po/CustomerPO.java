package po;

import java.io.Serializable;

/**
 * id            客户编号
 * customerName  客户名
 * phone         客户手机号
 */
public class CustomerPO extends UserPO implements Serializable{
	
	private static final long serialVersionUID = -8622867943280098971L;

	
	public CustomerPO(int id,String customerName,String phone){
		super(id,customerName,phone);
	}

	@Override
	public boolean equals(Object o) {
		CustomerPO customerPO = (CustomerPO) o;
		return (customerPO.getId() == getId());
    }
}
