package atm;

import java.util.Scanner;

public class Atm {

	private final int JOIN = 1;
	private final int LEAVE = 2;
	private final int LOGIN = 3;
	private final int LOGOUT = 4;
	private final int CREATE_ACC = 5;
	private final int DELETE_ACC = 6;
	private final int VIEW_BALANCE = 7;
	private final int INPUT_MONEY = 8;
	private final int OUT_MONEY = 9;
	private final int MOVE_MONEY = 10;
	private final int SAVE_FILE = 11;
	private final int LOAD_FILE = 12;
	private final int QUIT = 13;

	public static final Scanner scan = new Scanner(System.in);

	private String brandName;

	private UserManager userManager;
	private AccountManager accManager;
	private FileManager fileManager;

	public Atm(String brandName) {
		this.brandName = brandName;

		this.userManager = UserManager.getInstance();
		this.accManager = AccountManager.getInstance();
		this.fileManager = FileManager.getInstance();
	}

	private void printMenu() {
		System.out.printf("--- %s BANK ---\n", this.brandName);
		System.out.println("[01]회원가입");
		System.out.println("[02]회원탈퇴");
		System.out.println("[03]로그인");
		System.out.println("[04]로그아웃");
		System.out.println("[05]계좌개설");
		System.out.println("[06]계좌철회");
		System.out.println("[07]계좌조회");
		System.out.println("[08]입금");
		System.out.println("[09]출금");
		System.out.println("[10]송금");
		System.out.println("[11]파일저장");
		System.out.println("[12]파일로드");
		System.out.println("[13]종료");
	}

	private void printAlldata() {
		for (User1 user : userManager.getList()) {
			System.out.println(user);
		}
	}

	public void run() {
		while (true) {
			printMenu();
			int sel = selectMenu("메뉴");
			if (sel == JOIN) {
				userManager.joinUser();}
			else if (sel == LEAVE) {
				userManager.leaveUser();}
			else if (sel == LOGIN) {
				int loginNum = userManager.loginUser();}
			else if (sel == LOGOUT) {
				int logoutNum = userManager.logoutUser();}
//			else if (sel == CREATE_ACC) {
//				accManager.createAcc();
//			}
//			else if (sel == DELETE_ACC) {
//				accManager.deleteAcc();
//			}
//			else if (sel == VIEW_BALANCE) {
//				accManager.viewBalance();
//			}
//			else if (sel == INPUT_MONEY) {
//				accManager.inputMoney();
//			}
//			else if (sel == OUT_MONEY) {
//				accManager.outMoney();
//			}
//			else if (sel == MOVE_ACC) {
//				accManager.moveMoney();
//			}
//			else if (sel == SAVE_FILE) {
//				fileManager.saveFile();
//			}
//			else if (sel == LOAD_FILE) {
//				fileManager.loadFile();
//			}
			else if (sel == QUIT) {
				break;
			}
		
		

		}

	}

	private int selectMenu(String msg) {
		System.out.print(msg + " : ");
		String input = this.scan.next();

		int result = -1;
		try {
			result = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("번호를 다시 입력해 주세요.");
		}
	
		return result;
	// github testing
	}

}