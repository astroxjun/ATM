package atm;

import java.util.ArrayList;

public class AccountManager {
	
	private int accountNum;
	
	public int getAccountNum() {
		return this.accountNum;
	}

	private ArrayList<Account> list = new ArrayList<>();

	private AccountManager() {
		
	}
	
	public void createAcc() {
		while(true) {
			if(UserManager.log==-1) {
				System.out.println("로그인 후 이용 가능합니다.");
				break;
			} else {
				int accountNumber= generateRandomAccount();
			}
		}
	}
	
	private int generateRandomAccount() {
		int code = 0;
		
		while(true) {
			code = (int)(Math.random()*900000)+100000;
			
			boolean dupl = false;
			for(Account user : this.list) {
				
			}
		}
	}

	private static AccountManager instance = new AccountManager();

	public static AccountManager getInstance() {
		return instance;
	}
	
	
	

}
