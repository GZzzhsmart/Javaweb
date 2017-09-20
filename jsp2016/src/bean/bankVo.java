package bean;

import java.io.Serializable;

public class bankVo implements Serializable{

	private int bankId;
	private String bankName;
	public int getbankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
