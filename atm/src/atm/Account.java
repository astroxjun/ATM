package atm;

public class Account {

	private int userCode;
	private int accNumber;
	private int accPassword;
	private int money;

	public Account(int userCode, int accNumber, int accPassword) {
		this.userCode = userCode;
		this.accNumber = accNumber;
		this.accPassword = accPassword;
	}

	public Account(int userCode, int accNumber, int accPassword, int money) {
		this.userCode = userCode;
		this.accNumber = accNumber;
		this.accPassword = accPassword;
		this.money = money;
	}

	public int getUsercode() {
		return this.userCode;
	}

	public int getAccNumber() {
		return this.accNumber;
	}

	public int getAccPassword() {
		return this.accPassword;
	}

	public void setAccPassword(int accPassword) {
		this.accPassword = accPassword;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public String toString() {
		return String.format("%d(%d) : %d", this.accNumber, this.accPassword, this.money);
	}

}
