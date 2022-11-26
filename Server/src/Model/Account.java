package Model;

public class Account {
	private String nameAccount;
	private String password;
	private String gmail;
	
	

	public Account(String nameAccount, String password) {
		super();
		this.nameAccount = nameAccount;
		this.password = password;
	}
	
	public Account(String nameAccount,String gmail, String password) {
		super();
		this.nameAccount = nameAccount;
		this.gmail = gmail;
		this.password = password;
	}
	
	public String getNameAccount() {
		return nameAccount;
	}
	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
}
