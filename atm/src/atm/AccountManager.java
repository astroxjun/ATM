package atm;

import java.util.ArrayList;

public class AccountManager {

	private ArrayList<Account> list = new ArrayList<>();

	private AccountManager() {
	}

	private static AccountManager instance = new AccountManager();

	public static AccountManager getInstance() {
		return instance;
	}

}
